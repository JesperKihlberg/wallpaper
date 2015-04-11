package com.kihlberg.wallpaper.common;

import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

/**
 * Created by root on 4/7/15.
 */
public class GuiElementProvider implements IGuiElementProvider {
    @Override
    public IGuiElement CreateBox(float minx, float miny, float maxx, float maxy, int color){
        return CreateBox(minx, miny, maxx, maxy, color, false);
    }
    @Override
    public IGuiElement CreateBox(float minx, float miny, float maxx, float maxy, int color, boolean shouldBlur){
        return new Box(minx, miny, maxx, maxy, color, shouldBlur);
    }
    @Override
    public IGuiElement CreateCircle(float x, float y, float radius, int color){
        return CreateCircle(x, y, radius, color, false);
    }
    @Override
    public IGuiElement CreateCircle(float x, float y, float radius, int color, boolean shouldBlur){
        return new Circle(x, y, radius, color,shouldBlur);
    }
    @Override
    public IGuiElement CreateMoon(float x, float y, float radius1, float radius2, int color){
        return CreateMoon(x, y, radius1, radius2, color, false);
    }
    @Override
    public IGuiElement CreateMoon(float x, float y, float radius1, float radius2, int color, boolean shouldBlur){
        return new Moon(x, y, radius1, radius2, color,shouldBlur);
    }

    @Override
    public IGuiElement CreateBezierTopBox(float minx, float miny, float maxx, float maxy, float topPointX, float topPointY, int color) {
        return CreateBezierTopBox(minx, miny, maxx, maxy, topPointX, topPointY, color,false);
    }

    @Override
    public IGuiElement CreateBezierTopBox(float minx, float miny, float maxx, float maxy, float topPointX, float topPointY, int color, boolean shouldBlur) {
        return new BezierTopBox(minx, miny, maxx, maxy, topPointX, topPointY, color,shouldBlur);
    }
}
