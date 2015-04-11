package com.kihlberg.wallpaper.common;

/**
 * Created by root on 4/3/15.
 */
public abstract class GuiElement implements IAndroidGuiElement {
    private int color;
    private boolean shouldBlur;

    protected GuiElement(int color, boolean shouldBlur) {
        this.color = color;
        this.shouldBlur=shouldBlur;
    }

    @Override
    public int GetColor() {
        return color;
    }

    public boolean ShouldBlur(){
        return shouldBlur;
    }
}
