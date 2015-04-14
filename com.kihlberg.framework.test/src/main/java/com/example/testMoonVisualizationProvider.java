package com.example;

import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.astronomy.IMoonPosition;
import com.kihlberg.framework.drawing.background.IHorizonProvider;
import com.kihlberg.framework.drawing.background.MoonVisualizationProvider;
import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(value = Parameterized.class)
public class testMoonVisualizationProvider {

    private double moonAge;
    private double moonHeight;
    private double moonOrientation;

    private float x;
    private float y;
    private float radius1;
    private float radius2;

    public testMoonVisualizationProvider(double moonAge, double moonHeight, double moonOrientation, float x, float y, float radius1, float radius2) {
        this.moonAge = moonAge;
        this.moonHeight = moonHeight;
        this.moonOrientation = moonOrientation;
        this.x = x;
        this.y = y;
        this.radius1 = radius1;
        this.radius2 = radius2;
    }
    //    @Parameterized.Parameters(name="{index}: GetCelestrialObject({0},{1},{2})=>({3},{4},{5},{6})")
    @Parameterized.Parameters()
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][]{
                //moon radii
                {0,0,0,0,100,50,50},
                {29.499,0,0,0,100,-50,-50},
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
        IMoonPosition monPosMock = Mockito.mock(IMoonPosition.class);
        IGuiElement moonMock = Mockito.mock(IGuiElement.class);

        IAstronomyProvider astronomyProviderMock = Mockito.mock(IAstronomyProvider.class);
        IHorizonProvider horizonProviderMock = Mockito.mock(IHorizonProvider.class);
        IGuiElementProvider guiElementProviderMock = Mockito.mock(IGuiElementProvider.class);
        IColorProvider colorProviderMock= Mockito.mock(IColorProvider.class);

        Mockito.when(astronomyProviderMock.GetMoonPosition()).thenReturn(monPosMock);
        Mockito.when(monPosMock.getMoonAge()).thenReturn(this.moonAge);
        Mockito.when(monPosMock.getHeight()).thenReturn(this.moonHeight);
        Mockito.when(monPosMock.getOrientation()).thenReturn(this.moonOrientation);
        Mockito.when(colorProviderMock.GetMoonColor()).thenReturn(color );
        BaseColorSetting color1 = new BaseColorSetting(GuiElementType.Moon, color);
        Mockito.when(guiElementProviderMock.CreateMoon(eq(this.x), eq(this.y), eq(this.radius1), eq(this.radius2), any(BaseColorSetting.class), eq(true))).thenReturn(moonMock);
        Mockito.when(horizonProviderMock.GetHorizonYCoord()).thenReturn(canvasHeight);

        MoonVisualizationProvider obj = GetObject(astronomyProviderMock,horizonProviderMock,guiElementProviderMock,colorProviderMock );
        obj.NotifyCanvasSizeChanged(canvasWidth, canvasHeight);
        List<IGuiElement> result = obj.GetLayer();

        ArgumentCaptor<BaseColorSetting> argument = ArgumentCaptor.forClass(BaseColorSetting.class);
        Mockito.verify(guiElementProviderMock).CreateMoon(eq(this.x), eq(this.y), eq(this.radius1), eq(this.radius2),argument.capture(),eq(true));

        Assert.assertEquals(color, argument.getValue().GetColor());
        Assert.assertEquals(GuiElementType.Moon, argument.getValue().GetType());

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(moonMock, result.get(0));
    }

    private MoonVisualizationProvider GetObject(IAstronomyProvider astronomyProvider,
                                                IHorizonProvider horizonProvider,
                                                IGuiElementProvider guiElementProvider,
                                                IColorProvider colorProvider){
        MoonVisualizationProvider moonVisualizationProvider = new MoonVisualizationProvider(astronomyProvider, horizonProvider, guiElementProvider,colorProvider);
        return moonVisualizationProvider;
    }
}
