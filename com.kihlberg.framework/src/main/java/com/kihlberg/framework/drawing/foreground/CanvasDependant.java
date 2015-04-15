package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.ICanvasDependant;

/**
 * Created by root on 4/15/15.
 */
public abstract class CanvasDependant implements ICanvasDependant {
    protected float canvasWidth= 0;
    protected float canvasHeight =0;

    @Override
    public void NotifyCanvasSizeChanged(float width, float height) {
        canvasWidth = width;
        canvasHeight = height;
    }

}
