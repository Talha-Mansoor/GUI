//Talha Mansoor
//kgy284
//11346490
//Assignment 4
package com.example.a4;

import javafx.geometry.Orientation;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class ControlPanelView extends VBox {
    public ControlPanelView(SpaceController controller) {
        Label label = new Label("Controls");
        //slider
        Slider rotationSpeedSlider = new Slider(0, 1, 0.5);
        rotationSpeedSlider.setOrientation(Orientation.HORIZONTAL);
        rotationSpeedSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            controller.setRotationSpeed(newValue.doubleValue());
        });

        //checkbox for asteroid movement
        CheckBox asteroidMovementCheckBox = new CheckBox("Asteroid Movement");
        asteroidMovementCheckBox.setSelected(true);
        asteroidMovementCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            controller.setAsteroidMovement(newValue);
        });


        CheckBox asteroidSpinCheckBox = new CheckBox("Asteroid Spin");
        asteroidSpinCheckBox.setSelected(true);
        asteroidSpinCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            controller.setAsteroidSpin(newValue);
        });

        this.getChildren().addAll(label, rotationSpeedSlider, asteroidMovementCheckBox, asteroidSpinCheckBox);
    }
}
