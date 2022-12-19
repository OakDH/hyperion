package io.github.oakdh.hyperion.scene.controller;

import org.json.JSONObject;

import io.github.oakdh.hyperion.App;
import io.github.oakdh.hyperion.HTTPHandler;
import io.github.oakdh.hyperion.SceneRegistry;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginSceneController
{
    @FXML
    public TextField usernameTextField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public Button exitButton;

    @FXML
    public Button loginButton;

    @FXML
    public Label wrongLogin;

    @FXML
    public void onExitPressed()
    {
        System.exit(0);
    }

    @FXML
    public void onLoginPressed()
    {
        JSONObject client_login = HTTPHandler.sendMessage(String.format("client_login/%s/%s", usernameTextField.getText(), passwordField.getText()));

        if (client_login.getInt("status") != 0) 
        {
            wrongLogin.setText("Wrong username!");
            return;
        }

        if(client_login.getBoolean("login_success")){
            App.STAGE.setScene(SceneRegistry.WELCOME_SCENE);
            App.STAGE.show();
        } else{
            wrongLogin.setText("Wrong password!");
        }
    }
}
