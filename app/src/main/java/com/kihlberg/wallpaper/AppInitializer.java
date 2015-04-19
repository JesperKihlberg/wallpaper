package com.kihlberg.wallpaper;

import com.kihlberg.framework.astronomy.AstronomyProvider;
import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.astronomy.ILocationProvider;
import com.kihlberg.framework.drawing.foreground.ForegroundLayerProvider;
import com.kihlberg.framework.drawing.foreground.HouseCollectionProvider;
import com.kihlberg.framework.drawing.foreground.HouseProvider;
import com.kihlberg.framework.drawing.foreground.HouseSettingsProvider;
import com.kihlberg.framework.drawing.foreground.IHouseCollectionProvider;
import com.kihlberg.framework.drawing.foreground.IHouseProvider;
import com.kihlberg.framework.drawing.foreground.IHouseSettingsProvider;
import com.kihlberg.framework.drawing.foreground.ITreeProvider;
import com.kihlberg.framework.drawing.foreground.TreeProvider;
import com.kihlberg.framework.interfaces.ICanvasDependant;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElementProvider;
import com.kihlberg.framework.interfaces.ITimeProvider;
import com.kihlberg.framework.astronomy.LocationProvider;
import com.kihlberg.framework.drawing.background.BackgroundProvider;
import com.kihlberg.framework.drawing.background.HorizonProvider;
import com.kihlberg.framework.drawing.background.MoonVisualizationProvider;
import com.kihlberg.framework.drawing.background.SunVisualizationProvider;
import com.kihlberg.framework.drawing.foreground.ForegroundProvider;
import com.kihlberg.framework.drawing.scene.ISceneProvider;
import com.kihlberg.framework.drawing.scene.SceneProvider;
import com.kihlberg.framework.weather.IWeatherProvider;
import com.kihlberg.framework.weather.WeatherProvider;
import com.kihlberg.wallpaper.color.ColorProvider;
import com.kihlberg.wallpaper.common.CanvasSizeProvider;
import com.kihlberg.wallpaper.common.GuiElementProvider;
import com.kihlberg.wallpaper.common.IUpdatableCanvasSizeProvider;

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
    private IHouseSettingsProvider houseSettingsProvider = null;
    private IHouseProvider houseProvider = null;
    private IHouseCollectionProvider houseCollectionProvider = null;
    private ForegroundProvider foregroundProvider = null;
    private BackgroundProvider backgroundProvider = null;
    private ITreeProvider treeProvider=null;
//    private ISkyProvider skyProvider = null;
    private ISceneProvider sceneProvider = null;
    private IUpdatableCanvasSizeProvider canvasSizeProvider = null;
    private IColorProvider colorProvider = null;
    private ForegroundLayerProvider foregroundLayerProvider1;
    private ForegroundLayerProvider foregroundLayerProvider2;
    private ForegroundLayerProvider foregroundLayerProvider3;

    protected AppInitializer() {
        ArrayList<ICanvasDependant> canvasDependants = new ArrayList<ICanvasDependant>();
        timeProvider = new TimeProvider();
        locationProvider = new LocationProvider();
        weatherProvider = new WeatherProvider();
        guiElementProvider= new GuiElementProvider();
        astronomyProvider = new AstronomyProvider(timeProvider, locationProvider);
//        skyProvider = new SkyProvider(astronomyProvider, weatherProvider);
        horizonProvider = new HorizonProvider();
        colorProvider = new ColorProvider(weatherProvider, astronomyProvider, timeProvider);
        houseSettingsProvider= new HouseSettingsProvider();
        houseProvider = new HouseProvider(guiElementProvider, colorProvider, houseSettingsProvider);
        houseCollectionProvider=new HouseCollectionProvider(houseProvider);
        sunVisualizationProvider = new SunVisualizationProvider(astronomyProvider,horizonProvider, guiElementProvider, colorProvider);
        moonVisualizationProvider= new MoonVisualizationProvider(astronomyProvider,horizonProvider, guiElementProvider, colorProvider);
        treeProvider= new TreeProvider(colorProvider, guiElementProvider);
        foregroundLayerProvider1 = new ForegroundLayerProvider(colorProvider,guiElementProvider,houseCollectionProvider,treeProvider);
        foregroundLayerProvider2= new ForegroundLayerProvider(colorProvider,guiElementProvider,houseCollectionProvider,treeProvider);
        foregroundLayerProvider3= new ForegroundLayerProvider(colorProvider,guiElementProvider,houseCollectionProvider,treeProvider);
        foregroundProvider = new ForegroundProvider( colorProvider, guiElementProvider, foregroundLayerProvider1,foregroundLayerProvider2, foregroundLayerProvider3,horizonProvider);
        backgroundProvider = new BackgroundProvider(colorProvider, guiElementProvider, sunVisualizationProvider, moonVisualizationProvider);
        sceneProvider= new SceneProvider(foregroundProvider, backgroundProvider);
        canvasDependants.add(houseProvider);
        canvasDependants.add(horizonProvider);
        canvasDependants.add(sunVisualizationProvider);
        canvasDependants.add(moonVisualizationProvider);
        canvasDependants.add(treeProvider);
        canvasDependants.add(foregroundProvider);
        canvasDependants.add(foregroundLayerProvider1);
        canvasDependants.add(foregroundLayerProvider2);
        canvasDependants.add(foregroundLayerProvider3);
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
