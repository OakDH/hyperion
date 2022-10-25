package io.github.oakdh.hyperion.scene;

import io.github.oakdh.hyperion.Util;
import javafx.scene.Scene;

public class BaseScene extends Scene
{
    public final String sceneName;

    public BaseScene(String sceneName)
    {
        super(Util.loadFXML(sceneName));

        this.sceneName = sceneName;
    }

}
