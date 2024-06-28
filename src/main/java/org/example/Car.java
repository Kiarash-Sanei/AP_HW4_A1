package org.example;

import java.util.ArrayList;

public class Car extends Vehicle {
    private static ArrayList<Car> cars = new ArrayList<>();
    private int numberOfPassengers;
    private boolean isElectric;
    private Boolean isAutomatic;
    private String[] carParts = {"Engine", "Tires", "Brakes", "Transmission", "Suspension"};

    public Car() {
        super();
    }

    public Car(String name, int year, double price, Integer id, Person currentOwner, int numberOfPassengers,
               boolean isElectric, Boolean isAutomatic) {
        super(name, year, price, id, currentOwner);

        this.numberOfPassengers = numberOfPassengers;
        this.isElectric = isElectric;
        this.isAutomatic = isAutomatic;

        cars.add(this);
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public Boolean isAutomatic() {
        return isAutomatic;
    }

    public static void setCars(ArrayList<Car> cars) {
        Car.cars = cars;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public Boolean getAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(Boolean automatic) {
        isAutomatic = automatic;
    }

    public String[] getCarParts() {
        return carParts;
    }

    public void setCarParts(String[] carParts) {
        this.carParts = carParts;
    }
}
