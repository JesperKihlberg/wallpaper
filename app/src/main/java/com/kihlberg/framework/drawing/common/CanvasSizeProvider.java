package com.kihlberg.framework.drawing.common;

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
            canvasDependants.NotifyCanvasSizeChanged( width, height);
        }

    }

    public CanvasSizeProvider(List<ICanvasDependant> canvasDependantsList) {
        this.width = 100;
        this.height = 100;
        this.canvasDependantsList=canvasDependantsList;
    }
}
