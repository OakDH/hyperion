package io.github.oakdh.hyperion;

import javafx.fxml.FXMLLoader;
import javafx.scene.chart.XYChart;

public class Util 
{
    public static FXMLLoader loadFXML(String fxml)
    {
        return new FXMLLoader(App.class.getResource("scenes/" + fxml + ".fxml"));
    }

    public static float calculateRiskFactor(float t, float h, float s)
    {
        return 1 - (-t + h + s * 100) / 100;
    }

    public static Float getXYSeriesValue(XYChart.Series<Long, Float> s, long idx)
    {
        for (XYChart.Data<Long, Float> element : s.getData())
        {
            if (element.getXValue() == idx)
                return element.getYValue();
        }

        return null; 
    }
}
