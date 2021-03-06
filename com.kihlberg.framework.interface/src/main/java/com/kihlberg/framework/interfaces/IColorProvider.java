package com.kihlberg.framework.interfaces;

/**
 * Created by root on 3/22/15.
 */
public interface IColorProvider {
    public int GetSkyColor();

    public int GetSunColor();

    int GetMoonColor();

    int GetGroundColor();

    int GetRoofColor();

    int GetSmallBuildingColor1();

    int GetSmallBuildingColor2();

    int GetTreeCrownColor();

    int GetTreeTrunkColor();
}
