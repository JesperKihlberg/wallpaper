package com.kihlberg.framework.drawing.common;

/**
 * Created by root on 4/3/15.
 */
public abstract class GuiElement implements IGuiElement {
    private int color;

    protected GuiElement(int color) {
        this.color = color;
    }

    @Override
    public int GetColor() {
        return color;
    }
}
