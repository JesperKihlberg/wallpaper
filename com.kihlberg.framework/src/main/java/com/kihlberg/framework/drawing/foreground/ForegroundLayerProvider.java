package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.drawing.background.IHorizonProvider;
import com.kihlberg.framework.drawing.layers.ISceneLayer;
import com.kihlberg.framework.drawing.layers.SceneLayer;
import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;
import com.kihlberg.framework.interfaces.ICanvasDependant;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/11/15.
 */
public class ForegroundLayerProvider extends CanvasDependant implements ICanvasDependant, IForegroundLayerProvider {
    protected IColorProvider colorProvider;
    protected IGuiElementProvider guiElementProvider;
    protected IHouseProvider houseProvider;

    private float rand1 = 0;
    private float rand2 = 0;
    int color1;
    public ForegroundLayerProvider(IColorProvider colorProvider, IGuiElementProvider guiElementProvider,IHouseProvider houseProvider) {
        this.colorProvider = colorProvider;
        this.guiElementProvider=guiElementProvider;
        this.houseProvider=houseProvider;

        rand1 = (float) Math.random();
        rand2 = (float) Math.random();
        color1 = colorProvider.GetGroundColor();
    }

    @Override
    public ISceneLayer GetLayer(float yStart, float yEnd, float scale) {
        List<IGuiElement> elements = new ArrayList<IGuiElement>();

        float baseMinY=yStart;
        float topPointX= (float) (canvasWidth*rand1);
        float topPointY =baseMinY + (float)((rand2-0.5)*canvasHeight/20);
        elements.add(guiElementProvider.CreateBezierTopBox(0, baseMinY, canvasWidth, canvasHeight, topPointX, topPointY,
                new BaseColorSetting( GuiElementType.Grassland, color1)));

        elements.addAll(houseProvider.GetSmallHouse(topPointX,baseMinY,scale));

        return new SceneLayer(elements);
    }

}
