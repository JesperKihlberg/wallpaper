package com.kihlberg.framework.drawing.background;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.ICanvasDependant;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;
import com.kihlberg.framework.drawing.layers.ISceneLayer;
import com.kihlberg.framework.drawing.layers.SceneLayer;
import com.kihlberg.framework.drawing.layers.SceneLayerProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by root on 3/22/15.
 */
public class  BackgroundProvider extends SceneLayerProvider implements IBackgroundProvider, ICanvasDependant {
    ISunVisualizationProvider sunVisualizationProvider = null;
    IMoonVisualizationProvider moonVisualizationProvider = null;

    public BackgroundProvider(IColorProvider colorProvider,
                              IGuiElementProvider guiElementProvider,
                              ISunVisualizationProvider  sunVisualizationProvider,
                              IMoonVisualizationProvider moonVisualizationProvider) {
        super(colorProvider, guiElementProvider);
        this.sunVisualizationProvider=sunVisualizationProvider;
        this.moonVisualizationProvider=moonVisualizationProvider;
    }

    @Override
    public TreeMap<Integer,IGuiElement> GetLayer() {
        TreeMap<Integer,IGuiElement> elements = new TreeMap<Integer,IGuiElement>();
        elements.put(0,guiElementProvider.CreateBox(0,0, canvasWidth, canvasHeight, new BaseColorSetting( GuiElementType.Sky, colorProvider.GetSkyColor())));
        elements.putAll(sunVisualizationProvider.GetLayer());
        elements.putAll(moonVisualizationProvider.GetLayer());
        return elements;
    }
}
