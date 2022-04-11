package cz.samelanius.rotator.bot.core.communication.screenparsing;

import com.google.common.eventbus.EventBus;
import cz.samelanius.rotator.bot.events.EventBusHolder;
import cz.samelanius.rotator.bot.events.LogMessage;
import cz.samelanius.rotator.bot.events.MessageLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenController {
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
    private EventBus bus = EventBusHolder.getEventBus();


    private final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
    private final Dimension MAIN_DISPLAY = TOOLKIT.getScreenSize();
    private Robot robot;

    private Rectangle selectedArea;
    private int squareXCount;
    private int squareYCount;

    public ScreenController() {
        try {
            robot = new Robot();
            robot.setAutoDelay(10);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void init(int squareXCount, int squareYCount) {
        this.squareXCount = squareXCount;
        this.squareYCount = squareYCount;

        prescanBoundaries();
    }

    public RawScreenData readData() {
        RawScreenData data = new RawScreenData();

        data.setRawData(loadDataFromImage());

        return data;
    }

    private String loadDataFromImage() {
        BufferedImage image = robot.createScreenCapture(selectedArea);
        String data = "";

        double squareWidth = (double) image.getWidth() / (double) squareXCount;

        for (int i = 0; i < squareXCount; i++) {
            int x = (int) (squareWidth * (0.5 + i));
            int y = (int) ((image.getHeight() / 2) * (0.5));

            RGBColor color = loadColor(image, x, y);
            if (color.getR() != 0) {
                data += (char) color.getR();
            }
            if (color.getG() != 0) {
                data += (char) color.getG();
            }
            if (color.getB() != 0) {
                data += (char) color.getB();
            }
            //System.out.println("i: " + i + " x: " + x + " y: " + y +" RGB: " + color.getR() + " " + color.getG() +  " " + color.getB() + " - " + (char)color.getR() + " " + (char)color.getG() +  " " + (char)color.getB() );
        }

        return data;
    }

    private void prescanBoundaries() {
        BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, MAIN_DISPLAY.width, 100));

        try {
            ImageIO.write(image, "png", new File("test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int BASE_X = 10;
        int BASE_Y = 10;

        int borderY1 = BASE_Y;
        int borderY2 = BASE_Y;
        int borderX1 = BASE_X;
        int borderX2 = BASE_X;

        for (int y = BASE_Y; y >= 0; y--) {
            if (loadColor(image, BASE_X, y).isYellow()) {
                borderY1 = y + 1;
                break;
            }
        }

        for (int y = BASE_Y; y < image.getHeight(); y++) {
            if (loadColor(image, BASE_X, y).isYellow()) {
                borderY2 = y;
                break;
            }
        }

        for (int x = BASE_X; x >= 0; x--) {


            if (loadColor(image, x, BASE_Y).isYellow()) {
                borderX1 = x + 1;

                break;
            }
        }

        for (int x = BASE_Y; x < image.getWidth(); x++) {
            if (loadColor(image, x, BASE_Y).isYellow()) {
                borderX2 = x;
                break;
            }

        }
        System.out.println(borderX1 + " " + borderX2 + " " + borderY1 + " " + borderY2);
        selectedArea = new Rectangle(borderX1, borderY1, borderX2 - borderX1, borderY2 - borderY1);
        BufferedImage image2 = robot.createScreenCapture(selectedArea);
        try {
            ImageIO.write(image2, "png", new File("test2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected RGBColor loadColor(BufferedImage image, int x, int y) {
        int clr = image.getRGB(x, y);
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;

        return new RGBColor(red, green, blue);
    }

    public void pressAndReleaseKey(int keyCode) {
        System.out.println(sdf.format(new Date()) +  " mackam: " + keyCode);

        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }
}
