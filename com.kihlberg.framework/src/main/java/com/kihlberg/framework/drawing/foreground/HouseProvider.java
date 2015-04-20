package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by root on 4/12/15.
 */
public class HouseProvider extends CanvasDependant implements IHouseProvider {
    IGuiElementProvider guiElementProvider;
    IColorProvider colorProvider;
    IHouseSettingsProvider houseSettingsProvider;

    public HouseProvider(IGuiElementProvider guiElementProvider, IColorProvider colorProvider, IHouseSettingsProvider houseSettingsProvider) {
        this.guiElementProvider = guiElementProvider;
        this.colorProvider = colorProvider;
        this.houseSettingsProvider=houseSettingsProvider;
    }

    @Override
    public TreeMap<Integer,IGuiElement> GetSmallHouse(float minX, float minY, float scale){
        IHouseSettings houseSettings = houseSettingsProvider.GetHouseSettings();
        float houseWidth = canvasWidth * houseSettings.GetWidthPercentage() * scale;
        float houseHeight = houseWidth * houseSettings.GetWidthHeightCorrelation();
        boolean isLeftOriented = houseSettings.GetIsLeftOriented();
        TreeMap<Integer,IGuiElement> elements = new  TreeMap<Integer,IGuiElement>();
        float firstHousePartPercentage = houseSettings.GetFirstHousePartPercentage();
        float roofPercentage =houseSettings.GetRoofPercentage();
        if(isLeftOriented) {
            elements.putAll(GetThirdHousePart(minX, minY - houseHeight / 2, houseWidth, houseHeight, firstHousePartPercentage * 2, isLeftOriented, roofPercentage));
            elements.putAll(GetSecondHousePart(minX + houseWidth * 2 * firstHousePartPercentage, minY - houseHeight / 2, houseWidth, houseHeight, 1 - 3 * firstHousePartPercentage, isLeftOriented, roofPercentage));
            elements.putAll(GetFirstHousePart(minX + houseWidth * (1 - firstHousePartPercentage), minY - houseHeight / 2, houseWidth, houseHeight, firstHousePartPercentage, isLeftOriented, roofPercentage));
        }
        else{
            elements.putAll(GetFirstHousePart(minX, minY - houseHeight / 2, houseWidth, houseHeight, firstHousePartPercentage, isLeftOriented, roofPercentage));
            elements.putAll(GetSecondHousePart(minX + houseWidth * firstHousePartPercentage, minY - houseHeight / 2, houseWidth, houseHeight, 1 - 3 * firstHousePartPercentage, isLeftOriented, roofPercentage));
            elements.putAll(GetThirdHousePart(minX + houseWidth * (1 - 2 * firstHousePartPercentage), minY - houseHeight / 2, houseWidth, houseHeight, firstHousePartPercentage * 2, isLeftOriented, roofPercentage));
        }
       return elements;
    }

    private TreeMap<Integer,IGuiElement> GetFirstHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage, boolean isLeftOriented, float roofPercentage){
        float topPointX = (float) Math.ceil(minX + houseWidth*partPercentage);
        if(isLeftOriented)
            topPointX = minX;
        TreeMap<Integer,IGuiElement> elements = new TreeMap<Integer,IGuiElement>();
        IGuiElement roof =  guiElementProvider.CreateTriangle(
                minX, minY + houseHeight * roofPercentage,
                topPointX, minY,
                (float) Math.ceil(minX + houseWidth*partPercentage), minY + houseHeight * roofPercentage,
                new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
        elements.put((int) ((minY+houseHeight)*100+1),roof);

        IGuiElement base =  guiElementProvider.CreateBox(
                minX, minY + houseHeight * roofPercentage,
                (float) Math.ceil(minX + houseWidth*partPercentage), minY + houseHeight,
                new BaseColorSetting(GuiElementType.SmallBuilding, isLeftOriented?colorProvider.GetSmallBuildingColor2():colorProvider.GetSmallBuildingColor1()));
        elements.put((int) ((minY+houseHeight)*100+2),base);

        return  elements;
    }

    private TreeMap<Integer,IGuiElement> GetSecondHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage, boolean isLeftOriented, float roofPercentage){
        TreeMap<Integer,IGuiElement> elements = new TreeMap<Integer,IGuiElement>();
        IGuiElement roof =  guiElementProvider.CreateBox(
                minX, minY,
                (float) Math.ceil(minX + houseWidth * partPercentage), minY + houseHeight * roofPercentage,
                new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
        elements.put((int) ((minY+houseHeight)*100+3),roof);

        IGuiElement base =  guiElementProvider.CreateBox(
                minX, minY + houseHeight * roofPercentage,
                (float) Math.ceil(minX + houseWidth*partPercentage), minY + houseHeight,
                new BaseColorSetting(GuiElementType.SmallBuilding, isLeftOriented?colorProvider.GetSmallBuildingColor2():colorProvider.GetSmallBuildingColor1()));
        elements.put((int) ((minY+houseHeight)*100+4),base);

        return  elements;
    }

    private TreeMap<Integer,IGuiElement> GetThirdHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage, boolean isLeftOriented, float roofPercentage){
        TreeMap<Integer,IGuiElement> elements = new TreeMap<Integer,IGuiElement>();
        if(isLeftOriented){
            IGuiElement roof = guiElementProvider.CreateTriangle(
                    minX + houseWidth * partPercentage, minY,
                    minX+ houseWidth * partPercentage, minY + houseHeight * roofPercentage,
                    minX + houseWidth * partPercentage / 2, minY,
                    new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
            elements.put((int) ((minY+houseHeight)*100+5),roof);
        }
        else {
            IGuiElement roof = guiElementProvider.CreateTriangle(
                    minX, minY,
                    minX + houseWidth * partPercentage / 2, minY,
                    minX, minY + houseHeight * roofPercentage,
                    new BaseColorSetting(GuiElementType.Roof, colorProvider.GetRoofColor()));
            elements.put((int) ((minY+houseHeight)*100+6),roof);
        }
        IGuiElement topfacade =  guiElementProvider.CreateTriangle(
                minX, minY + houseHeight * roofPercentage,
                minX + houseWidth*partPercentage/2, minY,
                minX + houseWidth*partPercentage, minY + houseHeight * roofPercentage,
                new BaseColorSetting(GuiElementType.Roof, isLeftOriented?colorProvider.GetSmallBuildingColor1():colorProvider.GetSmallBuildingColor2()));
        elements.put((int) ((minY+houseHeight)*100+8),topfacade);

        IGuiElement base =  guiElementProvider.CreateBox(
                minX, minY + houseHeight * roofPercentage,
                minX + houseWidth*partPercentage, minY + houseHeight,
                new BaseColorSetting(GuiElementType.SmallBuilding, isLeftOriented?colorProvider.GetSmallBuildingColor1():colorProvider.GetSmallBuildingColor2()));
        elements.put((int) ((minY+houseHeight)*100+9),base);

        return  elements;
    }
}
