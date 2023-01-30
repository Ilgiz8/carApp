package com.example.carapp.controllers;

import com.example.carapp.HelloApplication;
import com.example.carapp.models.Car;
import com.example.carapp.services.CarService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Maincontroller {
        private CarService carService = CarService.getINSTANCE();

    @FXML
    private TableColumn<?, ?> colmBrand;

    @FXML
    private TableColumn<?, ?> colmMileage;

    @FXML
    private TableColumn<?, ?> colmModel;

    @FXML
    private TableColumn<Car, Boolean> colmNew;

    @FXML
    private TableColumn<?, ?> colmNum;

    @FXML
    private TableColumn<?, ?> colmPrice;

    @FXML
    private TableView<Car> tbCars;

    @FXML
    void initialize() {
        initColums();
        refreshTable();
    }
    private void initColums(){
        colmBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colmModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colmPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colmMileage.setCellValueFactory(new PropertyValueFactory<>("mileage"));
        colmNum.setCellValueFactory(new PropertyValueFactory<>("num"));

        colmNew.setCellFactory(column -> new CheckBoxTableCell<> ());
        colmNew.setCellValueFactory(cellData->{
            Car cellValue = cellData.getValue();
            BooleanProperty property =new SimpleBooleanProperty(cellValue.getNew());
            property.addListener ((observable, oldValue, newValue) -> cellValue.setNew(newValue));
            return property;
        });

    }


    @FXML
        void onCreate(ActionEvent event) {

            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("car-edit-view.fxml"));

            {
                try {
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setResizable(false);
                    stage.showAndWait();

                   
                    refreshTable();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    @FXML
    void onDelete(ActionEvent event) {
        Car selectedCar = tbCars.getSelectionModel().getSelectedItem();
        carService.deleteCar(selectedCar);
        refreshTable();

    }

    @FXML
    void onUpdate(ActionEvent event) {
        Car selectedCar = tbCars.getSelectionModel().getSelectedItem();
        if (selectedCar == null)
            return;
        Stage stage=new Stage();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("car-edit-view.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            CarEditController carEditController = loader.getController();
            carEditController.initCar(selectedCar);

            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            refreshTable();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void refreshTable() {
        List<Car> cars = carService.getCars();
        for(int i= 0; i <cars.size(); i++){
            Car car =cars.get(i);
            car.setNum(i+1);

        }
        tbCars.setItems(FXCollections.observableList(cars));
    }

}
