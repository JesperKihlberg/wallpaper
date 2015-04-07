package com.kihlberg.framework.astronomy;

/**
 * Created by root on 3/17/15.
 */
public abstract class AstronomyElementPosition {
    protected double Height;
    protected double Orientation;

    public double getHeight() {
        return Height;
    }

    public double getOrientation() {
        return Orientation;
    }

    protected AstronomyElementPosition(double height, double orientation) {
        Height = height;
        Orientation = orientation;
    }
}
