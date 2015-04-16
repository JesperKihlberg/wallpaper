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

    static float widthHeightCorrelation = 0.5f;
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
        elements.addAll(GetFirstHousePart(minX, minY,houseWidth, houseHeight, 0.10f));
        elements.addAll(GetSecondHousePart(minX+houseWidth*0.1f, minY,houseWidth, houseHeight, 0.70f));
        elements.addAll(GetThirdHousePart(minX+houseWidth*0.8f, minY,houseWidth, houseHeight, 0.20f));
//        IGuiElement roof =  guiElementProvider.CreateTriangle(minX, minY + houseHeight * roofPercentage, minX + houseWidth*0.5f, minY, minX + houseWidth, minY + houseHeight * roofPercentage, new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
//        elements.add(roof);
//        IGuiElement base =  guiElementProvider.CreateBox(minX + overhangPercentage*houseWidth, minY + houseHeight * roofPercentage, minX + houseWidth - overhangPercentage*houseWidth, minY + houseHeight, new BaseColorSetting(GuiElementType.SmallBuilding, colorProvider.GetSmallBuildingColor1()));
//        elements.add(base);
        return elements;
    }

    private List<IGuiElement> GetFirstHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage){
        ArrayList<IGuiElement> elements = new ArrayList<>();
        IGuiElement roof =  guiElementProvider.CreateTriangle(
                minX, minY + houseHeight * roofPercentage,
                (float) Math.ceil(minX + houseWidth*partPercentage), minY,
                (float) Math.ceil(minX + houseWidth*partPercentage), minY + houseHeight * roofPercentage,
                new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
        elements.add(roof);

        IGuiElement base =  guiElementProvider.CreateBox(
                minX, minY + houseHeight * roofPercentage,
                (float) Math.ceil(minX + houseWidth*partPercentage), minY + houseHeight,
                new BaseColorSetting(GuiElementType.SmallBuilding, colorProvider.GetSmallBuildingColor1()));
        elements.add(base);

        return  elements;
    }

    private List<IGuiElement> GetSecondHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage){
        ArrayList<IGuiElement> elements = new ArrayList<>();
        IGuiElement roof =  guiElementProvider.CreateBox(
                minX, minY,
                (float) Math.ceil(minX+houseWidth*partPercentage),  minY + houseHeight * roofPercentage,
                new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
        elements.add(roof);

        IGuiElement base =  guiElementProvider.CreateBox(
                minX, minY + houseHeight * roofPercentage,
                (float) Math.ceil(minX + houseWidth*partPercentage), minY + houseHeight,
                new BaseColorSetting(GuiElementType.SmallBuilding, colorProvider.GetSmallBuildingColor1()));
        elements.add(base);

        return  elements;
    }

    private List<IGuiElement> GetThirdHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage){
        ArrayList<IGuiElement> elements = new ArrayList<>();
        IGuiElement roof =  guiElementProvider.CreateTriangle(
                minX, minY,
                minX + houseWidth*partPercentage/2, minY,
                minX, minY + houseHeight * roofPercentage,
                new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
        elements.add(roof);

        IGuiElement topfacade =  guiElementProvider.CreateTriangle(
                minX, minY + houseHeight * roofPercentage,
                minX + houseWidth*partPercentage/2, minY,
                minX + houseWidth*partPercentage, minY + houseHeight * roofPercentage,
                new BaseColorSetting(GuiElementType.Roof, colorProvider.GetSmallBuildingColor2()));
        elements.add(topfacade);

        IGuiElement base =  guiElementProvider.CreateBox(
                minX, minY + houseHeight * roofPercentage,
                minX + houseWidth*partPercentage, minY + houseHeight,
                new BaseColorSetting(GuiElementType.SmallBuilding, colorProvider.GetSmallBuildingColor2()));
        elements.add(base);

        return  elements;
    }
}
