package com.kihlberg.wallpaper.common;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

/**
 * Created by root on 4/7/15.
 */
public class GuiElementProvider implements IGuiElementProvider {
    @Override
    public IGuiElement CreateBox(float minx, float miny, float maxx, float maxy, BaseColorSetting color){
        return CreateBox(minx, miny, maxx, maxy, color, false);
    }
    @Override
    public IGuiElement CreateBox(float minx, float miny, float maxx, float maxy, BaseColorSetting  color, boolean shouldBlur){
        return new Box(minx, miny, maxx, maxy, color, shouldBlur);
    }
    @Override
    public IGuiElement CreateCircle(float x, float y, float radius, BaseColorSetting  color){
        return CreateCircle(x, y, radius, color, false);
    }
    @Override
    public IGuiElement CreateCircle(float x, float y, float radius, BaseColorSetting  color, boolean shouldBlur){
        return new Circle(x, y, radius, color,shouldBlur);
    }
    @Override
    public IGuiElement CreateMoon(float x, float y, float radius1, float radius2, BaseColorSetting  color){
        return CreateMoon(x, y, radius1, radius2, color, false);
    }
    @Override
    public IGuiElement CreateMoon(float x, float y, float radius1, float radius2, BaseColorSetting  color, boolean shouldBlur){
        return new Moon(x, y, radius1, radius2, color,shouldBlur);
    }

    @Override
    public IGuiElement CreateBezierTopBox(float minx, float miny, float maxx, float maxy, float topPointX, float topPointY, BaseColorSetting  color) {
        return CreateBezierTopBox(minx, miny, maxx, maxy, topPointX, topPointY, color, false);
    }

    @Override
    public IGuiElement CreateBezierTopBox(float minx, float miny, float maxx, float maxy, float topPointX, float topPointY, BaseColorSetting  color, boolean shouldBlur) {
        return new BezierTopBox(minx, miny, maxx, maxy, topPointX, topPointY, color,shouldBlur);
    }

    @Override
    public IGuiElement CreateTriangle(float x1, float y1, float x2, float y2, float x3, float y3, BaseColorSetting  color) {
        return CreateTriangle(x1, y1, x2, y2, x3, y3, color, false);
    }

    @Override
    public IGuiElement CreateTriangle(float x1, float y1, float x2, float y2, float x3, float y3, BaseColorSetting  color, boolean shouldBlur) {
        return new Triangle(x1, y1, x2, y2, x3, y3, color, shouldBlur);
    }
}
