package com.example.a4;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Star {
    private final DoubleProperty x = new SimpleDoubleProperty();
    private final DoubleProperty y = new SimpleDoubleProperty();

    public Star(double x, double y) {
        this.x.set(x);
        this.y.set(y);
    }

    // Getters for the properties
    public double getX() { return x.get(); }
    public double getY() { return y.get(); }
    public DoubleProperty xProperty() { return x; }
    public DoubleProperty yProperty() { return y; }
}