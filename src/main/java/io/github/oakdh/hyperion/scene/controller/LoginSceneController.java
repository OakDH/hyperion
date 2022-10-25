package io.github.oakdh.hyperion.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    public void onExitPressed()
    {
        System.exit(0);
    }

    @FXML
    public void onLoginPressed()
    {
        System.out.println("Placeholder.");
    }
}
