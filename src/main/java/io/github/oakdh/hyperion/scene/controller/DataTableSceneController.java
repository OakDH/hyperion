package io.github.oakdh.hyperion.scene.controller;

import java.net.URL;
import java.util.ResourceBundle;

import io.github.oakdh.hyperion.App;
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
        
        TableColumn<Measurement, String> col1 = new TableColumn<Measurement, String>("ID");
        col1.setMinWidth(100);
        col1.setCellValueFactory(new PropertyValueFactory<Measurement, String>("id"));

        TableColumn<Measurement, String> col2 = new TableColumn<Measurement, String>("Temperature");
        col2.setMinWidth(100);
        col2.setCellValueFactory(new PropertyValueFactory<Measurement, String>("temperature"));

        TableColumn<Measurement, String> col3 = new TableColumn<Measurement, String>("Humidity");
        col3.setMinWidth(100);
        col3.setCellValueFactory(new PropertyValueFactory<Measurement, String>("humidity"));

        TableColumn<Measurement, String> col4 = new TableColumn<Measurement, String>("Soil Moisture");
        col4.setMinWidth(100);
        col4.setCellValueFactory(new PropertyValueFactory<Measurement, String>("soilMoisture"));

        TableColumn<Measurement, String> col5 = new TableColumn<Measurement, String>("Time");
        col5.setMinWidth(100);
        col5.setCellValueFactory(new PropertyValueFactory<Measurement, String>("time"));


        // data = FXCollections.observableArrayList(new Measurement(1, 2, 3, 4, 5));

        // table.setItems(data);

        table.getItems().add(new Measurement(1, 2, 3, 4, 5));
        table.getColumns().addAll(col1, col2, col3, col4, col5);

        
        
    } 

    public static class Measurement
    {
        private final SimpleIntegerProperty id;
        private final SimpleFloatProperty temperature;
        private final SimpleFloatProperty humidity;
        private final SimpleFloatProperty soilMoisture;
        private final SimpleLongProperty time;

        public Measurement(int id, float temperature, float humidity, float soil_moisture, long time)
        {
            this.id = new SimpleIntegerProperty(id);
            this.temperature = new SimpleFloatProperty(temperature);
            this.humidity = new SimpleFloatProperty(humidity);
            this.soilMoisture = new SimpleFloatProperty(soil_moisture);
            this.time = new SimpleLongProperty(time);
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

    }
}
