package com.kihlberg.wallpaper.common;

import com.kihlberg.framework.interfaces.ICanvasDependant;

import java.util.List;

/**
 * Created by root on 3/19/15.
 */
public class CanvasSizeProvider implements IUpdatableCanvasSizeProvider{
    List<ICanvasDependant> canvasDependantsList;

    private float width;
    private float height;

    @Override
    public float GetWidth() {
        return width;
    }

    @Override
    public float GetHeight() {
        return height;
    }

    @Override
    public void SetCanvasSize(float width, float height) {
        this.width=width;
        this.height= height;
        for(ICanvasDependant canvasDependants : canvasDependantsList) {
            canvasDependants.NotifyCanvasSizeChanged( this.width, this.height);
        }

    }

    public CanvasSizeProvider(List<ICanvasDependant> canvasDependantsList) {
        this.width = 100;
        this.height = 100;
        this.canvasDependantsList=canvasDependantsList;
    }
}
