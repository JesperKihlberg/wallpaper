package com.kihlberg.framework.drawing.foreground;


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

    private float canvasWidth= 0;
    private float canvasHeight =0;
    private IForegroundLayerProvider foregroundLayerProvider1;
    private IForegroundLayerProvider foregroundLayerProvider2;
    private IForegroundLayerProvider foregroundLayerProvider3;

    public ForegroundProvider(IColorProvider colorProvider, IGuiElementProvider guiElementProvider, IForegroundLayerProvider foregroundLayerProvider1, IForegroundLayerProvider foregroundLayerProvider2, IForegroundLayerProvider foregroundLayerProvider3) {
        super(colorProvider, guiElementProvider);
        this.foregroundLayerProvider1=foregroundLayerProvider1;
        this.foregroundLayerProvider2=foregroundLayerProvider2;
        this.foregroundLayerProvider3=foregroundLayerProvider3;
    }

    @Override
    public ISceneLayer GetLayer() {
        List<IGuiElement> elements = new ArrayList<IGuiElement>();
        elements.addAll(foregroundLayerProvider1.GetLayer(0).GetLayerElements());
        elements.addAll(foregroundLayerProvider2.GetLayer(canvasHeight/15).GetLayerElements());
        elements.addAll(foregroundLayerProvider3.GetLayer(canvasHeight/10).GetLayerElements());
        return new SceneLayer(elements);
    }

    @Override
    public void NotifyCanvasSizeChanged(float width, float height) {
        canvasWidth = width;
        canvasHeight = height;
    }

}
