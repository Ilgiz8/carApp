package com.example.carapp.services;

import com.example.carapp.db.DbHelper;
import com.example.carapp.models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private List<Car> cars = new ArrayList<>();

    public CarService(){
        Car car = new Car();
        car.setBrand("Brand");
        car.setModel("Model");
        car.setPrice(3000.9);
        car.setMileage(10000.4);
        car.setNew(true);
        cars.add(car);

        car = new Car();
        car.setBrand("Brand");
        car.setModel("Model");
        car.setPrice(3000.9);
        car.setMileage(10000.4);
        car.setNew(false);
        cars.add(car);
    }

    private static CarService INSTANCE;
    public static CarService getINSTANCE(){
        if(INSTANCE == null)
            INSTANCE = new CarService();
        return INSTANCE;
    }
    public void add(Car car){
        DbHelper dbHelper = DbHelper.getInstance();
        dbHelper.connect();

        cars.add(car);
    }
    public void showCars(){
        System.out.println(cars.toString());
    }

    public List<Car> getCars() {
        return cars;
    }
    public void deleteCar(Car car){
        cars.remove(car.getNum() - 1);
    }
}
