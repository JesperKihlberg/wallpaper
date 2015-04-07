package com.kihlberg.framework.drawing.scene;

import com.kihlberg.framework.drawing.layers.ISceneLayer;
import com.kihlberg.framework.drawing.sky.Sky;

/**
 * Created by root on 3/16/15.
 */
public class Scene {
    public ISceneLayer background;
    public ISceneLayer foreground;

    public Scene(ISceneLayer foreground, ISceneLayer background) {
        this.foreground = foreground;
        this.background = background;
    }
}
