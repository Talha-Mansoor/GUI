//Talha Mansoor
//kgy284
//11346490
//Assignment 4
package com.example.a4;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
public class CursorView extends SpaceView {

    public CursorView(SpaceModel model, int size) {
        super(model, size);
    }

    @Override
    public void draw() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.save();

        // Clear the canvas
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, getWidth(), getHeight());

        // Calculate the top-left corner of the zoomed-in area
        final double zoomLevel = 2.0;
        double viewportWidth = getWidth() / zoomLevel;
        double viewportHeight = getHeight() / zoomLevel;
        double viewportX = cursorX * getWidth() - viewportWidth / 2;
        double viewportY = cursorY * getHeight() - viewportHeight / 2;

        // Clip the visible area and scale up to achieve the zoom effect
        gc.rect(0, 0, getWidth(), getHeight());
        gc.clip();
        gc.scale(zoomLevel, zoomLevel);
        gc.translate(-viewportX, -viewportY);

        // Draw the view based on the main view's cursor position, but without the rotation applied
        super.draw();  // Calls draw method of SpaceView

        gc.restore();
    }
}