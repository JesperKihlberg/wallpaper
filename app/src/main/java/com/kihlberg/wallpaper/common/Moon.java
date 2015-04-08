package com.kihlberg.wallpaper.common;

import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by root on 4/3/15.
 */
public class Moon extends GuiElement implements IMoon {
    private float x;
    private float y;
    private float radius1;
    private float radius2;

    public Moon(float x, float y, float radius1, float radius2, int color) {
        super(color);
        this.x = x;
        this.y = y;
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    @Override
    public Path GetPath() {
        Path p = new Path();
        RectF rect = new RectF();
        float numeric1 =Math.signum(radius1)*radius1;
        float numeric2 =Math.signum(radius2)* radius2;
        float mainRadius = Math.max(numeric1, numeric2);
        float shortRadius = Math.min(numeric1, numeric2);

        rect.set(x-mainRadius, y-mainRadius, x+mainRadius, y+mainRadius);
        p.reset();
        p.moveTo(x, y - mainRadius);
        if(-radius1== radius2)
            p.addCircle(x, y, mainRadius, Path.Direction.CW);
        else {
            if ((numeric1 == mainRadius && radius1< 0) || (numeric2 == mainRadius && radius2 < 0))
                p.arcTo(rect, -270, 180);
            else
                p.arcTo(rect, 270, 180);
            rect.set(x - shortRadius, y - mainRadius, x + shortRadius, y + mainRadius);
            if (((numeric2 == shortRadius && radius2 < 0) || numeric1 == shortRadius && radius1 < 0))
                p.arcTo(rect, -90, -180);
            else
                p.arcTo(rect, 90, -180);
        }
        return p;
    }

}
