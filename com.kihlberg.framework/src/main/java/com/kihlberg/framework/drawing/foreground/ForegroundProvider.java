package com.kihlberg.framework.drawing.foreground;


import com.kihlberg.framework.drawing.background.IHorizonProvider;
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
public class ForegroundProvider extends SceneLayerProvider implements IForegroundProvider, ICanvasDependant {

    private IForegroundLayerProvider foregroundLayerProvider1;
    private IForegroundLayerProvider foregroundLayerProvider2;
    private IForegroundLayerProvider foregroundLayerProvider3;
    protected IHorizonProvider horizonProvider;

    public ForegroundProvider(IColorProvider colorProvider, IGuiElementProvider guiElementProvider, IForegroundLayerProvider foregroundLayerProvider1, IForegroundLayerProvider foregroundLayerProvider2, IForegroundLayerProvider foregroundLayerProvider3, IHorizonProvider horizonProvider) {
        super(colorProvider, guiElementProvider);
        this.foregroundLayerProvider1=foregroundLayerProvider1;
        this.foregroundLayerProvider2=foregroundLayerProvider2;
        this.foregroundLayerProvider3=foregroundLayerProvider3;
        this.horizonProvider=horizonProvider;
    }

    @Override
    public ISceneLayer GetLayer() {
        List<IGuiElement> elements = new ArrayList<IGuiElement>();
        float horizon = horizonProvider.GetHorizonYCoord();
        elements.addAll(foregroundLayerProvider1.GetLayer(horizon, horizon + canvasHeight/15, 0.3f).GetLayerElements());
        elements.addAll(foregroundLayerProvider2.GetLayer(horizon + canvasHeight/15,horizon + canvasHeight/10, 0.5f).GetLayerElements());
        elements.addAll(foregroundLayerProvider3.GetLayer(horizon + canvasHeight/10, canvasHeight, 1.0f).GetLayerElements());
        return new SceneLayer(elements);
    }

}
