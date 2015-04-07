package com.kihlberg.wallpaper;

import com.kihlberg.framework.astronomy.AstronomyProvider;
import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.astronomy.ILocationProvider;
import com.kihlberg.framework.astronomy.ITimeProvider;
import com.kihlberg.framework.astronomy.LocationProvider;
import com.kihlberg.framework.astronomy.TimeProvider;
import com.kihlberg.framework.drawing.background.BackgroundProvider;
import com.kihlberg.framework.drawing.background.HorizonProvider;
import com.kihlberg.framework.drawing.background.MoonVisualizationProvider;
import com.kihlberg.framework.drawing.background.SunVisualizationProvider;
import com.kihlberg.framework.drawing.color.ColorProvider;
import com.kihlberg.framework.drawing.color.IColorProvider;
import com.kihlberg.framework.drawing.common.CanvasSizeProvider;
import com.kihlberg.framework.drawing.common.GuiElementProvider;
import com.kihlberg.framework.drawing.common.ICanvasDependant;
import com.kihlberg.framework.drawing.common.IGuiElementProvider;
import com.kihlberg.framework.drawing.common.IUpdatableCanvasSizeProvider;
import com.kihlberg.framework.drawing.foreground.ForegroundProvider;
import com.kihlberg.framework.drawing.scene.ISceneProvider;
import com.kihlberg.framework.drawing.scene.SceneProvider;
import com.kihlberg.framework.drawing.sky.ISkyProvider;
import com.kihlberg.framework.drawing.sky.SkyProvider;
import com.kihlberg.framework.weather.IWeatherProvider;
import com.kihlberg.framework.weather.WeatherProvider;

import java.util.ArrayList;

/**
 * Created by root on 3/14/15.
 */
public class AppInitializer {

    private static AppInitializer instance = null;
    private IWallpaperCanvasService canvasInstance = null;
    private IGuiElementProvider guiElementProvider = null;
    private HorizonProvider horizonProvider = null;
    private SunVisualizationProvider sunVisualizationProvider = null;
    private MoonVisualizationProvider moonVisualizationProvider = null;
    private ILocationProvider locationProvider = null;
    private ITimeProvider timeProvider = null;
    private IWeatherProvider weatherProvider = null;
    private IAstronomyProvider astronomyProvider = null;
    private ForegroundProvider foregroundProvider = null;
    private BackgroundProvider backgroundProvider = null;
    private ISkyProvider skyProvider = null;
    private ISceneProvider sceneProvider = null;
    private IUpdatableCanvasSizeProvider canvasSizeProvider = null;
    private IColorProvider colorProvider = null;

    protected AppInitializer() {
        ArrayList<ICanvasDependant> canvasDependants = new ArrayList<ICanvasDependant>();
        timeProvider = new TimeProvider();
        locationProvider = new LocationProvider();
        weatherProvider = new WeatherProvider();
        guiElementProvider= new GuiElementProvider();
        astronomyProvider = new AstronomyProvider(timeProvider, locationProvider);
        skyProvider = new SkyProvider(astronomyProvider, weatherProvider);
        horizonProvider = new HorizonProvider();
        colorProvider = new ColorProvider(weatherProvider, astronomyProvider, timeProvider);
        sunVisualizationProvider = new SunVisualizationProvider(astronomyProvider,horizonProvider, guiElementProvider);
        moonVisualizationProvider= new MoonVisualizationProvider(astronomyProvider,horizonProvider, guiElementProvider);
        foregroundProvider = new ForegroundProvider( colorProvider, guiElementProvider);
        backgroundProvider = new BackgroundProvider(colorProvider, guiElementProvider, sunVisualizationProvider, moonVisualizationProvider);
        sceneProvider= new SceneProvider(foregroundProvider, backgroundProvider);
        canvasDependants.add(horizonProvider);
        canvasDependants.add(sunVisualizationProvider);
        canvasDependants.add(moonVisualizationProvider);
        canvasDependants.add(foregroundProvider);
        canvasDependants.add(backgroundProvider);
        canvasSizeProvider = new CanvasSizeProvider(canvasDependants);
        canvasInstance = new WallpaperCanvasService(sceneProvider, canvasSizeProvider, timeProvider,astronomyProvider);
    }

    public static IWallpaperCanvasService GetCanvasService() {
        if(instance==null)
            instance=new AppInitializer();
        return instance.canvasInstance;
    }
}
