package com.kihlberg.wallpaper.common;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;

/**
 * Created by root on 4/3/15.
 */
public abstract class GuiElement implements IAndroidGuiElement {
    private BaseColorSetting color;
    private GuiElementType type;
    private boolean shouldBlur;

    protected GuiElement(BaseColorSetting color, boolean shouldBlur) {
        this.color = color;
        this.shouldBlur=shouldBlur;
    }

    @Override
    public BaseColorSetting GetColor() {
        return color;
    }

    public boolean ShouldBlur(){
        return shouldBlur;
    }
}
