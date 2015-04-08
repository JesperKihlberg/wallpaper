package com.kihlberg.framework.drawing.background;

import com.kihlberg.framework.astronomy.IAstronomyElementPosition;
import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.interfaces.ICanvasDependant;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/1/15.
 */
public abstract class CelestialBodyVisualizationProvider implements ICanvasDependant, ICelestialBodyVisualizationProvider {
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

    public List<IGuiElement> GetLayer(){
        ArrayList<IGuiElement> elements = new ArrayList<>();
        IGuiElement elem = getCelestrialObject();
        elements.add(elem);
        return elements;
    }

    protected abstract IGuiElement getCelestrialObject();

    protected abstract IAstronomyElementPosition getElementPosition();

    protected float GetCelestialBodyXCoord() {
        //0-180 east
        //180-360 west
        double celestialBodyPos = getElementPosition().getOrientation();

        double celestialBodyAzNorm = 1 - ((celestialBodyPos<180?(celestialBodyPos+180) :(celestialBodyPos - 180))/360);
        return (float)(celestialBodyMinY + celestialBodyAzNorm * celestialBodyMaxY);

    }

    protected float GetCelestialBodyYCoord(){
        double celestialBodyElevNorm = (90 - getElementPosition().getHeight()) / 180;
        return (float)(celestialBodyMinX + (celestialBodyMaxX - celestialBodyMinX) * celestialBodyElevNorm);
    }

    @Override
    public void NotifyCanvasSizeChanged(float width, float height) {
        canvasWidth = width;
        canvasHeight = height;
        skyHeight = horizonProvider.GetHorizonYCoord();
        skyWidth = canvasWidth;
        celestialBodyMinX = skyHeight / 5;
        celestialBodyMaxX =skyHeight * 9 / 5;
        celestialBodyMinY = 0;
        celestialBodyMaxY = canvasWidth;
    }
}
