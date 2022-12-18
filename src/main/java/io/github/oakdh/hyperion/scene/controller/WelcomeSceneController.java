package io.github.oakdh.hyperion.scene.controller;

import io.github.oakdh.hyperion.App;
import io.github.oakdh.hyperion.SceneRegistry;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.util.Duration;



public class WelcomeSceneController {
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
    public void onMaintenancePressed()
    {
        App.STAGE.setScene(SceneRegistry.MAINTENANCE_SCENE);
        App.STAGE.show();
    } 
    @FXML
    public void onDataTablePressed()
    {
        App.STAGE.setScene(SceneRegistry.DATA_TABLE_SCENE);
        App.STAGE.show();
    } 
    @FXML
    public void onDataGraphPressed()
    {
        App.STAGE.setScene(SceneRegistry.DATA_GRAPH_SCENE);
        App.STAGE.show();
    } 
    @FXML
    public void onHomeScreenPressed()
    {
        App.STAGE.setScene(SceneRegistry.WELCOME_SCENE);
        App.STAGE.show();
    } 

}
