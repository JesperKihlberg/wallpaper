package com.kihlberg.framework.drawing.layers;

import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.Collection;
import java.util.List;

/**
 * Created by root on 3/19/15.
 */
public interface ISceneLayer {
    public Collection<IGuiElement> GetLayerElements();
}
