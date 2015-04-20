package com.kihlberg.wallpaper.color;

import android.graphics.Color;

import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.astronomy.ISunPosition;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.ITimeProvider;
import com.kihlberg.framework.weather.IWeatherProvider;

/**
 * Created by root on 3/22/15.
 */
public class ColorProvider implements IColorProvider {

    private IAstronomyProvider astronomyProvider;
    private IWeatherProvider weatherProvider;
    private ITimeProvider timeProvider;

    /*
    var times = SunCalc.times = [
            [-0.833, 'sunrise', 'sunset' ],
            [ -0.3, 'sunriseEnd', 'sunsetStart' ],
            [ -6, 'dawn', 'dusk' ],
            [ -12, 'nauticalDawn', 'nauticalDusk'],
            [ -18, 'nightEnd', 'night' ],
            [ 6, 'goldenHourEnd', 'goldenHour' ]
            ];
*/

    @Override
    public int GetSkyColor() {
/*
        ISunPosition sunPostion = astronomyProvider.GetSunPosition();

        //night
        if(sunPostion.getHeight() < -18 )
        {
            return GetSkyNightColor();
        }
        if(timeProvider.IsMorning()) {
            if (sunPostion.getHeight() < -12) {
                return GetSkyNauticalDawnColor();
            }
            if (sunPostion.getHeight() < -6) {
                return GetSkyDawnColor();
            }
            if (sunPostion.getHeight() < -0.833) {
                return GetSkySunriseColor();
            }
            if (sunPostion.getHeight() < -0.3) {
                return GetSkySunriseEndColor();
            }
        }
        else {
            if (sunPostion.getHeight() < -12) {
                return GetSkyNauticalDuskColor();
            }
            if (sunPostion.getHeight() < -6) {
                return GetSkyDuskColor();
            }
            if (sunPostion.getHeight() < -0.833) {
                return GetSkySunsetColor();
            }
            if (sunPostion.getHeight() < -0.3) {
                return GetSkySunsetStartColor();
            }
        }
*/
        return GetSkyDayColor();
    }

    @Override
    public int GetSunColor() {
        return Color.YELLOW;
    }

    @Override
    public int GetMoonColor() {
        return Color.WHITE;
    }

    @Override
    public int GetGroundColor() {
        int redPart = (int) (10 + Math.random()*40);
        int greenPart = (int) (180 + Math.random()*60);
        int bluePart = (int) (15 + Math.random()*40);
        return Color.rgb(redPart,greenPart,bluePart);
    }

    @Override
    public int GetRoofColor() {
        return Color.RED;
    }

    @Override
    public int GetSmallBuildingColor1() {
        return Color.WHITE;
    }

    @Override
    public int GetSmallBuildingColor2() {
        return Color.rgb(230,230,230
        );
    }

    @Override
    public int GetTreeCrownColor() {
        return Color.rgb(20, (int) (100 + Math.random()*20),20);
    }

    @Override
    public int GetTreeTrunkColor() {
        return Color.BLACK;
    }

    private int GetSkySunsetStartColor() {
        return Color.rgb(51, 139, 183);
    }

    private int GetSkySunsetColor() {
        return Color.rgb(19, 92, 128);
    }

    private int GetSkyDuskColor() {
        return Color.rgb(5, 40, 57);
    }

    private int GetSkyNauticalDuskColor() {
        return Color.rgb(0, 31, 47);
    }

    private int GetSkySunriseEndColor() {
        return Color.rgb(51, 139, 183);
    }

    private int GetSkySunriseColor() {
        return Color.rgb(19, 92, 128);
    }

    private int GetSkyDawnColor() {
        return Color.rgb(5, 40, 57);
    }

    private int GetSkyNauticalDawnColor() {
        return Color.rgb(0, 31, 47);
    }

    private int GetSkyDayColor() {
        return Color.rgb(96, 178, 219);
    }

    private int GetSkyNightColor() {
        return Color.rgb(0, 10, 17);
    }

    public ColorProvider(IWeatherProvider weatherProvider, IAstronomyProvider astronomyProvider, ITimeProvider timeProvider) {
        this.weatherProvider = weatherProvider;
        this.astronomyProvider = astronomyProvider;
        this.timeProvider = timeProvider;
    }
}
