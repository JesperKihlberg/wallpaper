package com.kihlberg.framework.drawing.layers;

import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.TreeMap;

/**
 * Created by root on 3/19/15.
 */
public interface ISceneLayerProvider {
    public TreeMap<Integer,IGuiElement> GetLayer();
}
