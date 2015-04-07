package com.kihlberg.framework.drawing.color;

import com.kihlberg.framework.astronomy.IAstronomyProvider;

/**
 * Created by root on 3/28/15.
 */
public class SunPositionColorProviderDecorator extends ColorProviderDecorator {

    private IAstronomyProvider astronomyProvider;

    protected SunPositionColorProviderDecorator(IColorProvider decoratedProvider, IAstronomyProvider astronomyProvider) {
        super(decoratedProvider);
        this.astronomyProvider = astronomyProvider;
    }

    @Override
    public int GetSkyColor() {
        int baseColor = super.GetSkyColor();
        return baseColor;
    }
}
