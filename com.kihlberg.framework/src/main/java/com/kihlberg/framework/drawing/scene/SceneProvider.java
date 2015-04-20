package com.kihlberg.framework.drawing.scene;

import com.kihlberg.framework.drawing.background.IBackgroundProvider;
import com.kihlberg.framework.drawing.foreground.IForegroundProvider;
import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.TreeMap;

/**
 * Created by root on 3/16/15.
 */
public class SceneProvider implements ISceneProvider {
    private IForegroundProvider foregroundProvider;
    private IBackgroundProvider backgroundProvider;

    public SceneProvider(IForegroundProvider foregroundProvider, IBackgroundProvider backgroundProvider) {
        this.foregroundProvider = foregroundProvider;
        this.backgroundProvider = backgroundProvider;
    }

    @Override
    public TreeMap<Integer,IGuiElement> GetScene() {
        TreeMap<Integer,IGuiElement> elements = new TreeMap<Integer,IGuiElement>();
        elements.putAll(foregroundProvider.GetLayer());
        elements.putAll(backgroundProvider.GetLayer());
        return elements;
    }
}
