package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.drawing.layers.ISceneLayer;
import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.TreeMap;

/**
 * Created by root on 4/11/15.
 */
public interface IForegroundLayerProvider {
    void Initialize(float yStart, float yEnd, float scale);
    TreeMap<Integer,IGuiElement> GetLayer();
}
