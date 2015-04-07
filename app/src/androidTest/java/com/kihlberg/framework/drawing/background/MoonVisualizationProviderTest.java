package com.kihlberg.framework.drawing.background;

import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.drawing.common.IGuiElementProvider;

import junit.framework.TestCase;
//import static org.mockito.Mockito.*;

public class MoonVisualizationProviderTest extends TestCase {

    public void testGetElementPosition() throws Exception {

    }

    public void testGetCelestrialObject() throws Exception {
    }

    private MoonVisualizationProvider GetObject(IAstronomyProvider astronomyProvider,
            IHorizonProvider horizonProvider,
            IGuiElementProvider guiElementProvider){
        MoonVisualizationProvider moonVisualizationProvider = new MoonVisualizationProvider(astronomyProvider, horizonProvider, guiElementProvider);
        return moonVisualizationProvider;
    }
}