package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by root on 4/16/15.
 */
public interface IHouseCollectionProvider {
    TreeMap<Integer,IGuiElement> GetHouses(float minY, float maxY, float minX, float maxX, int smallHouseCount, int mediumHouseCount, int largeHouseCount, float scale);
}
