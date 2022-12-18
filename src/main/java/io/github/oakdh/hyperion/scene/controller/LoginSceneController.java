package io.github.oakdh.hyperion.scene.controller;

import io.github.oakdh.hyperion.App;
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
        System.out.println("Placeholder.");
        checkLogin();
    }

    private void checkLogin(){
        if(usernameTextField.getText().toString().equals("admin") && passwordField.getText().toString().equals("12345")){
            App.STAGE.setScene(SceneRegistry.WELCOME_SCENE);
            App.STAGE.show();
        } else{
            wrongLogin.setText("Wrong username or password!");
        }
    }
}
