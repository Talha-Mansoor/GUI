//Talha Mansoor
//kgy284
//11346490
//Assignment 4

package com.example.a4;

public class SpaceController {
    private final SpaceModel model;
    private final SpaceView view;
    private final InteractionModel interactionModel;
    private final CursorView cursorView;
    private final SpaceView miniatureView;
    private boolean asteroidMovementEnabled = true;
    private boolean asteroidSpinEnabled = true;

    //constructor
    public SpaceController(SpaceModel model, SpaceView view, InteractionModel interactionModel,
                           CursorView cursorView, SpaceView miniatureView) {
        this.model = model;
        this.view = view;
        this.interactionModel = interactionModel;
        this.cursorView = cursorView;
        this.miniatureView = miniatureView;
    }

    //anmation handler that keeps updating frame
    public void handleAnimationTick() {
        if (asteroidMovementEnabled) {
            model.moveAsteroids();
        }
        if (asteroidSpinEnabled) {
            model.spinAsteroids();
        }
        interactionModel.updateWorldRotation();
        view.setWorldRotation(interactionModel.getWorldRotation());
        view.draw();
        cursorView.draw();
        miniatureView.draw();
    }

    public void setAsteroidMovement(boolean enabled) {
        this.asteroidMovementEnabled = enabled;
    }

    public void setAsteroidSpin(boolean enabled) {
        this.asteroidSpinEnabled = enabled;
    }

    public void setRotationSpeed(double sliderValue) {
        double minSpeed = 0.001;  // Minimum rotation speed
        double maxSpeed =  Math.PI;  // Maximum rotation speed, which can be adjusted

        // Calculate the rotation speed using an exponential scale
        double rotationSpeed = minSpeed * Math.pow((maxSpeed / minSpeed), sliderValue);

        // Set the rotation increment in the interaction model
        interactionModel.setRotationIncrement(rotationSpeed);
    }
}
