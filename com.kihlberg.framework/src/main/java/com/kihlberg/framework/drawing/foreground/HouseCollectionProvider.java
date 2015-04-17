package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 4/16/15.
 */
public class HouseCollectionProvider implements IHouseCollectionProvider {
    IHouseProvider houseProvider = null;

    public HouseCollectionProvider(IHouseProvider houseProvider) {
        this.houseProvider = houseProvider;
    }

    @Override
    public List<IGuiElement> GetHouses(float minY, float maxY, float minX, float maxX, int smallHouseCount, int mediumHouseCount, int largeHouseCount, float scale){
        ArrayList<IGuiElement> elements = new ArrayList<IGuiElement>();
        float[] ycoords = CreateYCoords(smallHouseCount+mediumHouseCount+largeHouseCount, minY,maxY);
        for(int i = 0; i<ycoords.length; i++){
            float xcoord = (float)(minX + (Math.random()*(maxX-minX)));
            elements.addAll(houseProvider.GetSmallHouse(xcoord, ycoords[i], scale));
            //TODO: Create medium and large houses
        }
        return elements;
    }

    private float[] CreateYCoords(int count, float minY, float maxY){
        float[] array = new float[count];
        for(int i = 0; i< count; i++) {
            array[i] = (float)(minY + (Math.random()*(maxY-minY)));
        }
        Arrays.sort(array);
        return array;
    }

}
