package com.kihlberg.wallpaper.common;

import android.graphics.Path;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;

/**
 * Created by root on 4/12/15.
 */
public class Triangle extends GuiElement {
    private float x1;
    private float x2;
    private float x3;
    private float y1;
    private float y2;
    private float y3;

    public Triangle(float x1, float y1, float x2, float y2, float x3, float y3, BaseColorSetting color, boolean shouldBlur) {
        super(color, shouldBlur);
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    @Override
    public Path GetPath() {
        Path p = new Path();
        p.moveTo(x1,y1);
        p.lineTo(x2,y2);
        p.lineTo(x3,y3);
        p.close();
        return p;
    }
}
