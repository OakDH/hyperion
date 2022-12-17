package io.github.oakdh.hyperion.scene.controller;

import io.github.oakdh.hyperion.App;
import io.github.oakdh.hyperion.SceneRegistry;
import javafx.fxml.FXML;

public class MaintenanceSceneController {
    @FXML
    public void onExitPressed()
    {
        System.exit(0);
    }
    //menubar functions
   @FXML
    public void onDataPressed()
    {
        App.STAGE.setScene(SceneRegistry.DATA_SCENE);
        App.STAGE.show();
    }
    @FXML
    public void onUserReviewPressed()
    {
        App.STAGE.setScene(SceneRegistry.USER_REVIEW_SCENE);
        App.STAGE.show();
    } 
    @FXML
    public void onHomeScreenPressed()
    {
        App.STAGE.setScene(SceneRegistry.WELCOME_SCENE);
        App.STAGE.show();
    } 
    

}
