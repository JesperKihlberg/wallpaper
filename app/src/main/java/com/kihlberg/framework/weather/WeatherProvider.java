package com.kihlberg.framework.weather;

/**
 * Created by root on 3/16/15.
 */
public class WeatherProvider implements IWeatherProvider {


    
    @Override
    public CloudCover GetCloudCover() {
    return null;
    }

    @Override
    public Precipitation GetPrecipitation() {
        return null;
    }

    @Override
    public boolean GetThunder() {
        return false;
    }
}
