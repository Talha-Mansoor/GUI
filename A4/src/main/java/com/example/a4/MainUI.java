//Talha Mansoor
//kgy284
//11346490
//Assignment 4
package com.example.a4;

import javafx.animation.AnimationTimer;

class MainUI {
    private final SpaceController controller;
    private AnimationTimer timer;

    public MainUI(SpaceModel model, SpaceView view, CursorView cursorView, SpaceView miniatureView, SpaceController controller) {
        this.controller = controller;
        setupAnimationTimer();
    }


    //amo,animation timer
    private void setupAnimationTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.handleAnimationTick();
            }
        };
        timer.start();
    }
}
