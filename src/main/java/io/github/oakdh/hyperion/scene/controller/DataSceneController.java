package io.github.oakdh.hyperion.scene.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.LongSummaryStatistics;

import org.json.JSONArray;
import org.json.JSONObject;

import io.github.oakdh.hyperion.App;
import io.github.oakdh.hyperion.SceneRegistry;
import io.github.oakdh.hyperion.Util;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class DataSceneController {

    @FXML
    public NumberAxis   riskXAxis;

    @FXML
    public NumberAxis   riskYAxis;

    @FXML
    public LineChart    riskChart;

    @FXML
    public NumberAxis   tempXAxis;

    @FXML
    public NumberAxis   tempYAxis;

    @FXML
    public LineChart    tempChart;

    @FXML
    public NumberAxis   humXAxis;

    @FXML
    public NumberAxis   humYAxis;

    @FXML
    public LineChart    humChart;

    @FXML
    public NumberAxis   soilXAxis;

    @FXML
    public NumberAxis   soilYAxis;

    @FXML
    public LineChart    soilChart;

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

    public void populateChart(JSONObject ob)
    {
        System.out.println("Hello2");
        try
        {
            JSONArray arr = ob.getJSONArray("measurements");

            long times[] = new long[arr.length()];

            XYChart.Series riskSeries0 = new XYChart.Series<>();
            riskSeries0.setName("Box #0");

            XYChart.Series riskSeries1 = new XYChart.Series<>();
            riskSeries1.setName("Box #1");

            XYChart.Series tempSeries0 = new XYChart.Series<>();
            tempSeries0.setName("Box #0");

            XYChart.Series tempSeries1 = new XYChart.Series<>();
            tempSeries1.setName("Box #1");

            XYChart.Series humSeries0 = new XYChart.Series<>();
            humSeries0.setName("Box #0");

            XYChart.Series humSeries1 = new XYChart.Series<>();
            humSeries1.setName("Box #1");

            XYChart.Series soilSeries0 = new XYChart.Series<>();
            soilSeries0.setName("Box #0");

            XYChart.Series soilSeries1 = new XYChart.Series<>();
            soilSeries1.setName("Box #1");



            for (int i = 0; i < arr.length(); i++)
            {
                JSONObject element = arr.getJSONObject(i);

                float t = element.getFloat("temperature");
                float h = element.getFloat("humidity");
                float s = element.getFloat("soil_moisture");

                long time = element.getLong("time");
                times[i] = time;

                if (element.getInt("id") == 0)
                {
                    riskSeries0.getData().add(new XYChart.Data(time, Util.calculateRiskFactor(t, h, s)));
                    tempSeries0.getData().add(new XYChart.Data(time, t));
                    humSeries0.getData().add(new XYChart.Data(time, h));
                    soilSeries0.getData().add(new XYChart.Data(time, s));
                }
                else
                {
                    riskSeries1.getData().add(new XYChart.Data(time, Util.calculateRiskFactor(t, h, s)));
                    tempSeries1.getData().add(new XYChart.Data(time, t));
                    humSeries1.getData().add(new XYChart.Data(time, h));
                    soilSeries1.getData().add(new XYChart.Data(time, s));
                }

            }

            riskChart.getData().add(riskSeries0);
            riskChart.getData().add(riskSeries1);
            tempChart.getData().add(tempSeries0);
            tempChart.getData().add(tempSeries1);
            humChart.getData().add(humSeries0);
            humChart.getData().add(humSeries1);
            soilChart.getData().add(soilSeries0);
            soilChart.getData().add(soilSeries1);           

            LongSummaryStatistics ss = Arrays.stream(times).summaryStatistics();

            riskXAxis.setLowerBound(ss.getMin());
            riskXAxis.setUpperBound(ss.getMax());
            riskXAxis.setTickUnit((ss.getMax() - ss.getMin()) / 10);
            riskXAxis.setAutoRanging(false);

            tempXAxis.setLowerBound(ss.getMin());
            tempXAxis.setUpperBound(ss.getMax());
            tempXAxis.setTickUnit((ss.getMax() - ss.getMin()) / 10);
            tempXAxis.setAutoRanging(false);

            humXAxis.setLowerBound(ss.getMin());
            humXAxis.setUpperBound(ss.getMax());
            humXAxis.setTickUnit((ss.getMax() - ss.getMin()) / 10);
            humXAxis.setAutoRanging(false);

            soilXAxis.setLowerBound(ss.getMin());
            soilXAxis.setUpperBound(ss.getMax());
            soilXAxis.setTickUnit((ss.getMax() - ss.getMin()) / 10);
            soilXAxis.setAutoRanging(false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
        
    }

}