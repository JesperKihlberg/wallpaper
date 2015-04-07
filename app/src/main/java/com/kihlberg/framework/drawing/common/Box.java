package com.kihlberg.framework.drawing.common;

import android.graphics.Color;
import android.graphics.Path;

/**
 * Created by root on 3/19/15.
 */
public class Box extends GuiElement implements IBox {

    private float minx;
    private float maxx;
    private float miny;
    private float maxy;

    @Override
    public GetterPath GetPath() {
        GetterPath p = new GetterPath();
        p.addRect(minx,miny,maxx,maxy, Path.Direction.CW);
        return p;
    }

    public Box(float minx, float miny, float maxx, float maxy, int color) {
        super(color);
        this.minx = minx;
        this.maxx = maxx;
        this.miny = miny;
        this.maxy = maxy;
    }
}
