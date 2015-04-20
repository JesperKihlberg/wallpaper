package com.kihlberg.framework.drawing.foreground;

/**
 * Created by root on 4/20/15.
 */
public class TreeSettingsProvider implements ITreeSettingsProvider {
    @Override
    public TreeSettings GetTreeSettings(){
        return new TreeSettings();
    }
}
