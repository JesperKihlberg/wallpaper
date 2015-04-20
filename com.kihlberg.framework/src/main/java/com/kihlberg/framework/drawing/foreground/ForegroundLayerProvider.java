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
import java.util.TreeMap;

/**
 * Created by root on 4/11/15.
 */
public class ForegroundLayerProvider extends CanvasDependant implements ICanvasDependant, IForegroundLayerProvider {
    protected IColorProvider colorProvider;
    protected IGuiElementProvider guiElementProvider;
    protected IHouseCollectionProvider houseCollectionProvider;
    protected  ITreeProvider treeProvider;

    private float rand1 = 0;
    private float rand2 = 0;
    TreeMap<Integer, IGuiElement> sceneLayer;
    float yStart, yEnd, scale;

    public ForegroundLayerProvider(IColorProvider colorProvider, IGuiElementProvider guiElementProvider, IHouseCollectionProvider houseCollectionProvider,ITreeProvider treeProvider) {
        this.colorProvider = colorProvider;
        this.guiElementProvider = guiElementProvider;
        this.houseCollectionProvider = houseCollectionProvider;
        this.treeProvider=treeProvider;
    }

    public void Initialize(float yStart, float yEnd, float scale){
        this.yStart=yStart;
        this.yEnd=yEnd;
        this.scale = scale;
        UpdateLayer();
    }

    public TreeMap<Integer, IGuiElement> GetLayer() {
        return sceneLayer;
    }

    private void UpdateLayer(){
        TreeMap<Integer,IGuiElement> elements = new TreeMap<Integer,IGuiElement>();

        rand1 = (float) Math.random();
        rand2 = (float) Math.random();
        int color1 = colorProvider.GetGroundColor();

        float baseMinY=yStart;
        float topPointX= (float) (canvasWidth*rand1);
        float topPointY =baseMinY + (float)((rand2-0.5)*canvasHeight/20);
        elements.put((int) this.yStart, guiElementProvider.CreateBezierTopBox(0, baseMinY, canvasWidth, canvasHeight, topPointX, topPointY,
                new BaseColorSetting(GuiElementType.Grassland, color1)));
        elements.putAll(treeProvider.GetTree(topPointX, topPointY, scale));
        elements.putAll(houseCollectionProvider.GetHouses(yStart, yEnd, 0, canvasWidth, 10, 0, 0, scale));

        this.sceneLayer= elements;

    }

    @Override
    public void NotifyCanvasSizeChanged(float width, float height) {
        super.NotifyCanvasSizeChanged(width, height);
        UpdateLayer();
    }
}
