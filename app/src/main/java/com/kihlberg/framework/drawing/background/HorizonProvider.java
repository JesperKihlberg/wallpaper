package com.kihlberg.framework.drawing.background;

import com.kihlberg.framework.drawing.common.ICanvasDependant;
import com.kihlberg.framework.drawing.common.ICanvasSizeProvider;

/**
 * Created by root on 3/31/15.
 */
public class HorizonProvider implements IHorizonProvider, ICanvasDependant {
    private float canvasWidth = 0;
    private  float canvasHeight = 0;

    public HorizonProvider() {
    }

    @Override
    public float GetHorizonYCoord(){
        return canvasHeight*2/3;
    }

    @Override
    public void NotifyCanvasSizeChanged(float width, float height) {
        canvasWidth = width;
        canvasHeight = height;
    }
}
