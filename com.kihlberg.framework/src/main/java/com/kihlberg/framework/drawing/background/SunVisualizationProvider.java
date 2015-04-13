package com.kihlberg.framework.drawing.background;

import com.kihlberg.framework.astronomy.IAstronomyElementPosition;
import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

/**
 * Created by root on 3/31/15.
 */
public class SunVisualizationProvider extends CelestialBodyVisualizationProvider implements ISunVisualizationProvider {

    public SunVisualizationProvider(IAstronomyProvider astronomyProvider,
                                    IHorizonProvider horizonProvider,
                                    IGuiElementProvider guiElementProvider,
                                    IColorProvider colorProvider) {
        super(horizonProvider, astronomyProvider, guiElementProvider, colorProvider);
    }

    @Override
    protected IAstronomyElementPosition getElementPosition() {
        return astronomyProvider.GetSunPosition();
    }
    @Override
    protected IGuiElement getCelestrialObject() {
        return guiElementProvider.CreateCircle(GetCelestialBodyXCoord(), GetCelestialBodyYCoord(), 50, new BaseColorSetting(GuiElementType.Sun, colorProvider.GetSunColor()),true);
    }

}
