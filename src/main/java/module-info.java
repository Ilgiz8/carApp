module com.example.carapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.carapp to javafx.fxml;
    exports com.example.carapp;
    exports com.example.carapp.controllers;
    opens com.example.carapp.controllers to javafx.fxml;
    exports com.example.carapp.models;
    opens com.example.carapp.models to javafx.fxml;
}