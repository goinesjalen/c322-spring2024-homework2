package com.example.c322spring2024homework2.model;

public class Guitar {
    public enum Builder {
        FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;
        public String toString() {
            switch (this) {
                case FENDER -> { return "Fender"; }
                case MARTIN -> { return "Martin"; }
                case GIBSON -> { return "Gibson"; }
                case COLLINGS -> { return "Collings"; }
                case OLSON -> { return "Olsen"; }
                case RYAN -> { return "Ryan"; }
                case PRS -> { return "PRS"; }
                default -> { return "Unspecified"; }
            }
        }
    }
    public enum Type {
        ELECTRIC, ACOUSTIC;
        public String toString() {
            switch (this) {
                case ACOUSTIC -> { return "Acoustic"; }
                case ELECTRIC -> { return "Electric"; }
                default -> { return "Unspecified"; }
            }
        }
    }
    public enum Wood {
        INDIAN_ROSEWOOD, BRAZILLIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;
        public String toString() {
            switch (this) {
                case INDIAN_ROSEWOOD -> { return "Indian Rosewood"; }
                case BRAZILLIAN_ROSEWOOD -> { return "Brazillian Rosewood"; }
                case MAHOGANY -> { return "Mahogany"; }
                case MAPLE -> { return "Maple"; }
                case COCOBOLO -> { return "Cocobolo"; }
                case CEDAR -> { return "Cedar"; }
                case ADIRONDACK -> { return "Adirondack"; }
                case ALDER -> { return "Alder"; }
                case SITKA -> { return "Sitka"; }
                default -> { return "Unspecified"; }
            }
        }
    }

    String serialNumber;
    double price;
    Builder builder;
    String model;
    Type type;
    Wood backWood;
    Wood topWood;
    public Guitar(String newSerialNumber, double newPrice, Builder newBuilder, String newModel, Type newType, Wood newBackWood, Wood newTopWood) {
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
        this.builder = Builder.valueOf(builder);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = Type.valueOf(type);
    }

    public void setBackWood(String backWood) {
        this.backWood = Wood.valueOf(backWood);
    }

    public void setTopWood(String topWood) {
        this.topWood = Wood.valueOf(topWood);
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(float newPrice){
        price = newPrice;
    }
    public String getBuilder(){
        return builder.toString();
    }
    public String getModel(){
        return model;
    }
    public String getType(){
        return type.toString();
    }
    public String getBackWood(){
        return backWood.toString();
    }
    public String getTopWood(){
        return topWood.toString();
    }

    @Override
    public String toString(){
        return String.format("%s, %.2f, %s, %s, %s, %s, %s", serialNumber, price, builder, model, type, backWood, topWood);
    }
}