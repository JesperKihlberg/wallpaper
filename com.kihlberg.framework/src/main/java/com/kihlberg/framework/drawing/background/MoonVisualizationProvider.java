package com.kihlberg.framework.drawing.background;


import com.kihlberg.framework.astronomy.IAstronomyElementPosition;
import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

/**
 * Created by root on 3/31/15.
 */
public class MoonVisualizationProvider extends CelestialBodyVisualizationProvider implements IMoonVisualizationProvider {
    private static float primaryRadius = 50;
    private static float moonFaseLength = (float) 29.5;

    public MoonVisualizationProvider(IAstronomyProvider astronomyProvider,
                                     IHorizonProvider horizonProvider,
                                     IGuiElementProvider guiElementProvider,
                                     IColorProvider colorProvider) {
        super(horizonProvider, astronomyProvider, guiElementProvider, colorProvider);
    }

    @Override
    protected IAstronomyElementPosition getElementPosition() {
        return astronomyProvider.GetMoonPosition();
    }
    @Override
    protected IGuiElement getCelestrialObject() {
        double moonAge = astronomyProvider.GetMoonPosition().getMoonAge();
        float mainRadius = moonAge < moonFaseLength/2?-primaryRadius:primaryRadius;
        return guiElementProvider.CreateMoon(GetCelestialBodyXCoord(), GetCelestialBodyYCoord(), mainRadius, CalculateInnerMoonRadius(moonAge), colorProvider.GetMoonColor());
    }

    private float CalculateInnerMoonRadius(double moonAge){
        double ageNorm = moonAge * 4 / moonFaseLength;
        if (ageNorm % 2 < 1)
            return (float) ((1-(ageNorm % 2))*primaryRadius);
        return (float) -((ageNorm % 1)*primaryRadius);

    }

}