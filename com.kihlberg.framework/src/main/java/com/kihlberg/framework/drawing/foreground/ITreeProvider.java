package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.ICanvasDependant;
import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.List;

/**
 * Created by root on 4/19/15.
 */
public interface ITreeProvider extends ICanvasDependant{
    List<IGuiElement> GetTree(float minx, float miny, float scale);
}
