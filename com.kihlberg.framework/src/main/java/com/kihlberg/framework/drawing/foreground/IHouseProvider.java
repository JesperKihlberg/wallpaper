package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.ICanvasDependant;
import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by root on 4/15/15.
 */
public interface IHouseProvider extends ICanvasDependant {
    TreeMap<Integer,IGuiElement> GetSmallHouse(float minX, float minY, float scale);
}
