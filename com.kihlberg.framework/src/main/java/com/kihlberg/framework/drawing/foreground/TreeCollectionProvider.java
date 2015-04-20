package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.IGuiElement;

import java.util.TreeMap;

/**
 * Created by root on 4/20/15.
 */
public class TreeCollectionProvider {
    private ITreeProvider treeProvider;

    public TreeCollectionProvider(ITreeProvider treeProvider) {
        this.treeProvider = treeProvider;
    }

    public TreeMap<Integer, IGuiElement> GetTreeCollection(float minY, float maxY, float minX, float maxX, int treeCount){
        TreeMap<Integer, IGuiElement> elements = new TreeMap<Integer,IGuiElement>();

//        elements.putAll();
        return elements;
    }
}
