package com.kihlberg.framework.drawing.common;

import android.graphics.Path;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/22/15.
 */

public class GetterPath extends Path {
    ArrayList<GetterPoint> points;

    public List<GetterPoint> GetPoints(){
        return points;
    }

    @Override
    public void addRect(float left, float top, float right, float bottom, Direction dir) {
        points.add(new GetterPoint(left,top));
        if (dir == Direction.CW){
            points.add(new GetterPoint(right,top));
            points.add(new GetterPoint(right,bottom));
            points.add(new GetterPoint(left,bottom));
        }
        else {
            points.add(new GetterPoint(left,bottom));
            points.add(new GetterPoint(right,bottom));
            points.add(new GetterPoint(right,top));
        }

        super.addRect(left, top, right, bottom, dir);
    }

    @Override
    public void addCircle(float x, float y, float radius, Direction dir) {
        points.add(new GetterPoint(x,y));
        points.add(new GetterPoint(x,y + radius));
        super.addCircle(x, y, radius, dir);
    }

    public GetterPath() {
        this.points = new ArrayList<GetterPoint>();
    }

    public GetterPath(Path src) {
        super(src);
        this.points = new ArrayList<GetterPoint>();
    }
 }
