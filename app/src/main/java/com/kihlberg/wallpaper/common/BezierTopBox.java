package com.kihlberg.wallpaper.common;

import android.graphics.Path;
import android.graphics.RectF;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;
import com.kihlberg.framework.interfaces.IGuiElement;

/**
 * Created by root on 4/10/15.
 */
public class BezierTopBox extends GuiElement implements IAndroidGuiElement {
    private float minx;
    private float miny;
    private float maxx;
    private float maxy;
    private float topPointX;
    private float topPointY;

    public BezierTopBox(float minx, float miny, float maxx, float maxy, float topPointX, float topPointY, BaseColorSetting color, boolean shouldBlur) {
        super( color, shouldBlur);
        this.minx = minx;
        this.miny = miny;
        this.maxx = maxx;
        this.maxy = maxy;
        this.topPointX = topPointX;
        this.topPointY = topPointY;
    }

    @Override
    public Path GetPath() {
        Path p = new Path();
        p.moveTo(minx, miny);
        p.cubicTo(minx,miny,topPointX,topPointY,maxx,miny);
        p.lineTo(maxx,maxy);
        p.lineTo(minx,maxy);
        p.close();
        return p;
    }
}
