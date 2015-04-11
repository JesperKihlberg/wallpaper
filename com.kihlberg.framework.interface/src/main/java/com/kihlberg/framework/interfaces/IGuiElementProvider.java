package com.kihlberg.framework.interfaces;

/**
 * Created by root on 4/7/15.
 */
public interface IGuiElementProvider {
    IGuiElement CreateBox(float minx, float miny, float maxx, float maxy, int color);
    IGuiElement CreateBox(float minx, float miny, float maxx, float maxy, int color, boolean shouldBlur);

    IGuiElement CreateCircle(float x, float y, float radius, int color);
    IGuiElement CreateCircle(float x, float y, float radius, int color, boolean shouldBlur);

    IGuiElement CreateMoon(float x, float y, float radius1, float radius2, int color);
    IGuiElement CreateMoon(float v, float v1, float mainRadius, float innerRadius, int i, boolean shouldBlur);

    IGuiElement CreateBezierTopBox(float minx, float miny, float maxx, float maxy, float topPointX, float topPointY, int color);
    IGuiElement CreateBezierTopBox(float minx, float miny, float maxx, float maxy, float topPointX, float topPointY, int color, boolean shouldBlur);
}
