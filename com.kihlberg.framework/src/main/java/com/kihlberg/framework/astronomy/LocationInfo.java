package com.kihlberg.framework.astronomy;

/**
 * Created by root on 3/28/15.
 */
public class LocationInfo {
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LocationInfo(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
