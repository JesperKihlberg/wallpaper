package com.kihlberg.framework.drawing.background;

import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by root on 3/31/15.
 */
public interface ICelestialBodyVisualizationProvider {
    TreeMap<Integer,IGuiElement> GetLayer();
}
