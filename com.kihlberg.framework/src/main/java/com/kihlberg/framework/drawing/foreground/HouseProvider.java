package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import java.util.ArrayList;
import java.util.List;

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
    public List<IGuiElement> GetSmallHouse(float minX, float minY, float scale){
        IHouseSettings houseSettings = houseSettingsProvider.GetHouseSettings();
        float houseWidth = canvasWidth * houseSettings.GetWidthPercentage() * scale;
        float houseHeight = houseWidth * houseSettings.GetWidthHeightCorrelation();
        boolean isLeftOriented = houseSettings.GetIsLeftOriented();
        ArrayList<IGuiElement> elements = new ArrayList<>();
        float firstHousePartPercentage = houseSettings.GetFirstHousePartPercentage();
        float roofPercentage =houseSettings.GetRoofPercentage();
        if(isLeftOriented) {
            elements.addAll(GetThirdHousePart(minX, minY-houseHeight/2, houseWidth, houseHeight, firstHousePartPercentage * 2, isLeftOriented,roofPercentage ));
            elements.addAll(GetSecondHousePart(minX + houseWidth * 2* firstHousePartPercentage, minY-houseHeight/2, houseWidth, houseHeight, 1 - 3 * firstHousePartPercentage, isLeftOriented,roofPercentage ));
            elements.addAll(GetFirstHousePart(minX + houseWidth *  (1 - firstHousePartPercentage), minY-houseHeight/2, houseWidth, houseHeight, firstHousePartPercentage, isLeftOriented,roofPercentage ));
        }
        else{
            elements.addAll(GetFirstHousePart(minX, minY-houseHeight/2, houseWidth, houseHeight, firstHousePartPercentage, isLeftOriented,roofPercentage ));
            elements.addAll(GetSecondHousePart(minX + houseWidth * firstHousePartPercentage, minY-houseHeight/2, houseWidth, houseHeight, 1 - 3 * firstHousePartPercentage, isLeftOriented,roofPercentage ));
            elements.addAll(GetThirdHousePart(minX + houseWidth * (1 - 2 * firstHousePartPercentage), minY-houseHeight/2, houseWidth, houseHeight, firstHousePartPercentage * 2, isLeftOriented,roofPercentage ));
        }
       return elements;
    }

    private List<IGuiElement> GetFirstHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage, boolean isLeftOriented, float roofPercentage){
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

    private List<IGuiElement> GetSecondHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage, boolean isLeftOriented, float roofPercentage){
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

    private List<IGuiElement> GetThirdHousePart(float minX, float minY, float houseWidth, float houseHeight, float partPercentage, boolean isLeftOriented, float roofPercentage){
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
