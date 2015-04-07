package com.kihlberg.framework.astronomy;

import com.kihlberg.framework.astronomy.calculator.SunMoonCalculator;
import com.kihlberg.framework.time.UTCDateTime;

/**
 * Created by root on 3/16/15.
 */
public class AstronomyProvider implements IAstronomyProvider {
    private ITimeProvider timeProvider;
    private ILocationProvider locationProvider;

    @Override
    public SunPosition GetSunPosition() {
        SunMoonCalculator calc = GetPreCalculatedCalculator();
        return new SunPosition(calc.degSunEl,calc.degSunAz);
    }

    @Override
    public MoonPosition GetMoonPosition() {
        SunMoonCalculator calc = GetPreCalculatedCalculator();
        return new MoonPosition(calc.degMoonEl,calc.degMoonAz, calc.moonAge);
    }

    public SunMoonCalculator GetPreCalculatedCalculator(){
        UTCDateTime dateTime = timeProvider.GetTime();
        LocationInfo location = locationProvider.GetLocation();
        try {
            SunMoonCalculator calc = new SunMoonCalculator(dateTime, location.getLongitude(), location.getLatitude());
            calc.calcSunAndMoon();
            return calc;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public AstronomyProvider(ITimeProvider timeProvider, ILocationProvider locationProvider) {
        this.timeProvider = timeProvider;
        this.locationProvider = locationProvider;
    }

}
