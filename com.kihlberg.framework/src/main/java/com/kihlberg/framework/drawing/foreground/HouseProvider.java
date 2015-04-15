package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by root on 4/12/15.
 */
public class HouseProvider extends CanvasDependant implements IHouseProvider {
    IGuiElementProvider guiElementProvider;
    IColorProvider colorProvider;

    static float widthHeightCorrelation = 0.7f;
    static float widthPercentage =0.1f;
    static float roofPercentage = 0.45f;
    static float overhangPercentage =0.1f;

    public HouseProvider(IGuiElementProvider guiElementProvider, IColorProvider colorProvider) {
        this.guiElementProvider = guiElementProvider;
        this.colorProvider = colorProvider;
    }

    @Override
    public List<IGuiElement> GetSmallHouse(float minX, float minY, float scale){
        float houseWidth = canvasWidth * widthPercentage * scale;
        float houseHeight = houseWidth * widthHeightCorrelation;
        ArrayList<IGuiElement> elements = new ArrayList<>();
        IGuiElement roof =  guiElementProvider.CreateTriangle(minX, minY + houseHeight * roofPercentage, minX + houseWidth*0.5f, minY, minX + houseWidth, minY + houseHeight * roofPercentage, new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
        elements.add(roof);
        IGuiElement base =  guiElementProvider.CreateBox(minX + overhangPercentage*houseWidth, minY + houseHeight * roofPercentage, minX + houseWidth - overhangPercentage*houseWidth, minY + houseHeight, new BaseColorSetting(GuiElementType.SmallBuilding, colorProvider.GetSmallBuildingColor()));
        elements.add(base);
        return elements;
    }
}
