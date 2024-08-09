package com.youcefmei.controllers;

import com.youcefmei.fx.Floor;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class MainController implements Initializable {

    @FXML
    ComboBox<String> comboFloorNb;

//    @FXML
//    Rectangle floor1;
//
//    @FXML
//    Rectangle floor2;
//
//    @FXML
//    Rectangle floor3;


//    @FXML
//    Cylinder beam1;
//
//    @FXML
//    Cylinder beam2;
//
//    @FXML
//    Cylinder beam3;

    @FXML
    VBox col1;

    @FXML
    VBox col2;

    @FXML
    VBox col3;

    ArrayList<Rectangle> floors = new ArrayList<Rectangle>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboFloorNb.getItems().addAll("3", "4", "5", "6", "7");
        for ( int i = 0; i < 3 ; i++ ) {
            Floor floor = new Floor(i);
            floors.add(floor.getRect());
            col1.getChildren().add(0, floor.getRect());
        }

    }


    @FXML
    void handleFloorNB(ActionEvent event) throws InterruptedException {

        int nbFloor = Integer.parseInt(comboFloorNb.getValue());
        int delay = 500;
        Timer timer = new Timer();

        floors.clear();
        col3.getChildren().clear();
        for ( int i = 0; i < nbFloor ; i++ ) {
            Floor floor = new Floor(i);
            floors.add(floor.getRect());
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            col3.getChildren().add(0, floor.getRect());
                        }
                    });
                }
            };

            timer.schedule(timerTask, (long) delay * i);
        }

    }





}
