package io.github.oakdh.hyperion;

import org.json.JSONObject;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{
    public static Stage STAGE;

    private static Thread updateThread;

    @Override
    public void start(Stage stage)
    {
        // Stage initialization
        App.STAGE = stage;
        stage.setTitle(Reference.PROGRAM_NAME);
        
        SceneRegistry.init();

        // Initialize threads
        // Update tables from the server. This is a really bad way of doing things.
        updateThread = new Thread(() -> {

            while (true)
            {
                try
                {
                Thread.sleep(5000);
                }
                catch (InterruptedException e)
                { break; }

                JSONObject ob = HTTPHandler.sendMessage("get_measurements");

                if (ob.getInt("status") != 0) continue;

                SceneRegistry.DATA_TABLE_SCENE_CONTROLLER.table.getItems().clear();

                SceneRegistry.DATA_TABLE_SCENE_CONTROLLER.populateTable(ob);

                SceneRegistry.DATA_TABLE_SCENE_CONTROLLER.table.sort();
            }
        });
        
        updateThread.start();
     

        stage.setScene(SceneRegistry.LOGIN_SCENE);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        updateThread.interrupt();
    }

    public static void main(String[] args)
    {
        //HTTPHandler.init();

        launch(args);

        //HTTPHandler.cleanup();
    }

}