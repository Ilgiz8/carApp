package com.example.carapp.controllers;

import com.example.carapp.models.Car;
import com.example.carapp.services.CarService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class CarEditController {

    @FXML
    private CheckBox checkNew;

    @FXML
    private Spinner<Double> spnMileage;

    @FXML
    private Spinner<Double> spnPrice;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtModal;

    public void initCar(Car car){
        txtBrand.setText(car.getBrand());
        txtModal.setText(car.getModel());
        spnMileage.getEditor().setText(String.valueOf(car.getMileage()));
        car.setNew(checkNew.isSelected());
        spnPrice.getEditor().setText(String.valueOf(car.getPrice()));

    }

    @FXML
    void onCancel(ActionEvent event) {
        checkNew.getScene().getWindow().hide();

    }
    @FXML
    void initialize() {
        spnPrice.setValueFactory( new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1000000, 0));
        spnPrice.setEditable(true);

        spnMileage.setValueFactory( new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1000000, 0));
        spnMileage.setEditable(true);
    }

    @FXML
    void onSave(ActionEvent event) {
        Car car = new Car();
        car.setBrand(txtBrand.getText());
        car.setModel(txtModal.getText());
        car.setPrice(spnPrice.getEditor().getText());
        car.setNew(checkNew.isScaleShape());
        car.setMileage(spnMileage.getEditor().getText());

        CarService carService = CarService.getINSTANCE();
        carService.add(car);
        //carService.showCars();

        onCancel(null);

    }
}


