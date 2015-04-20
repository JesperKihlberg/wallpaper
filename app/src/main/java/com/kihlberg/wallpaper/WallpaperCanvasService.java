package com.kihlberg.wallpaper;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;

import com.kihlberg.framework.astronomy.IAstronomyProvider;
import com.kihlberg.framework.interfaces.ITimeProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.drawing.layers.ISceneLayer;
import com.kihlberg.framework.drawing.scene.ISceneProvider;
import com.kihlberg.framework.drawing.scene.Scene;
import com.kihlberg.wallpaper.common.IAndroidGuiElement;
import com.kihlberg.wallpaper.common.IUpdatableCanvasSizeProvider;

import java.util.TreeMap;

/**
 * Created by root on 3/13/15.
 */
public class WallpaperCanvasService implements IWallpaperCanvasService
{
    private ISceneProvider sceneProvider;
    private IUpdatableCanvasSizeProvider updatableCanvasSizeProvider;
    private IAstronomyProvider astronomyProvider;

    ISceneLayer cachedForeground ;

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
                int y = 70;

                TreeMap<Integer, IGuiElement> scene = sceneProvider.GetScene();

                p.setStyle(Paint.Style.FILL);

                for (IGuiElement guiElement : scene.values())
                {
                    IAndroidGuiElement element = (IAndroidGuiElement)guiElement;
                    p.setColor(element.GetColor().GetColor());
                    MaskFilter filter = p.getMaskFilter();
                    if(element.ShouldBlur()) {
                        BlurMaskFilter maskFilter = new BlurMaskFilter(20, BlurMaskFilter.Blur.NORMAL);
                        p.setMaskFilter(maskFilter);
                        c.drawPath(element.GetPath(), p);
                         maskFilter = new BlurMaskFilter(5, BlurMaskFilter.Blur.NORMAL);
                        p.setMaskFilter(maskFilter);
                        c.drawPath(element.GetPath(), p);
                        p.setMaskFilter(filter);
                        c.drawPath(element.GetPath(), p);
                    }
                    else
                        c.drawPath(element.GetPath(), p);
                }
/*                for (IGuiElement guiElement : foreground.GetLayerElements())
                {
                    IAndroidGuiElement element = (IAndroidGuiElement)guiElement;
                    p.setColor(element.GetColor().GetColor());
                    MaskFilter filter = p.getMaskFilter();
                    if(element.ShouldBlur()) {
                        BlurMaskFilter maskFilter = new BlurMaskFilter(3, BlurMaskFilter.Blur.SOLID);
                        p.setMaskFilter(maskFilter);
                    }
                    c.drawPath(element.GetPath(), p);
                    if(element.ShouldBlur()) {
                        p.setMaskFilter(filter);
                    }
                }
                */
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
                c.drawText("Sun Az: " + astronomyProvider.GetMoonPosition().getMoonAge(), x, y + 100, p);
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
