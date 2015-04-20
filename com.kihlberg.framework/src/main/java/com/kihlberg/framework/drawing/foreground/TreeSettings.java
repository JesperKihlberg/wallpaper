package com.kihlberg.framework.drawing.foreground;

/**
 * Created by root on 4/20/15.
 */
public class TreeSettings {
    static float widthHeightCorrelation = 2f;
    static float widthPercentage =0.05f;
    static float trunkHeightPercentage = 0.3f;
    static float trunkWidthPercentage = 0.1f;
    static float crownHeightPercentage = 0.80f;

    public float GetWidthHeightCorrelation(){ return (float) ((Math.random()+9.5)/ 5); }
    public float GetWidthPercentage(){return (float) ((Math.random()+4.5)/ 100f);}
    public float GetTrunkHeightPercentage(){ return 0.3f;}
    public float GetTrunkWidthPercentage(){ return 0.1f;}
    public float GetCrownHeightPercentage(){ return (float) ((Math.random() + 7.5)/10);}
}
