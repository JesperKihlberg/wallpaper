package com.kihlberg.framework.weather;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 3/17/15.
 */
public class YrDataParser {
    private static Map<Integer, WeatherData> weatherDataMap;

    public YrDataParser() {
        weatherDataMap = new HashMap<Integer, WeatherData>();
        weatherDataMap.put(1, new WeatherData(0, PrecipitationType.none, 0, 0));
        weatherDataMap.put(2, new WeatherData(1, PrecipitationType.none, 0, 0));
        weatherDataMap.put(3, new WeatherData(2, PrecipitationType.none, 0, 0));
        weatherDataMap.put(4, new WeatherData(3, PrecipitationType.none, 0, 0));
        weatherDataMap.put(40, new WeatherData(2, PrecipitationType.rain, 1, 0));
        weatherDataMap.put(5, new WeatherData(2, PrecipitationType.rain, 2, 0));
        weatherDataMap.put(41, new WeatherData(2, PrecipitationType.rain, 3, 0));
        weatherDataMap.put(24, new WeatherData(2, PrecipitationType.rain, 1, 1));
        weatherDataMap.put(6, new WeatherData(2, PrecipitationType.rain, 2, 1));
        weatherDataMap.put(25, new WeatherData(2, PrecipitationType.rain, 3, 1));
        weatherDataMap.put(42, new WeatherData(2, PrecipitationType.sleet, 1, 0));
        weatherDataMap.put(7, new WeatherData(2, PrecipitationType.sleet, 2, 0));
        weatherDataMap.put(43, new WeatherData(2, PrecipitationType.sleet, 3, 0));
        weatherDataMap.put(26, new WeatherData(2, PrecipitationType.sleet, 1, 1));
        weatherDataMap.put(20, new WeatherData(2, PrecipitationType.sleet, 2, 1));
        weatherDataMap.put(27, new WeatherData(2, PrecipitationType.sleet, 3, 1));
        weatherDataMap.put(44, new WeatherData(2, PrecipitationType.snow, 1, 0));
        weatherDataMap.put(8, new WeatherData(2, PrecipitationType.snow, 2, 0));
        weatherDataMap.put(45, new WeatherData(2, PrecipitationType.snow, 3, 0));
        weatherDataMap.put(28, new WeatherData(2, PrecipitationType.snow, 1, 1));
        weatherDataMap.put(21, new WeatherData(2, PrecipitationType.snow, 2, 1));
        weatherDataMap.put(29, new WeatherData(2, PrecipitationType.snow, 3, 1));
        weatherDataMap.put(46, new WeatherData(3, PrecipitationType.rain, 1, 0));
        weatherDataMap.put(9, new WeatherData(3, PrecipitationType.rain, 2, 0));
        weatherDataMap.put(10, new WeatherData(3, PrecipitationType.rain, 3, 0));
        weatherDataMap.put(30, new WeatherData(3, PrecipitationType.rain, 1, 1));
        weatherDataMap.put(22, new WeatherData(3, PrecipitationType.rain, 2, 1));
        weatherDataMap.put(11, new WeatherData(3, PrecipitationType.rain, 3, 1));
        weatherDataMap.put(47, new WeatherData(3, PrecipitationType.sleet, 1, 0));
        weatherDataMap.put(12, new WeatherData(3, PrecipitationType.sleet, 2, 0));
        weatherDataMap.put(48, new WeatherData(3, PrecipitationType.sleet, 3, 0));
        weatherDataMap.put(31, new WeatherData(3, PrecipitationType.sleet, 1, 1));
        weatherDataMap.put(23, new WeatherData(3, PrecipitationType.sleet, 2, 1));
        weatherDataMap.put(32, new WeatherData(3, PrecipitationType.sleet, 3, 1));
        weatherDataMap.put(49, new WeatherData(3, PrecipitationType.snow, 1, 0));
        weatherDataMap.put(13, new WeatherData(3, PrecipitationType.snow, 2, 0));
        weatherDataMap.put(50, new WeatherData(3, PrecipitationType.snow, 3, 0));
        weatherDataMap.put(33, new WeatherData(3, PrecipitationType.snow, 1, 1));
        weatherDataMap.put(14, new WeatherData(3, PrecipitationType.snow, 2, 1));
        weatherDataMap.put(34, new WeatherData(3, PrecipitationType.snow, 3, 1));
        weatherDataMap.put(15, new WeatherData(4, PrecipitationType.none, 0, 0));
    }

    public WeatherData ParseData(String data) {
        String numEx = "numberEx=\"";
        if(data.contains(numEx)) {
            String remainingData = data.split(numEx)[1];
            String number = remainingData.split("\"")[0];
            int result = 0;
            if(tryParseInt(number)){
                result=Integer.parseInt(number);
            }
            if(weatherDataMap.containsKey(result)){
                return weatherDataMap.get(result);
            }
        }
        return new WeatherData(CloudCover.clear,PrecipitationType.none,  PrecipitationIntensity.none, false);
    }

    boolean tryParseInt(String value)
    {
        try
        {
            Integer.parseInt(value);
            return true;
        } catch(NumberFormatException nfe)
        {
            return false;
        }
    }
}
