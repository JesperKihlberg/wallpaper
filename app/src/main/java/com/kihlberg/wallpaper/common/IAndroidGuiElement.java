package com.kihlberg.wallpaper.common;

import android.graphics.Path;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.IGuiElement;

/**
 * Created by root on 3/19/15.
 */
public interface IAndroidGuiElement extends IGuiElement{
    public Path GetPath();
    public BaseColorSetting GetColor();
    public boolean ShouldBlur();
}
