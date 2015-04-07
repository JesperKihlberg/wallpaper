package com.kihlberg.framework.astronomy;

/**
 * Created by root on 4/1/15.
 */
public class MoonPosition extends AstronomyElementPosition {

    private double moonAge;

    public double getMoonAge() {
        return moonAge;
    }

    protected MoonPosition(double height, double orientation, double moonAge) {
        super(height, orientation);
        this.moonAge = moonAge;
    }

}
