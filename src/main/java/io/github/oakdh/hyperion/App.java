package io.github.oakdh.hyperion;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{
    public static Stage STAGE;

    @Override
    public void start(Stage stage)
    {
        // Stage initialization
        App.STAGE = stage;
        stage.setTitle(Reference.PROGRAM_NAME);
        
        SceneRegistry.init();

        // Initialize threads
     

        stage.setScene(SceneRegistry.LOGIN_SCENE);
        stage.show();
    }

    public static void main(String[] args)
    {
        //HTTPHandler.init();

        launch(args);

        //HTTPHandler.cleanup();
    }

}