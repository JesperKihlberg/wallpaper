package com.kihlberg.framework.drawing.layers;

import com.kihlberg.framework.drawing.foreground.CanvasDependant;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import java.util.TreeMap;

/**
 * Created by root on 3/19/15.
 */
public abstract class SceneLayerProvider extends CanvasDependant implements ISceneLayerProvider {
    protected IColorProvider colorProvider;
    protected IGuiElementProvider guiElementProvider;
    @Override
    public abstract TreeMap<Integer,IGuiElement> GetLayer();

    public SceneLayerProvider(IColorProvider colorProvider, IGuiElementProvider guiElementProvider) {
        this.colorProvider = colorProvider;
        this.guiElementProvider=guiElementProvider;
    }
}
