package com.kihlberg.framework.drawing.background;

import android.graphics.Color;

import com.kihlberg.framework.astronomy.AstronomyElementPosition;
import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.drawing.common.Circle;
import com.kihlberg.framework.drawing.common.IGuiElement;
import com.kihlberg.framework.drawing.common.IGuiElementProvider;
import com.kihlberg.framework.drawing.common.Moon;

/**
 * Created by root on 3/31/15.
 */
public class MoonVisualizationProvider extends CelestialBodyVisualizationProvider implements IMoonVisualizationProvider {
    private static float primaryRadius = 50;
    private static float moonFaseLength = (float) 29.5;

    public MoonVisualizationProvider(IAstronomyProvider astronomyProvider,
                                     IHorizonProvider horizonProvider,
                                     IGuiElementProvider guiElementProvider) {
        super(horizonProvider, astronomyProvider, guiElementProvider);
    }

    @Override
    protected AstronomyElementPosition getElementPosition() {
        return astronomyProvider.GetMoonPosition();
    }
    @Override
    protected IGuiElement getCelestrialObject() {
        double moonAge = astronomyProvider.GetMoonPosition().getMoonAge();
        float mainRadius = moonAge < moonFaseLength/2?-primaryRadius:primaryRadius;
        return guiElementProvider.CreateMoon(GetCelestialBodyXCoord(), GetCelestialBodyYCoord(), mainRadius, CalculateInnerMoonRadius(moonAge), Color.WHITE);
    }

    private float CalculateInnerMoonRadius(double moonAge){
        double ageNorm = moonAge * 4 / moonFaseLength;
        if (ageNorm % 2 < 1)
            return (float) ((1-(ageNorm % 2))*primaryRadius);
        return (float) -((ageNorm % 1)*primaryRadius);

    }

}
