package com.kihlberg.framework.drawing.scene;

import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.TreeMap;

/**
 * Created by root on 3/16/15.
 */
public interface ISceneProvider {
    public TreeMap<Integer,IGuiElement> GetScene();
}
