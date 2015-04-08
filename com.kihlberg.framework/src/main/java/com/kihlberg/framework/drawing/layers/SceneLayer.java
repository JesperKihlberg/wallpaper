package com.kihlberg.framework.drawing.layers;

import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.List;

/**
 * Created by root on 3/19/15.
 */
public class SceneLayer implements ISceneLayer {

    private List<IGuiElement> guiElements;

    @Override
    public List<IGuiElement> GetLayerElements() {
        return guiElements;
    }

    public SceneLayer(List<IGuiElement> guiElements) {
        this.guiElements = guiElements;
    }
}
