package com.kihlberg.framework.astronomy;

/**
 * Created by root on 3/16/15.
 */
public interface IAstronomyProvider {
    public SunPosition GetSunPosition();

    public MoonPosition GetMoonPosition();
}
