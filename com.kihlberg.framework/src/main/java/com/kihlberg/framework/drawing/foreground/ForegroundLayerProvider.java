package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.drawing.layers.ISceneLayer;
import com.kihlberg.framework.drawing.layers.SceneLayer;
import com.kihlberg.framework.interfaces.ICanvasDependant;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/11/15.
 */
public class ForegroundLayerProvider implements ICanvasDependant, IForegroundLayerProvider {
    protected IColorProvider colorProvider;
    protected IGuiElementProvider guiElementProvider;

    private float canvasWidth= 0;
    private float canvasHeight =0;
    private float rand1 = 0;
    private float rand2 = 0;
    int color1;
    public ForegroundLayerProvider(IColorProvider colorProvider, IGuiElementProvider guiElementProvider) {
        this.colorProvider = colorProvider;
        this.guiElementProvider=guiElementProvider;

        rand1 = (float) Math.random();
        rand2 = (float) Math.random();
        color1 = colorProvider.GetGroundColor();
    }

    @Override
    public ISceneLayer GetLayer(float yShift) {
        List<IGuiElement> elements = new ArrayList<IGuiElement>();
        float baseMinY=canvasHeight * 2 / 3+ yShift;
        float topPointX= (float) (canvasWidth*rand1);
        float topPointY =baseMinY + (float)((rand2-0.5)*canvasHeight/25);
        elements.add(guiElementProvider.CreateBezierTopBox(0, baseMinY, canvasWidth, canvasHeight, topPointX, topPointY, color1));

        return new SceneLayer(elements);
    }

    @Override
    public void NotifyCanvasSizeChanged(float width, float height) {
        canvasWidth = width;
        canvasHeight = height;
    }

}