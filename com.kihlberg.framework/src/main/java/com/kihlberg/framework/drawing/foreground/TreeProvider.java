package com.kihlberg.framework.drawing.foreground;

import com.kihlberg.framework.interfaces.BaseColorSetting;
import com.kihlberg.framework.interfaces.GuiElementType;
import com.kihlberg.framework.interfaces.IColorProvider;
import com.kihlberg.framework.interfaces.IGuiElement;
import com.kihlberg.framework.interfaces.IGuiElementProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by root on 4/19/15.
 */
public class TreeProvider extends CanvasDependant implements ITreeProvider {
    private IColorProvider colorProvider;
    private IGuiElementProvider guiElementProvider;
    private ITreeSettingsProvider treeSettingsProvider;

    public TreeProvider(IColorProvider colorProvider, IGuiElementProvider guiElementProvider, ITreeSettingsProvider treeSettingsProvider) {
        this.colorProvider = colorProvider;
        this.guiElementProvider = guiElementProvider;
        this.treeSettingsProvider=treeSettingsProvider;
    }

    @Override
    public TreeMap<Integer,IGuiElement> GetTree(float minx, float miny, float scale){
        TreeSettings settings = treeSettingsProvider.GetTreeSettings();
        TreeMap<Integer,IGuiElement> elements = new TreeMap<Integer,IGuiElement>();
        float width= canvasWidth*settings.GetWidthPercentage()*scale;
        float height = width*settings.GetWidthHeightCorrelation();
        elements.put((int) ((miny+height)*100), guiElementProvider.CreateTriangle(
                minx, miny + height * settings.GetCrownHeightPercentage(),
                minx + width / 2, miny,
                minx + width, miny + height * settings.GetCrownHeightPercentage(),
                new BaseColorSetting(GuiElementType.TreeCrown, colorProvider.GetTreeCrownColor())
        ));
        elements.put((int) ((miny + height)*100+1), guiElementProvider.CreateTriangle(
                minx + width / 2 - settings.GetTrunkWidthPercentage() * width, miny + height,
                minx + width / 2, miny + height - settings.GetTrunkHeightPercentage() * height,
                minx + width / 2 + settings.GetTrunkWidthPercentage() * width, miny + height,
                new BaseColorSetting(GuiElementType.TreeTrunk, colorProvider.GetTreeTrunkColor())
        ));
        return elements;
    }
}
