//Talha Mansoor
//kgy284
//11346490
//Assignment 4
package com.example.a4;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SpaceView extends Canvas {
    protected final SpaceModel model;
    private double worldRotation = 0.0;
    protected double cursorX = 0.5; // Default cursor position
    protected double cursorY = 0.5;
    public SpaceView(SpaceModel model, int size) {
        super(size, size);
        this.model = model;
        draw();

    }


    public void setCursorPosition(double x, double y) {
        this.cursorX = x;
        this.cursorY = y;
    }
    public void setWorldRotation(double rotation) {
        this.worldRotation = rotation;
    }

    public void draw() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.save(); // Save the current state of the graphics context

        // Clear the canvas
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, getWidth(), getHeight());

        // Apply world rotation
        gc.translate(getWidth() / 2, getHeight() / 2);
        gc.rotate(Math.toDegrees(worldRotation));
        gc.translate(-getWidth() / 2, -getHeight() / 2);

        // Draw stars
        gc.setFill(Color.WHITE);
        for (Star star : model.getStars()) {
            gc.fillOval(star.getX() * getWidth(), star.getY() * getHeight(), 2, 2);
        }

        // Draw asteroids
        gc.setFill(Color.GRAY);
        for (Asteroid asteroid : model.getAsteroids()) {
            double[] xPoints = asteroid.getXPoints().clone(); // Clone the array
            double[] yPoints = asteroid.getYPoints().clone(); // Clone the array

            gc.save(); // Save the state before transforming
            gc.translate(asteroid.getXTranslation() * getWidth(), asteroid.getYTranslation() * getHeight());
            gc.rotate(Math.toDegrees(asteroid.getAngle()));

            // Transform points to canvas coordinates
            for (int i = 0; i < xPoints.length; i++) {
                xPoints[i] *= getWidth();
                yPoints[i] *= getHeight();
            }

            gc.fillPolygon(xPoints, yPoints, xPoints.length);
            gc.restore(); // Restore to the state before transformation
        }

        gc.restore(); // Restore to the original state after all drawing
    }
}
