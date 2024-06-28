package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Vehicle {
    private static HashMap<Integer, Vehicle> vehicleHashMap = new HashMap<>();

    private Integer id;
    private ArrayList<Person> allOwners = new ArrayList<>();
    private String name;
    private int year;
    private double price;
    private Person currentOwner;

    public Vehicle() {
    }

    public Vehicle(String name, int year, double price, Integer id, Person currentOwner) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.id = id;
        this.currentOwner = currentOwner;

        vehicleHashMap.put(id, this);
    }

    public static HashMap<Integer, Vehicle> getVehicleHashMap() {
        return vehicleHashMap;
    }

    public static void setVehicleHashMap(HashMap<Integer, Vehicle> vehicleHashMap) {
        Vehicle.vehicleHashMap = vehicleHashMap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Person> getAllOwners() {
        return allOwners;
    }

    public void setAllOwners(ArrayList<Person> allOwners) {
        this.allOwners = allOwners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(Person currentOwner) {
        this.currentOwner = currentOwner;
    }
}
