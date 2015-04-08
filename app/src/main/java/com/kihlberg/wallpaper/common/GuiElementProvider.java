package com.kihlberg.wallpaper.common;

import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

/**
 * Created by root on 4/7/15.
 */
public class GuiElementProvider implements IGuiElementProvider {
    @Override
    public IGuiElement CreateBox(float minx, float miny, float maxx, float maxy, int color){
        return new Box(minx, miny, maxx, maxy, color);
    }
    @Override
    public IGuiElement CreateCircle(float x, float y, float radius, int color){
        return new Circle(x, y, radius, color);
    }
    @Override
    public IGuiElement CreateMoon(float x, float y, float radius1, float radius2, int color){
        return new Moon(x, y, radius1, radius2, color);
    }
}
