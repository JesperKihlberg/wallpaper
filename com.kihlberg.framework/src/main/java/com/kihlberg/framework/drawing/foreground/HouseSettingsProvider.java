package com.kihlberg.framework.drawing.foreground;

/**
 * Created by root on 4/17/15.
 */
public class HouseSettingsProvider implements IHouseSettingsProvider {
    @Override
    public IHouseSettings GetHouseSettings() {
        return new HouseSettings();
    }
}
