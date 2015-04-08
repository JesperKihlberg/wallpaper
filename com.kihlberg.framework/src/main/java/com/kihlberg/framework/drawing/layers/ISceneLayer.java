package com.kihlberg.framework.drawing.layers;

import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.List;

/**
 * Created by root on 3/19/15.
 */
public interface ISceneLayer {
    public List<IGuiElement> GetLayerElements();
}
