package io.github.oakdh.hyperion.scene.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import io.github.oakdh.hyperion.App;
import io.github.oakdh.hyperion.HTTPHandler;
import io.github.oakdh.hyperion.SceneRegistry;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataTableSceneController implements Initializable {

    public ObservableList<Measurement> data;

    @FXML
    public TableView<Measurement> table;

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        TableColumn<Measurement, Integer> col1 = new TableColumn<>("ID");
        col1.setMinWidth(100);
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Measurement, Float> col2 = new TableColumn<Measurement, Float>("Temperature");
        col2.setMinWidth(100);
        col2.setCellValueFactory(new PropertyValueFactory<Measurement, Float>("temperature"));

        TableColumn<Measurement, Float> col3 = new TableColumn<Measurement, Float>("Humidity");
        col3.setMinWidth(100);
        col3.setCellValueFactory(new PropertyValueFactory<Measurement, Float>("humidity"));

        TableColumn<Measurement, Float> col4 = new TableColumn<Measurement, Float>("Soil Moisture");
        col4.setMinWidth(100);
        col4.setCellValueFactory(new PropertyValueFactory<Measurement, Float>("soilMoisture"));

        TableColumn<Measurement, Long> col5 = new TableColumn<Measurement, Long>("Time");
        col5.setMinWidth(100);
        col5.setCellValueFactory(new PropertyValueFactory<Measurement, Long>("time"));

        TableColumn<Measurement, Float> col6 = new TableColumn<Measurement, Float>("Risk Factor");
        col6.setMinWidth(100);
        col6.setCellValueFactory(new PropertyValueFactory<Measurement, Float>("riskFactor"));
        
        try
        {
            JSONObject ob = HTTPHandler.sendMessage("get_measurements");

            JSONArray arr = ob.getJSONArray("measurements");

            for (int i = 0; i < arr.length(); i++)
            {
                JSONObject element = arr.getJSONObject(i);

                float t = element.getFloat("temperature");
                float h = element.getFloat("humidity");
                float s = element.getFloat("soil_moisture");

                float risk = 1 - (-t + h + s * 100) / 100;

                table.getItems().add(new Measurement(
                    element.getInt("id"), 
                    t, 
                    h, 
                    s,
                    element.getLong("time"),
                    risk));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // table.getItems().add(new Measurement(1, 2, 3, 4, 5));
        table.getColumns().addAll(col1, col2, col3, col4, col5, col6);
    } 

    public static class Measurement
    {
        private final SimpleIntegerProperty id;
        private final SimpleFloatProperty temperature;
        private final SimpleFloatProperty humidity;
        private final SimpleFloatProperty soilMoisture;
        private final SimpleLongProperty time;
        private final SimpleFloatProperty riskFactor;

        public Measurement(int id, float temperature, float humidity, float soil_moisture, long time, float riskFactor)
        {
            this.id = new SimpleIntegerProperty(id);
            this.temperature = new SimpleFloatProperty(temperature);
            this.humidity = new SimpleFloatProperty(humidity);
            this.soilMoisture = new SimpleFloatProperty(soil_moisture);
            this.time = new SimpleLongProperty(time);
            this.riskFactor = new SimpleFloatProperty(riskFactor);
        }

        public int getId()
        {
            return id.get();
        }

        public float getTemperature()
        {
            return temperature.get();
        }

        public float getHumidity()
        {
            return humidity.get();
        }

        public float getSoilMoisture()
        {
            return soilMoisture.get();
        }

        public long getTime()
        {
            return time.get();
        }

        public float getRiskFactor()
        {
            return riskFactor.get();
        }

        public void setId(int id)
        {
            this.id.set(id);
        }

        public void setTemperature (float temperature)
        {
            this.temperature.set(temperature);
        }

        public void setHumidity (float humidity)
        {
            this.humidity.set(humidity);
        }
        
        public void setSoilMoisture (float soilMoisture)
        {
            this.soilMoisture.set(soilMoisture);
        }

        public void setTime(long time)
        {
            this.time.set(time);
        }

        public void setRiskFactor(float riskFactor)
        {
            this.riskFactor.set(riskFactor);
        }
    }
}
