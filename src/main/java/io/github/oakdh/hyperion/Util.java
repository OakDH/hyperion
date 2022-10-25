package io.github.oakdh.hyperion;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Util 
{
    public static Parent loadFXML(String fxml)
    {
        try
        {
            return FXMLLoader.load(App.class.getResource("scenes/" + fxml + ".fxml"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }
}
