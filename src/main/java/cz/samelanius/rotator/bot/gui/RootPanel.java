package cz.samelanius.rotator.bot.gui;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cz.samelanius.rotator.bot.events.CommunicationDataEvent;
import cz.samelanius.rotator.bot.events.EventBusHolder;
import cz.samelanius.rotator.bot.events.LogMessage;
import cz.samelanius.rotator.bot.events.MessageLevel;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import lombok.Getter;

public class RootPanel {
    @Getter
    private BorderPane rootPane;
    @Getter
    private Button startButton;
    @Getter
    private ComboBox<Object> comboBox;
    @Getter
    private TextArea textArea1;
    @Getter
    private TextArea textArea2;
    @Getter
    private TextArea textAreaCentral;

    private EventBus eventBus = EventBusHolder.getEventBus();


    public RootPanel() {
        eventBus.register(this);
        create();
    }

    public void create() {

        rootPane = new BorderPane();
        rootPane.setTop(createTopPanel());
        rootPane.setCenter(createCenterPanel());

        /* CSS stylesheets. */
    }

    private Node createCenterPanel() {
        GridPane pane = new GridPane();
        textArea1 = new TextArea();
        textArea2 = new TextArea();
        textAreaCentral = new TextArea();
        textArea2.setWrapText(true);


        pane.add(textAreaCentral, 0, 0, 2, 1);
        pane.add(textArea1, 0, 1);
        pane.add(textArea2, 1, 1);

        textArea2.setPrefHeight(600);
        pane.setPrefHeight(800);

        return pane;
    }

    private Node createTopPanel() {
        HBox panel = new HBox();

        comboBox = new ComboBox<>();
        comboBox.getItems().add("ProtWar");
        comboBox.getItems().add("BalanceDruid");

        panel.getChildren().add(comboBox);

        startButton = new Button("Start");

        panel.getChildren().add(startButton);
        return panel;

    }

    @Subscribe
    private void listenConsoleMessage(LogMessage event) {
        MessageLevel actualLevel = MessageLevel.DEBUG;

        if (actualLevel.getLevel() <= event.getLevel().getLevel()) {
            textAreaCentral.appendText(event.getLevel().getPrefix() + " " + event.getMessage());
        }
    }

    @Subscribe
    private void listenCommunicationMessage(CommunicationDataEvent event) {
        double ta1scroll = textArea1.getScrollTop();
        double ta2scroll = textArea2.getScrollTop();

        textArea1.setText(event.getDebugMessage1());
        textArea2.setText(event.getDebugMessage2());

        textArea1.setScrollTop(ta1scroll);
        textArea2.setScrollTop(ta2scroll);
    }

}
