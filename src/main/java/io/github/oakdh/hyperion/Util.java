package io.github.oakdh.hyperion;

import javafx.fxml.FXMLLoader;

public class Util 
{
    public static FXMLLoader loadFXML(String fxml)
    {
        return new FXMLLoader(App.class.getResource("scenes/" + fxml + ".fxml"));
    }
}
