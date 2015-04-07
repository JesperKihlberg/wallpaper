package com.kihlberg.framework.astronomy;

/**
 * Created by root on 3/16/15.
 */
public class SunPosition extends AstronomyElementPosition {


private double sunAz, sunEl, sunRise, sunSet, sunTransit, sunTransitElev, sunDist;

public SunPosition(double height, double orientation) {
        super(height, orientation);
    }

}
