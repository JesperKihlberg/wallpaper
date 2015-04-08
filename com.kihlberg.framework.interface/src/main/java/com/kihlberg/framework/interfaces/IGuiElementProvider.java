package com.kihlberg.framework.interfaces;

/**
 * Created by root on 4/7/15.
 */
public interface IGuiElementProvider {
    IGuiElement CreateBox(float minx, float miny, float maxx, float maxy, int color);

    IGuiElement CreateCircle(float x, float y, float radius, int color);

    IGuiElement CreateMoon(float x, float y, float radius1, float radius2, int color);
}
