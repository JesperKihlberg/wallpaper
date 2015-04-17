package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.drawing.layers.ISceneLayer;

/**
 * Created by root on 4/11/15.
 */
public interface IForegroundLayerProvider {
    void Initialize(float yStart, float yEnd, float scale);
    ISceneLayer GetLayer();
}
