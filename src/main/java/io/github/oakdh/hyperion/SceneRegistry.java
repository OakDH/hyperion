package io.github.oakdh.hyperion;

import io.github.oakdh.hyperion.scene.BaseScene;
import javafx.scene.Scene;

public class SceneRegistry
{
    public static Scene DATA_SCENE = register(new BaseScene("data_scene"));
    public static Scene LOGIN_SCENE = register(new BaseScene("login_scene"));
    public static Scene USER_REVIEW_SCENE = register(new BaseScene("user_review_scene"));
    public static Scene MAINTENANCE_SCENE = register(new BaseScene("maintenance_scene"));
    //public static Scene DATA_TABLE_SCENE = register(new BaseScene("data_table_scene"));
    //public static Scene DATA_GRAPH_SCENE = register(new BaseScene("data_graph_scene"));


    public static Scene register(Scene toRegister)
    {
        return toRegister;
    }

    public static Scene WELCOME_SCENE = register(new BaseScene("welcome_scene"));

    public static void init() {}
}
