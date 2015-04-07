package com.kihlberg.framework.drawing.color;

/**
 * Created by root on 3/28/15.
 */
public abstract class ColorProviderDecorator implements IColorProviderDecorator {

    protected IColorProvider decoratedProvider;

    protected ColorProviderDecorator(IColorProvider decoratedProvider) {
        this.decoratedProvider = decoratedProvider;
    }
    public int GetSkyColor(){
        int color = decoratedProvider.GetSkyColor();
        return  color;
    }

}
