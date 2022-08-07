package cz.samelanius.rotator.bot.gui;

import cz.samelanius.rotator.bot.core.classpackages.ClassPackage;
import cz.samelanius.rotator.bot.core.engine.CoreEngine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application  {

    private PackageHolder packageHolder = new PackageHolder();
    private CoreEngine engine = new CoreEngine();
    private RootPanel rootPanel;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        packageHolder = new PackageHolder();
        rootPanel = new RootPanel();

        rootPanel.getStartButton().setOnAction(e -> toggleStart());

        final Scene scene = new Scene(rootPanel.getRootPane());
        final int WINDOW_WIDTH = 500;
        final int WINDOW_HEIGHT = 800;

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
            engine.start();
            rootPanel.getStartButton().setText("Stop");

        }
    }
}
