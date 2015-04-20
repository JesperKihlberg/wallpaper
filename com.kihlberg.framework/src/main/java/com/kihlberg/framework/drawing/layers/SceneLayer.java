package com.kihlberg.framework.drawing.layers;

import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.Collection;
import java.util.List;

/**
 * Created by root on 3/19/15.
 */
public class SceneLayer implements ISceneLayer {

    private Collection<IGuiElement> guiElements;

    @Override
    public Collection<IGuiElement> GetLayerElements() {
        return guiElements;
    }

    public SceneLayer(Collection<IGuiElement> guiElements) {
        this.guiElements = guiElements;
    }
}
