package com.kihlberg.framework.interfaces;

/**
 * Created by root on 4/7/15.
 */
public interface IGuiElementProvider {
    IGuiElement CreateBox(float minx, float miny, float maxx, float maxy, BaseColorSetting color);
    IGuiElement CreateBox(float minx, float miny, float maxx, float maxy, BaseColorSetting color, boolean shouldBlur);

    IGuiElement CreateCircle(float x, float y, float radius, BaseColorSetting color);
    IGuiElement CreateCircle(float x, float y, float radius, BaseColorSetting color, boolean shouldBlur);

    IGuiElement CreateMoon(float x, float y, float radius1, float radius2, BaseColorSetting color);
    IGuiElement CreateMoon(float v, float v1, float mainRadius, float innerRadius, BaseColorSetting color, boolean shouldBlur);

    IGuiElement CreateBezierTopBox(float minx, float miny, float maxx, float maxy, float topPointX, float topPointY, BaseColorSetting color);
    IGuiElement CreateBezierTopBox(float minx, float miny, float maxx, float maxy, float topPointX, float topPointY, BaseColorSetting color, boolean shouldBlur);

    IGuiElement CreateTriangle(float x1, float y1, float x2, float y2, float x3, float y3, BaseColorSetting color);
    IGuiElement CreateTriangle(float x1, float y1, float x2, float y2, float x3, float y3, BaseColorSetting color, boolean shouldBlur);
}
