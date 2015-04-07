package com.kihlberg.framework.drawing.foreground;

import android.graphics.Color;

import com.kihlberg.framework.drawing.color.IColorProvider;
import com.kihlberg.framework.drawing.common.Box;
import com.kihlberg.framework.drawing.common.ICanvasDependant;
import com.kihlberg.framework.drawing.common.ICanvasSizeProvider;
import com.kihlberg.framework.drawing.common.IGuiElement;
import com.kihlberg.framework.drawing.common.IGuiElementProvider;
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

    public ForegroundProvider(IColorProvider colorProvider, IGuiElementProvider guiElementProvider) {
        super(colorProvider, guiElementProvider);
    }

    @Override
    public ISceneLayer GetLayer() {
        List<IGuiElement> elements = new ArrayList<IGuiElement>();
        elements.add(guiElementProvider.CreateBox(0,canvasHeight*2/3, canvasWidth, canvasHeight, Color.GREEN));
        return new SceneLayer(elements);
    }

    @Override
    public void NotifyCanvasSizeChanged(float width, float height) {
        canvasWidth = width;
        canvasHeight = height;
    }
}
