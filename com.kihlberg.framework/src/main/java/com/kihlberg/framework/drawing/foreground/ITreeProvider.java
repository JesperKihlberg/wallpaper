package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.ICanvasDependant;
import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by root on 4/19/15.
 */
public interface ITreeProvider extends ICanvasDependant{
    TreeMap<Integer,IGuiElement> GetTree(float minx, float miny, float scale);
}
