package com.kihlberg.wallpaper;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by root on 3/13/15.
 */
public interface IWallpaperCanvasService {
    public Canvas DrawCanvas(SurfaceHolder holder);

    void UpdateCanvasSize(int width, int height);
}
