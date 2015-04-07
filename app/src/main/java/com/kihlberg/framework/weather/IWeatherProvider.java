package com.kihlberg.framework.weather;

/**
 * Created by root on 3/16/15.
 */
public interface IWeatherProvider {
    public CloudCover GetCloudCover();
    public Precipitation GetPrecipitation();
    public boolean GetThunder();
}
