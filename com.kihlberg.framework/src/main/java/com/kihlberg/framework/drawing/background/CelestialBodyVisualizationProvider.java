package com.kihlberg.framework.drawing.background;

import com.kihlberg.framework.astronomy.IAstronomyElementPosition;
import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.drawing.foreground.CanvasDependant;
import com.kihlberg.framework.interfaces.ICanvasDependant;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by root on 4/1/15.
 */
public abstract class CelestialBodyVisualizationProvider extends CanvasDependant implements ICanvasDependant, ICelestialBodyVisualizationProvider {
    IAstronomyProvider astronomyProvider = null;
    IHorizonProvider horizonProvider = null;
    IGuiElementProvider guiElementProvider = null;
    IColorProvider colorProvider = null;
    float skyHeight = 0;
    float skyWidth = 0;
    float celestialBodyMinX = 0;
    float celestialBodyMaxX = 0;
    float celestialBodyMinY = 0;
    float celestialBodyMaxY = 0;
    private float canvasWidth = 0;
    private  float canvasHeight = 0;

    public CelestialBodyVisualizationProvider(IHorizonProvider horizonProvider,
                                              IAstronomyProvider astronomyProvider,
                                              IGuiElementProvider guiElementProvider,
                                              IColorProvider colorProvider) {
        this.horizonProvider = horizonProvider;
        this.astronomyProvider = astronomyProvider;
        this.guiElementProvider=guiElementProvider;
        this.colorProvider = colorProvider;
    }

    public TreeMap<Integer,IGuiElement> GetLayer(){
        TreeMap<Integer,IGuiElement> elements = new TreeMap<Integer,IGuiElement>();
        IGuiElement elem = getCelestrialObject();
        elements.put(GetSortOrder(), elem);
        return elements;
    }

    protected abstract int GetSortOrder();

    protected abstract IGuiElement getCelestrialObject();

    protected abstract IAstronomyElementPosition getElementPosition();

    protected float GetCelestialBodyXCoord() {
        //0-180 east
        //180-360 west
        double celestialBodyPos = getElementPosition().getOrientation();

        double celestialBodyAzNorm = (celestialBodyPos/360);
        return (float)(celestialBodyMinY + celestialBodyAzNorm * celestialBodyMaxY);

    }

    protected float GetCelestialBodyYCoord(){
        double celestialBodyElevNorm = (90 - getElementPosition().getHeight()) / 180;
        return (float)(celestialBodyMinX + (celestialBodyMaxX - celestialBodyMinX) * celestialBodyElevNorm);
    }

    @Override
    public void NotifyCanvasSizeChanged(float width, float height) {
        super.NotifyCanvasSizeChanged(width,height);
        skyHeight = horizonProvider.GetHorizonYCoord();
        skyWidth = width;
        celestialBodyMinX = skyHeight / 5;
        celestialBodyMaxX =skyHeight * 9 / 5;
        celestialBodyMinY = 0;
        celestialBodyMaxY = width;
    }
}
