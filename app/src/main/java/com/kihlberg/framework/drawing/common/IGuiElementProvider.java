package com.kihlberg.framework.drawing.common;

/**
 * Created by root on 4/7/15.
 */
public interface IGuiElementProvider {
    IBox CreateBox(float minx, float miny, float maxx, float maxy, int color);

    ICircle CreateCircle(float x, float y, float radius, int color);

    IMoon CreateMoon(float x, float y, float radius1, float radius2, int color);
}
