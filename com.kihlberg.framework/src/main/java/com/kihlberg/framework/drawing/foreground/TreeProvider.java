package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/19/15.
 */
public class TreeProvider extends CanvasDependant implements ITreeProvider {
    private IColorProvider colorProvider;
    private IGuiElementProvider guiElementProvider;

    static float widthHeightCorrelation = 2f;
    static float widthPercentage =0.05f;
    static float trunkHeightPercentage = 0.3f;
    static float trunkWidthPercentage = 0.1f;
    static float crownHeightPercentage = 0.80f;

    public TreeProvider(IColorProvider colorProvider, IGuiElementProvider guiElementProvider) {
        this.colorProvider = colorProvider;
        this.guiElementProvider = guiElementProvider;
    }

    @Override
    public List<IGuiElement> GetTree(float minx, float miny, float scale){
        ArrayList<IGuiElement> elements = new ArrayList<IGuiElement>();
        float width= canvasWidth*widthPercentage*scale;
        float height = width*widthHeightCorrelation;
        elements.add(guiElementProvider.CreateTriangle(
                minx, miny + height*crownHeightPercentage,
                minx+width/2, miny,
                minx+width, miny + height*crownHeightPercentage,
                new BaseColorSetting(GuiElementType.TreeCrown, colorProvider.GetTreeCrownColor())
        ));
        elements.add(guiElementProvider.CreateTriangle(
                minx+width/2-trunkWidthPercentage*width, miny+height,
                minx+width/2, miny+ height-trunkHeightPercentage*height,
                minx+width/2+trunkWidthPercentage*width, miny+height,
                new BaseColorSetting(GuiElementType.TreeTrunk, colorProvider.GetTreeTrunkColor())
        ));
        return elements;
    }
}
