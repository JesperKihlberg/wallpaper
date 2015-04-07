package com.kihlberg.framework.drawing.background;

import android.graphics.Color;

import com.kihlberg.framework.astronomy.AstronomyElementPosition;
import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.drawing.common.Circle;
import com.kihlberg.framework.drawing.common.IGuiElement;
import com.kihlberg.framework.drawing.common.IGuiElementProvider;

/**
 * Created by root on 3/31/15.
 */
public class SunVisualizationProvider extends CelestialBodyVisualizationProvider implements ISunVisualizationProvider {

    public SunVisualizationProvider(IAstronomyProvider astronomyProvider,
                                    IHorizonProvider horizonProvider,
                                    IGuiElementProvider guiElementProvider) {
        super(horizonProvider, astronomyProvider, guiElementProvider);
    }

    @Override
    protected AstronomyElementPosition getElementPosition() {
        return astronomyProvider.GetSunPosition();
    }
    @Override
    protected IGuiElement getCelestrialObject() {
        return guiElementProvider.CreateCircle(GetCelestialBodyXCoord(), GetCelestialBodyYCoord(), 50, Color.YELLOW);
    }

}
