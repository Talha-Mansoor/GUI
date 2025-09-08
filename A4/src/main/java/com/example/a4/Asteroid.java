//Talha Mansoor
//kgy284
//11346490
//Assignment 4
package com.example.a4;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import java.util.Random;

public class Asteroid {
    private final double[] xPoints;
    private final double[] yPoints;
    private final double radius;
    private double xTranslation;
    private double yTranslation;
    private double angle;
    private double xVelocity;
    private double yVelocity;
    private double aVelocity; // Angular velocity for spinning

    private static final double MIN_RADIUS = 0.02; // Minimum radius for an asteroid
    private static final double MAX_RADIUS = 0.05; // Maximum radius for an asteroid
    private static final double MAX_VELOCITY = 0.001; // Maximum velocity for an asteroid
    private static final double MAX_ANGULAR_VELOCITY = Math.PI /100; // Maximum angular velocity for spinning
    private Canvas bitmapCanvas;
    private WritableImage writableImage;
    private PixelReader pixelReader;
    public Asteroid() {
        Random rand = new Random();
        this.xTranslation = rand.nextDouble();
        this.yTranslation = rand.nextDouble();
        this.radius = MIN_RADIUS + (MAX_RADIUS - MIN_RADIUS) * rand.nextDouble();
        this.angle = 0; // Initial angle
        // Random initial velocities
        this.xVelocity = (rand.nextDouble() * 2 - 1) * MAX_VELOCITY;
        this.yVelocity = (rand.nextDouble() * 2 - 1) * MAX_VELOCITY;
        this.aVelocity = (rand.nextDouble() * 2 - 1) * MAX_ANGULAR_VELOCITY;

        // Choose number of points between 4 and 8
        int pointsCount = rand.nextInt(5) + 4; // 4 to 8 points
        xPoints = new double[pointsCount];
        yPoints = new double[pointsCount];
        // Create the polygon points
        for (int i = 0; i < pointsCount; i++) {
            double sectionRadius = radius * (0.8 + 0.4 * rand.nextDouble()); // Randomize the radius for the section
            double angle = 2 * Math.PI / pointsCount * i;
            xPoints[i] = sectionRadius * Math.cos(angle);
            yPoints[i] = sectionRadius * Math.sin(angle);
        }
    }

    // Method to update the asteroid's position and rotation
    public void update() {
        xTranslation += xVelocity;
        yTranslation += yVelocity;
        angle += aVelocity;

        // Ensure the asteroid wraps around the screen
        if (xTranslation < 0) xTranslation += 1;
        if (xTranslation > 1) xTranslation -= 1;
        if (yTranslation < 0) yTranslation += 1;
        if (yTranslation > 1) yTranslation -= 1;
    }

    // Getters and setters for the properties
    public double getXTranslation() { return xTranslation; }
    public void setXTranslation(double x) { xTranslation=x; }
    public double getYTranslation() { return yTranslation; }
    public void setYTranslation(double y) { yTranslation=y; }
    public double getAngle() { return angle; }
    public double[] getXPoints() { return xPoints; }
    public double[] getYPoints() { return yPoints; }
    public double getRadius() { return radius; }


    //move asteroid and warp around screen
    public void updatePosition() {
        xTranslation += xVelocity;
        yTranslation += yVelocity;

        // Wrap around logic
        if (xTranslation < 0) xTranslation += 1;
        if (xTranslation > 1) xTranslation -= 1;
        if (yTranslation < 0) yTranslation += 1;
        if (yTranslation > 1) yTranslation -= 1;
    }

    // Update the asteroid's spin
    public void updateSpin() {
        angle += aVelocity;

        // Normalize the angle
        angle %= (2 * Math.PI);
    }

}
