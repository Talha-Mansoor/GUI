//Talha Mansoor
//kgy284
//11346490
//Assignment 4
package com.example.a4;

public class InteractionModel {
    private double worldRotation = 0.0;
    public double MAX_ROTATION_SPEED = Math.PI / 100; // Define the max speed
    private double rotationIncrement = MAX_ROTATION_SPEED * 0.5; // Default to half of the max speed

    public void updateWorldRotation() {
        worldRotation += rotationIncrement;
        worldRotation %= (2 * Math.PI); // Keep the angle within 0 to 2*PI
    }

    // Setter method for rotation increment
    public void setRotationIncrement(double newIncrement) {
        this.rotationIncrement = newIncrement;
    }

    public double getWorldRotation() {
        return worldRotation;
    }
    // Method to set the rotation speed
    public void setRotationSpeed(double speed) {
        // Assuming the speed is a fraction of the maximum rotation speed
        double newRotationIncrement = MAX_ROTATION_SPEED * speed;
        this.rotationIncrement = newRotationIncrement;
    }
}
