package com.kihlberg.framework.drawing.foreground;

/**
 * Created by root on 4/17/15.
 */
public class HouseSettings implements IHouseSettings {
    float firstHousePartPercentage = 0.25f;
    boolean isLeftOriented = true;
    static float widthHeightCorrelation = 0.5f;
    static float widthPercentage =0.1f;
    static float roofPercentage = 0.45f;

    @Override
    public float GetWidthPercentage() {
        return (float)(Math.random()+3.5)*0.025f;
    }

    @Override
    public float GetWidthHeightCorrelation() {
        return (float)(0.5+(Math.random()-0.5)/10);
    }

    @Override
    public boolean GetIsLeftOriented() {
        return Math.random()>0.5;
    }

    @Override
    public float GetFirstHousePartPercentage() {
        return (float)Math.random()*firstHousePartPercentage;
    }

    @Override
    public float GetRoofPercentage() {
        return (float)(0.45+(Math.random() - 0.5) /10);
    }
}
