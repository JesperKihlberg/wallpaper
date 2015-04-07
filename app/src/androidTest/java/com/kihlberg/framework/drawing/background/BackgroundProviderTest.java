package com.kihlberg.framework.drawing.background;

import android.graphics.Color;
import android.graphics.Path;

import com.kihlberg.framework.drawing.color.IColorProvider;
import com.kihlberg.framework.drawing.common.GetterPath;
import com.kihlberg.framework.drawing.common.GetterPoint;
import com.kihlberg.framework.drawing.common.ICanvasSizeProvider;
import com.kihlberg.framework.drawing.common.IGuiElement;
import com.kihlberg.framework.drawing.layers.ISceneLayer;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

public class BackgroundProviderTest extends TestCase {

/*    public void testGetLayer() throws Exception {
        float height = 100;
        float width = 200;
        int color = Color.MAGENTA;
        MockCanvasSizeProvider canvasSizeProvider = new MockCanvasSizeProvider();
        canvasSizeProvider.SetValues(width, height);
        MockColorProvider colorProvider = new MockColorProvider();
        colorProvider.SetValues(color);

        BackgroundProvider backgroundProvider = new BackgroundProvider(canvasSizeProvider, colorProvider);

        ISceneLayer sceneLayer = backgroundProvider.GetLayer();

        List<IGuiElement> elements = sceneLayer.GetLayerElements();
        assertEquals(1, elements.size());
        assertEquals(color, elements.get(0).GetColor());
        Path p = elements.get(0).GetPath();
        List<GetterPoint> points = p.GetPoints();
        assertEquals(0f, points.get(0).getX());
        assertEquals(0f, points.get(0).getY());
        assertEquals(200f, points.get(1).getX());
        assertEquals(0f, points.get(1).getY());
        assertEquals(200f, points.get(2).getX());
        assertEquals(100f, points.get(2).getY());
        assertEquals(0f, points.get(3).getX());
        assertEquals(100f, points.get(3).getY());
    }
*/
    private class MockCanvasSizeProvider implements ICanvasSizeProvider {
        private float width;
        private float height;

        @Override
        public float GetWidth() {
            return width;
        }

        @Override
        public float GetHeight() {
            return height;
        }

        public void SetValues(float width, float height)
        {
            this.width=width;
            this.height=height;
        }
    }

    private class MockColorProvider implements IColorProvider {
        private int skyColor;

        @Override
        public int GetSkyColor() {
            return skyColor;
        }

        public void SetValues(int skyColor){
            this.skyColor=skyColor;
        }
    }
}