package com.example.carapp.models;

public class Car {
    private int num;
    private String brand;
    private String model;
    private double price;
    private boolean isNew;
    private double mileage;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand.isBlank())
            throw new RuntimeException("Бренд не должен быть пустым!");
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model.isBlank())
            throw  new RuntimeException("Модэль не дожна быть пустой !");
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        double carPrice;

        try {
             carPrice = Double.parseDouble(price);
        }catch (Exception exception) {
            throw new RuntimeException("Некоректное число!");
        }
        setPrice(carPrice);
    }
    public void setNum(int num){
        this.num = num;
    }
    public int getNum(){
        return num;
    }
    public void setPrice(double price){
        if (price < 0) {
            throw new RuntimeException("Цена не может быть меньше нуля !");
        }
        this.price = price;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
    public  boolean getNew(){
        return isNew;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {

        double carMilaege;

        try {
            carMilaege = Double.parseDouble(mileage);
        }catch (Exception exception) {
            throw new RuntimeException("Некоректное число!");
        }
        setMileage(carMilaege);

    }
    public void setMileage(double mileage){
        if (mileage < 0) {
            throw new RuntimeException("Цена не может быть меньше нуля !");
        }
        this.mileage = mileage;
    }

}
