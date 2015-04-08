package com.kihlberg.wallpaper.common;

/**
 * Created by root on 4/3/15.
 */
public abstract class GuiElement implements IAndroidGuiElement {
    private int color;

    protected GuiElement(int color) {
        this.color = color;
    }

    @Override
    public int GetColor() {
        return color;
    }
}
