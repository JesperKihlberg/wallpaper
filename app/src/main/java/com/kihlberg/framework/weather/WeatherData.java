package com.kihlberg.framework.weather;

/**
 * Created by root on 3/17/15.
 */
public class WeatherData {

    private PrecipitationType  precipitationType;

    public PrecipitationType GetPrecipitationType() {
        return precipitationType;
    }

    private PrecipitationIntensity  precipitationIntensity;

    public PrecipitationIntensity GetPrecipitationIntensity() {
        return precipitationIntensity;
    }

    private CloudCover  cloudCover;

    public CloudCover GetCloudCover() {
        return cloudCover;
    }

    private boolean  thunder;

    public boolean GetThunder() {
        return thunder;
    }

    public WeatherData(CloudCover cloudCover, PrecipitationType precipitationType, PrecipitationIntensity precipitationIntensity, boolean  thunder) {
        this.precipitationType = precipitationType;
        this.precipitationIntensity = precipitationIntensity;
        this.cloudCover = cloudCover;
        this.thunder=thunder;
    }

    public WeatherData(int cloudCover, PrecipitationType precipitationType, int precipitationIntensity, int  thunder) {
        this.precipitationType = precipitationType;
        this.precipitationIntensity =PrecipitationIntensity.values()[precipitationIntensity];
        this.cloudCover = CloudCover.values()[cloudCover];
        this.thunder=thunder==1;
    }
}
