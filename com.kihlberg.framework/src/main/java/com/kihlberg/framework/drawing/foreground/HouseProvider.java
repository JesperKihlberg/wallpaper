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
        float firstHousePartPercentage = 0.25f;
        float houseWidth = canvasWidth * widthPercentage * scale;
        float houseHeight = houseWidth * widthHeightCorrelation;
        ArrayList<IGuiElement> elements = new ArrayList<>();
        boolean isLeftOriented = true;
        if(isLeftOriented) {
            elements.addAll(GetThirdHousePart(minX, minY, houseWidth, houseHeight, firstHousePartPercentage * 2, isLeftOriented));
            elements.addAll(GetSecondHousePart(minX + houseWidth * 2* firstHousePartPercentage, minY, houseWidth, houseHeight, 1 - 3 * firstHousePartPercentage, isLeftOriented));
            elements.addAll(GetFirstHousePart(minX + houseWidth *  (1 - firstHousePartPercentage), minY, houseWidth, houseHeight, firstHousePartPercentage, isLeftOriented));
        }
        else{
            elements.addAll(GetFirstHousePart(minX, minY, houseWidth, houseHeight, firstHousePartPercentage, isLeftOriented));
            elements.addAll(GetSecondHousePart(minX + houseWidth * firstHousePartPercentage, minY, houseWidth, houseHeight, 1 - 3 * firstHousePartPercentage, isLeftOriented));
            elements.addAll(GetThirdHousePart(minX + houseWidth * (1 - 2 * firstHousePartPercentage), minY, houseWidth, houseHeight, firstHousePartPercentage * 2, isLeftOriented));
        }
       return elements;
    }

    private List<IGuiElement> GetFirstHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage, boolean isLeftOriented){
        float topPointX = (float) Math.ceil(minX + houseWidth*partPercentage);
        if(isLeftOriented)
            topPointX = minX;
        ArrayList<IGuiElement> elements = new ArrayList<>();
        IGuiElement roof =  guiElementProvider.CreateTriangle(
                minX, minY + houseHeight * roofPercentage,
                topPointX, minY,
                (float) Math.ceil(minX + houseWidth*partPercentage), minY + houseHeight * roofPercentage,
                new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
        elements.add(roof);

        IGuiElement base =  guiElementProvider.CreateBox(
                minX, minY + houseHeight * roofPercentage,
                (float) Math.ceil(minX + houseWidth*partPercentage), minY + houseHeight,
                new BaseColorSetting(GuiElementType.SmallBuilding, isLeftOriented?colorProvider.GetSmallBuildingColor2():colorProvider.GetSmallBuildingColor1()));
        elements.add(base);

        return  elements;
    }

    private List<IGuiElement> GetSecondHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage, boolean isLeftOriented){
        ArrayList<IGuiElement> elements = new ArrayList<>();
        IGuiElement roof =  guiElementProvider.CreateBox(
                minX, minY,
                (float) Math.ceil(minX + houseWidth * partPercentage), minY + houseHeight * roofPercentage,
                new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
        elements.add(roof);

        IGuiElement base =  guiElementProvider.CreateBox(
                minX, minY + houseHeight * roofPercentage,
                (float) Math.ceil(minX + houseWidth*partPercentage), minY + houseHeight,
                new BaseColorSetting(GuiElementType.SmallBuilding, isLeftOriented?colorProvider.GetSmallBuildingColor2():colorProvider.GetSmallBuildingColor1()));
        elements.add(base);

        return  elements;
    }

    private List<IGuiElement> GetThirdHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage, boolean isLeftOriented){
        ArrayList<IGuiElement> elements = new ArrayList<>();
        if(isLeftOriented){
            IGuiElement roof = guiElementProvider.CreateTriangle(
                    minX + houseWidth * partPercentage, minY,
                    minX+ houseWidth * partPercentage, minY + houseHeight * roofPercentage,
                    minX + houseWidth * partPercentage / 2, minY,
                    new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
            elements.add(roof);
        }
        else {
            IGuiElement roof = guiElementProvider.CreateTriangle(
                    minX, minY,
                    minX + houseWidth * partPercentage / 2, minY,
                    minX, minY + houseHeight * roofPercentage,
                    new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
            elements.add(roof);
        }
        IGuiElement topfacade =  guiElementProvider.CreateTriangle(
                minX, minY + houseHeight * roofPercentage,
                minX + houseWidth*partPercentage/2, minY,
                minX + houseWidth*partPercentage, minY + houseHeight * roofPercentage,
                new BaseColorSetting(GuiElementType.Roof, isLeftOriented?colorProvider.GetSmallBuildingColor1():colorProvider.GetSmallBuildingColor2()));
        elements.add(topfacade);

        IGuiElement base =  guiElementProvider.CreateBox(
                minX, minY + houseHeight * roofPercentage,
                minX + houseWidth*partPercentage, minY + houseHeight,
                new BaseColorSetting(GuiElementType.SmallBuilding, isLeftOriented?colorProvider.GetSmallBuildingColor1():colorProvider.GetSmallBuildingColor2()));
        elements.add(base);

        return  elements;
    }
}
