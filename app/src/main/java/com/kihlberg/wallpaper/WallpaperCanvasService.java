package com.kihlberg.wallpaper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;

import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.astronomy.ITimeProvider;
import com.kihlberg.framework.drawing.common.ICanvasSizeProvider;
import com.kihlberg.framework.drawing.common.IGuiElement;
import com.kihlberg.framework.drawing.common.IUpdatableCanvasSizeProvider;
import com.kihlberg.framework.drawing.layers.ISceneLayer;
import com.kihlberg.framework.drawing.scene.ISceneProvider;
import com.kihlberg.framework.drawing.scene.Scene;

/**
 * Created by root on 3/13/15.
 */
public class WallpaperCanvasService implements IWallpaperCanvasService
{
    private ISceneProvider sceneProvider;
    private IUpdatableCanvasSizeProvider updatableCanvasSizeProvider;
    private IAstronomyProvider astronomyProvider;

    private ITimeProvider timeProvider;

    public WallpaperCanvasService(ISceneProvider sceneProvider,
                                  IUpdatableCanvasSizeProvider updatableCanvasSizeProvider,
                                  ITimeProvider timeProvider,
                                  IAstronomyProvider astronomyProvider) {
        this.sceneProvider = sceneProvider;
        this.updatableCanvasSizeProvider = updatableCanvasSizeProvider;
        this.timeProvider=timeProvider;
        this.astronomyProvider = astronomyProvider;
    }

    @Override
    public Canvas DrawCanvas(SurfaceHolder holder) {
        Canvas c = null;
        try {
            c = holder.lockCanvas();

            if (c != null) {
                Paint p = new Paint();
                Path path;
                p.setTextSize(50);
                p.setAntiAlias(true);
                String text = "system time: "+timeProvider.GetTime().toString();
                float w = p.measureText(text, 0, text.length());
                int offset = (int) w / 2;
                int x = c.getWidth()/2 - offset;
                int y = c.getHeight()/2;

                Scene scene = sceneProvider.GetScene();
                ISceneLayer background = scene.background;
                ISceneLayer foreground = scene.foreground;

                p.setStyle(Paint.Style.FILL);

                for (IGuiElement element : background.GetLayerElements())
                {
                    p.setColor(element.GetColor());
                    c.drawPath(element.GetPath(), p);
                }
                for (IGuiElement element : foreground.GetLayerElements())
                {
                    p.setColor(element.GetColor());
                    c.drawPath(element.GetPath(), p);
                }
/*
                p.setStyle(Paint.Style.STROKE);

                for (IGuiElement element : background.GetLayerElements())
                {
                    p.setColor(Color.MAGENTA);
                    c.drawPath(element.GetPath(), p);
                }
*/
/*                p.setColor(sceneProvider.GetScene().sky.color);
                c.drawRect(0, 0, c.getWidth(), c.getHeight(), p);
                p.setColor(Color.GREEN);
                c.drawRect(0, 0 + c.getHeight() * 2 / 3, c.getWidth(), c.getHeight(), p);
*/
                p.setColor(Color.WHITE);
                c.drawText(text, x, y, p);
                c.drawText("Sun Height: " + astronomyProvider.GetSunPosition().getHeight(), x, y + 50, p);
                c.drawText("Sun Az: " + background.GetLayerElements().size(), x, y + 100, p);
                c.drawText("Moon Height: " +astronomyProvider.GetMoonPosition().getHeight(), x ,y+ 150,p);
                c.drawText("Moon Az: " +astronomyProvider.GetMoonPosition().getOrientation(), x ,y+ 200,p);
            }
       }
        finally {

        }
        return c;
    }

    @Override
    public void UpdateCanvasSize(int width, int height) {
        updatableCanvasSizeProvider.SetCanvasSize(width,height);
    }
}
