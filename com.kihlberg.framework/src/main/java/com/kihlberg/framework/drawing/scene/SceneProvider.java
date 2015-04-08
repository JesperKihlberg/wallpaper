package com.kihlberg.framework.drawing.scene;

import com.kihlberg.framework.drawing.background.IBackgroundProvider;
import com.kihlberg.framework.drawing.foreground.IForegroundProvider;

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
    public Scene GetScene() {
        return new Scene(foregroundProvider.GetLayer(), backgroundProvider.GetLayer());
    }
}
