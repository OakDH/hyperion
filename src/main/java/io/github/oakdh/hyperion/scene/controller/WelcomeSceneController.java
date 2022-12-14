package io.github.oakdh.hyperion.scene.controller;

import io.github.oakdh.hyperion.App;
import io.github.oakdh.hyperion.SceneRegistry;
import javafx.fxml.FXML;

public class WelcomeSceneController {
    @FXML
    public void onExitPressed()
    {
        System.exit(0);
    }

   @FXML
    public void onDataPressed()
    {
        App.STAGE.setScene(SceneRegistry.DATA_SCENE);
        App.STAGE.show();
    } 
}
