package cz.samelanius.rotator.bot.gui;

import com.google.common.eventbus.EventBus;
import cz.samelanius.rotator.bot.core.class_packages.ClassPackage;
import cz.samelanius.rotator.bot.core.engine.CoreEngine;
import cz.samelanius.rotator.bot.events.EventBusHolder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application  {

    private PackageHolder packageHolder = new PackageHolder();
    private CoreEngine engine = new CoreEngine();
    private EventBus eventBus = EventBusHolder.getEventBus();
    private RootPanel rootPanel;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        packageHolder = new PackageHolder();
        rootPanel = new RootPanel();

        rootPanel.getStartButton().setOnAction(e -> toggleStart());

        final Scene scene = new Scene(rootPanel.getRootPane());
        final int WINDOW_WIDTH = 500, WINDOW_HEIGHT = 800;

        /* Window setup. */
        stage.setResizable(true);
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    private void toggleStart() {
        if(engine.isRunning()) {
            engine.stop();
            rootPanel.getStartButton().setText("Start");
        } else {
            ClassPackage classPackage = getSelectedPackage();
            if(classPackage != null) {
                engine.start(classPackage);
                rootPanel.getStartButton().setText("Stop");
            }
        }
    }

    private ClassPackage getSelectedPackage() {
        Object value = rootPanel.getComboBox().getValue();
        if(value == null) return null;
        String sValue = (String) value;

        if(sValue.equals("BalanceDruid")) return packageHolder.getBalancedDruidPackage();
        if(sValue.equals("ProtWar")) return packageHolder.getProtWarPackage();
        return null;
    }



}
