package io.github.oakdh.hyperion;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{
    private static Stage STAGE;

    @Override
    public void start(Stage stage)
    {
        // Stage initialization
        App.STAGE = stage;
        stage.setTitle(Reference.PROGRAM_NAME);
        
        SceneRegistry.init();

        stage.setScene(SceneRegistry.WELCOME_SCENE);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}