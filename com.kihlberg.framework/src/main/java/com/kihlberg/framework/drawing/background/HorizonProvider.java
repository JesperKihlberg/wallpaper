package com.kihlberg.framework.drawing.background;

import com.kihlberg.framework.drawing.foreground.CanvasDependant;
import com.kihlberg.framework.interfaces.ICanvasDependant;

/**
 * Created by root on 3/31/15.
 */
public class HorizonProvider extends CanvasDependant implements IHorizonProvider, ICanvasDependant {

    public HorizonProvider() {
    }

    @Override
    public float GetHorizonYCoord(){
        return canvasHeight*5/8;
    }
}
