package com.kihlberg.framework.weather;

import junit.framework.TestCase;

public class YrDataParserTest extends TestCase {

    public void testParseData1() throws Exception {
        testParseData(1, new WeatherData(0, PrecipitationType.none, 0, 0));
    }
    public void testParseData2() throws Exception {
    testParseData(2, new WeatherData(1, PrecipitationType.none, 0, 0));
    }
    public void testParseData3() throws Exception {
    testParseData(3, new WeatherData(2, PrecipitationType.none, 0, 0));
    }
    public void testParseData4() throws Exception {
    testParseData(4, new WeatherData(3, PrecipitationType.none, 0, 0));
    }
    public void testParseData40() throws Exception {
    testParseData(40, new WeatherData(2, PrecipitationType.rain, 1, 0));
    }
    public void testParseData5() throws Exception {
    testParseData(5, new WeatherData(2, PrecipitationType.rain, 2, 0));
    }
    public void testParseData41() throws Exception {
    testParseData(41, new WeatherData(2, PrecipitationType.rain, 3, 0));
    }
    public void testParseData24() throws Exception {
    testParseData(24, new WeatherData(2, PrecipitationType.rain, 1, 1));
    }
    public void testParseData6() throws Exception {
    testParseData(6, new WeatherData(2, PrecipitationType.rain, 2, 1));
    }
    public void testParseData25() throws Exception {
    testParseData(25, new WeatherData(2, PrecipitationType.rain, 3, 1));
    }
    public void testParseData42() throws Exception {
    testParseData(42, new WeatherData(2, PrecipitationType.sleet, 1, 0));
    }
    public void testParseData7() throws Exception {
    testParseData(7, new WeatherData(2, PrecipitationType.sleet, 2, 0));
    }
    public void testParseData43() throws Exception {
    testParseData(43, new WeatherData(2, PrecipitationType.sleet, 3, 0));
    }
    public void testParseData26() throws Exception {
    testParseData(26, new WeatherData(2, PrecipitationType.sleet, 1, 1));
    }
    public void testParseData20() throws Exception {
    testParseData(20, new WeatherData(2, PrecipitationType.sleet, 2, 1));
    }
    public void testParseData27() throws Exception {
    testParseData(27, new WeatherData(2, PrecipitationType.sleet, 3, 1));
    }
    public void testParseData44() throws Exception {
    testParseData(44, new WeatherData(2, PrecipitationType.snow, 1, 0));
    }
    public void testParseData8() throws Exception {
    testParseData(8, new WeatherData(2, PrecipitationType.snow, 2, 0));
    }
    public void testParseData45() throws Exception {
    testParseData(45, new WeatherData(2, PrecipitationType.snow, 3, 0));
    }
    public void testParseData28() throws Exception {
    testParseData(28, new WeatherData(2, PrecipitationType.snow, 1, 1));
    }
    public void testParseData21() throws Exception {
    testParseData(21, new WeatherData(2, PrecipitationType.snow, 2, 1));
    }
    public void testParseData29() throws Exception {
    testParseData(29, new WeatherData(2, PrecipitationType.snow, 3, 1));
    }
    public void testParseData46() throws Exception {
    testParseData(46, new WeatherData(3, PrecipitationType.rain, 1, 0));
    }
    public void testParseData9() throws Exception {
    testParseData(9, new WeatherData(3, PrecipitationType.rain, 2, 0));
    }
    public void testParseData10() throws Exception {
    testParseData(10, new WeatherData(3, PrecipitationType.rain, 3, 0));
    }
    public void testParseData30() throws Exception {
    testParseData(30, new WeatherData(3, PrecipitationType.rain, 1, 1));
    }
    public void testParseData22() throws Exception {
    testParseData(22, new WeatherData(3, PrecipitationType.rain, 2, 1));
    }
    public void testParseData11() throws Exception {
    testParseData(11, new WeatherData(3, PrecipitationType.rain, 3, 1));
    }
    public void testParseData47() throws Exception {
    testParseData(47, new WeatherData(3, PrecipitationType.sleet, 1, 0));
    }
    public void testParseData12() throws Exception {
    testParseData(12, new WeatherData(3, PrecipitationType.sleet, 2, 0));
    }
    public void testParseData48() throws Exception {
    testParseData(48, new WeatherData(3, PrecipitationType.sleet, 3, 0));
    }
    public void testParseData31() throws Exception {
    testParseData(31, new WeatherData(3, PrecipitationType.sleet, 1, 1));
    }
    public void testParseData23() throws Exception {
    testParseData(23, new WeatherData(3, PrecipitationType.sleet, 2, 1));
    }
    public void testParseData32() throws Exception {
    testParseData(32, new WeatherData(3, PrecipitationType.sleet, 3, 1));
    }
    public void testParseData49() throws Exception {
    testParseData(49, new WeatherData(3, PrecipitationType.snow, 1, 0));
    }
    public void testParseData13() throws Exception {
    testParseData(13, new WeatherData(3, PrecipitationType.snow, 2, 0));
    }
    public void testParseData50() throws Exception {
    testParseData(50, new WeatherData(3, PrecipitationType.snow, 3, 0));
    }

    public void testParseData33() throws Exception {
    testParseData(33, new WeatherData(3, PrecipitationType.snow, 1, 1));
    }
    public void testParseData14() throws Exception {
    testParseData(14, new WeatherData(3, PrecipitationType.snow, 2, 1));
    }
    public void testParseData34() throws Exception {
    testParseData(34, new WeatherData(3, PrecipitationType.snow, 3, 1));
    }
    public void testParseData15() throws Exception {
    testParseData(15, new WeatherData(4, PrecipitationType.none, 0, 0));
    }
    
    private void testParseData(int numberEx, WeatherData weatherData)
    {
        String input = "<time from=\"2015-03-17T21:00:00\" to=\"2015-03-18T00:00:00\" period=\"3\">"
                +"<!-- Valid from 2015-03-17T21:00:00 to 2015-03-18T00:00:00 -->"
                +"<symbol number=\"3\" numberEx=\""+numberEx+"\" name=\"Partly cloudy\" var=\"mf/03n.89\"/>"
                +"<precipitation value=\"0\"/>"
                +"<!-- Valid at 2015-03-17T21:00:00 -->"
                +"<windDirection deg=\"104.6\" code=\"ESE\" name=\"East-southeast\"/>"
                +"<windSpeed mps=\"3.3\" name=\"Light breeze\"/>"
                +"<temperature unit=\"celsius\" value=\"8\"/>"
                +"<pressure unit=\"hPa\" value=\"1032.3\"/>"
                +"</time>";

        YrDataParser parser = new YrDataParser();
        WeatherData result = parser.ParseData(input);

        assertEquals(weatherData.GetCloudCover(), result.GetCloudCover());
        assertEquals(weatherData.GetPrecipitationType(), result.GetPrecipitationType());
        assertEquals(weatherData.GetPrecipitationIntensity(), result.GetPrecipitationIntensity());
        assertEquals(weatherData.GetThunder(), result.GetThunder());
        
    }
}