package com.kihlberg.framework.drawing.layers;

import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElementProvider;
/**
 * Created by root on 3/19/15.
 */
public abstract class SceneLayerProvider implements ISceneLayerProvider {
    protected IColorProvider colorProvider;
    protected IGuiElementProvider guiElementProvider;
    @Override
    public abstract ISceneLayer GetLayer();

    public SceneLayerProvider(IColorProvider colorProvider, IGuiElementProvider guiElementProvider) {
        this.colorProvider = colorProvider;
        this.guiElementProvider=guiElementProvider;
    }
}