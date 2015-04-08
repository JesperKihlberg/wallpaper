package com.kihlberg.framework.astronomy;

/**
 * Created by root on 3/16/15.
 */
public interface IAstronomyProvider {
    public ISunPosition GetSunPosition();

    public IMoonPosition GetMoonPosition();
}
