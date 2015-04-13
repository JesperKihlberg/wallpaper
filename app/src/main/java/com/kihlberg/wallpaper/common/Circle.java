package com.kihlberg.wallpaper.common;

import android.graphics.Path;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;

/**
 * Created by root on 3/31/15.
 */
public class Circle extends GuiElement implements ICircle {
    private float x;
    private float y;
    private float radius;

    @Override
    public GetterPath GetPath() {
        GetterPath path = new GetterPath();
        path.addCircle(x,y,radius, Path.Direction.CW);
        return path;
    }
    public Circle(float x, float y, float radius, BaseColorSetting color, boolean shouldBlur) {
        super( color, shouldBlur);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
