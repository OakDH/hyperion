package io.github.oakdh.hyperion;

import io.github.oakdh.hyperion.scene.BaseScene;
import javafx.scene.Scene;

public class SceneRegistry
{
    public static Scene LOGIN_SCENE = register(new BaseScene("login_scene"));

    public static Scene register(Scene toRegister)
    {
        return toRegister;
    }

    public static void init() {}
}
