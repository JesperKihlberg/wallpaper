package com.kihlberg.framwork.test.drawing.background;

import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.astronomy.IMoonPosition;
import com.kihlberg.framework.drawing.background.IHorizonProvider;
import com.kihlberg.framework.drawing.background.MoonVisualizationProvider;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(value = Parameterized.class)
public class MoonVisualizationProviderTest {

    private double moonAge;
    private double moonHeight;
    private double moonOrientation;

    private float x;
    private float y;
    private float radius1;
    private float radius2;

    public MoonVisualizationProviderTest(double moonAge, double moonHeight, double moonOrientation, float x, float y, float radius1, float radius2) {
        this.moonAge = moonAge;
        this.moonHeight = moonHeight;
        this.moonOrientation = moonOrientation;
        this.x = x;
        this.y = y;
        this.radius1 = radius1;
        this.radius2 = radius2;
    }
    @Parameterized.Parameters(name="{index}: GetCelestrialObject({0},{1},{2})=>({3},{4},{5},{6})")
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][]{
                //moon radii
                {0,0,0,0,100,50,50},
                {29.5/2,0,0,0,100,-50,50},
                {29.5/4,0,0,0,100,50,0},
                {29.5*3/4,0,0,0,100,-50,0},
                {29.5/8,0,0,0,100,50,25},
                {29.5*3/8,0,0,0,100,50,-25},
                {29.5*5/8,0,0,0,100,-50,25},
                {29.5*7/8,0,0,0,100,-50,-25},
                //moon location
                {0,90,90,50,20,50,50},
                {0,45,90,50,60,50,50},
        });
    }

    @Test
    public void testGetCelestrialObject() throws Exception {
        float canvasHeight = 100;
        float canvasWidth = 200;
        int color = 210;
        IMoonPosition monPosMock = mock(IMoonPosition.class);
        IGuiElement moonMock = mock(IGuiElement.class);

        IAstronomyProvider astronomyProviderMock = mock(IAstronomyProvider.class);
        IHorizonProvider horizonProviderMock = mock(IHorizonProvider.class);
        IGuiElementProvider guiElementProviderMock = mock(IGuiElementProvider.class);
        IColorProvider colorProviderMock= mock(IColorProvider.class);

        when(astronomyProviderMock.GetMoonPosition()).thenReturn(monPosMock);
        when(monPosMock.getMoonAge()).thenReturn(this.moonAge);
        when(monPosMock.getHeight()).thenReturn(this.moonHeight);
        when(monPosMock.getOrientation()).thenReturn(this.moonOrientation);
        when(colorProviderMock.GetMoonColor()).thenReturn(color );
        when(guiElementProviderMock.CreateMoon(this.x, this.y, this.radius1, this.radius2, color)).thenReturn(moonMock);
        when(horizonProviderMock.GetHorizonYCoord()).thenReturn(canvasHeight);

        MoonVisualizationProvider obj = GetObject(astronomyProviderMock,horizonProviderMock,guiElementProviderMock,colorProviderMock );
        obj.NotifyCanvasSizeChanged(canvasWidth, canvasHeight);
        List<IGuiElement> result = obj.GetLayer();

        verify(guiElementProviderMock).CreateMoon(this.x, this.y, this.radius1, this.radius2, color);

        assertEquals(1,result.size());
        assertEquals(moonMock, result.get(0));
    }

    private MoonVisualizationProvider GetObject(IAstronomyProvider astronomyProvider,
                                                IHorizonProvider horizonProvider,
                                                IGuiElementProvider guiElementProvider,
                                                IColorProvider colorProvider){
        MoonVisualizationProvider moonVisualizationProvider = new MoonVisualizationProvider(astronomyProvider, horizonProvider, guiElementProvider,colorProvider);
        return moonVisualizationProvider;
    }
}
