package com.kihlberg.framework.interfaces;

import com.kihlberg.framework.interfaces.GuiElementType;

/**
 * Created by root on 4/13/15.
 */
public class BaseColorSetting {
    private int color;
    private GuiElementType type;

    public BaseColorSetting(GuiElementType type, int color) {
        this.color = color;
        this.type = type;
    }

    public int GetColor() {
        return this.color;
    }
}
