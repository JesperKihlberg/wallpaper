package com.kihlberg.wallpaper.common;

import com.kihlberg.framework.interfaces.ICanvasSizeProvider;

/**
 * Created by root on 3/19/15.
 */
public interface IUpdatableCanvasSizeProvider extends ICanvasSizeProvider {
    public void SetCanvasSize(float width, float height);
}
