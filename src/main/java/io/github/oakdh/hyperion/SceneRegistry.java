package io.github.oakdh.hyperion;

import io.github.oakdh.hyperion.scene.controller.DataSceneController;
import io.github.oakdh.hyperion.scene.controller.DataTableSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class SceneRegistry
{
    public static Scene DATA_SCENE;
    public static Scene LOGIN_SCENE = register("login_scene");
    public static Scene USER_REVIEW_SCENE = register("user_review_scene");
    public static Scene MAINTENANCE_SCENE = register("maintenance_scene");
    public static Scene DATA_TABLE_SCENE;
    public static Scene DATA_GRAPH_SCENE = register("data_graph_scene");
    public static Scene WELCOME_SCENE = register("welcome_scene");

    public static DataSceneController DATA_SCENE_CONTROLLER;
    public static DataTableSceneController DATA_TABLE_SCENE_CONTROLLER;

    private static Scene register(String sceneName)
    {
        try
        {
            return new Scene(Util.loadFXML(sceneName).load());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }
    }

    public static void init() 
    {
        FXMLLoader loader;

        try
        {

            loader = Util.loadFXML("data_scene");
            DATA_SCENE = new Scene(loader.load());
            DATA_SCENE_CONTROLLER = loader.getController();

            loader = Util.loadFXML("data_table_scene");
            DATA_TABLE_SCENE = new Scene(loader.load());
            DATA_TABLE_SCENE_CONTROLLER = loader.getController();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
