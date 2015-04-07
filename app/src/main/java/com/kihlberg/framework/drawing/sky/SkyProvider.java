package com.kihlberg.framework.drawing.sky;

import android.graphics.Color;

import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.weather.IWeatherProvider;

/**
 * Created by root on 3/16/15.
 */
public class SkyProvider implements ISkyProvider {
    private IAstronomyProvider _astronomyProvider;
    private IWeatherProvider _weatherProvider;

    public SkyProvider(IAstronomyProvider astronomyProvider, IWeatherProvider weatherProvider) {
        _astronomyProvider = astronomyProvider;
        _weatherProvider = weatherProvider;
    }

    @Override
    public Sky GetSky() {
        return new Sky(Color.rgb(150, 150, 255));
    }
}
