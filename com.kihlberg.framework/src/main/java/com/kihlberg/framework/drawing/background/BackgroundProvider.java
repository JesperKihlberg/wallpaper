package com.kihlberg.framework.drawing.background;

import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.ICanvasDependant;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;
import com.kihlberg.framework.drawing.layers.ISceneLayer;
import com.kihlberg.framework.drawing.layers.SceneLayer;
import com.kihlberg.framework.drawing.layers.SceneLayerProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/22/15.
 */
public class  BackgroundProvider extends SceneLayerProvider implements IBackgroundProvider, ICanvasDependant {
    ISunVisualizationProvider sunVisualizationProvider = null;
    IMoonVisualizationProvider moonVisualizationProvider = null;

    private float canvasWidth=0;
    private float canvasHeight=0;

    public BackgroundProvider(IColorProvider colorProvider,
                              IGuiElementProvider guiElementProvider,
                              ISunVisualizationProvider  sunVisualizationProvider,
                              IMoonVisualizationProvider moonVisualizationProvider) {
        super(colorProvider, guiElementProvider);
        this.sunVisualizationProvider=sunVisualizationProvider;
        this.moonVisualizationProvider=moonVisualizationProvider;
    }

    @Override
    public ISceneLayer GetLayer() {
        List<IGuiElement> elements = new ArrayList<IGuiElement>();
        elements.add(guiElementProvider.CreateBox(0,0, canvasWidth, canvasHeight, colorProvider.GetSkyColor()));
        elements.addAll(sunVisualizationProvider.GetLayer());
        elements.addAll(moonVisualizationProvider.GetLayer());
        return new SceneLayer(elements);
    }

    @Override
    public void NotifyCanvasSizeChanged(float width, float height) {
        canvasWidth = width;
        canvasHeight = height;
    }
}
