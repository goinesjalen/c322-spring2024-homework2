package com.example.c322spring2024homework2.model;

public class Guitar {

    String serialNumber;
    double price;
    String builder;
    String model;
    String type;
    String backWood;
    String topWood;
    public Guitar(String newSerialNumber, double newPrice, String newBuilder, String newModel, String newType, String newBackWood, String newTopWood) {
        serialNumber = newSerialNumber;
        price = newPrice;
        builder = newBuilder;
        model = newModel;
        type = newType;
        backWood = newBackWood;
        topWood = newTopWood;
    }
    public Guitar(){
    }

    public String getSerialNumber(){
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }

    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(float newPrice){
        price = newPrice;
    }
    public String getBuilder(){
        return builder;
    }
    public String getModel(){
        return model;
    }
    public String getType(){
        return type;
    }
    public String getBackWood(){
        return backWood;
    }
    public String getTopWood(){
        return topWood;
    }

    @Override
    public String toString(){
        return String.format("%s, %.2f, %s, %s, %s, %s, %s", serialNumber, price, builder, model, type, backWood, topWood);
    }
}