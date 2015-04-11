package com.kihlberg.wallpaper.common;

import android.graphics.Color;
import android.graphics.Path;

import com.kihlberg.framework.interfaces.IGuiElement;

/**
 * Created by root on 3/19/15.
 */
public interface IAndroidGuiElement extends IGuiElement{
    public Path GetPath();
    public int GetColor();
    public boolean ShouldBlur();
}
