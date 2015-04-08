package com.kihlberg.framework.astronomy;

/**
 * Created by root on 3/28/15.
 */
public class LocationProvider implements ILocationProvider {

    @Override
    public LocationInfo GetLocation() {
        return new LocationInfo( 55.6896, 12.4796);
    }
}
