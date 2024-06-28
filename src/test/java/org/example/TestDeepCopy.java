package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

public class TestDeepCopy {
    private Person person;
    private Vehicle vehicle;
    private Car car;

    private Person personCopy;
    private Vehicle vehicleCopy;
    private Car carCopy;

    @Before
    public void setUp() {
        person = new Person(1, "John", 25);
        vehicle = new Vehicle("Toyota", 2010, 10000.0, 1, person);
        car = new Car("Toyota", 2010, 10000.0, 1, person, 5, false, true);

        DeepCopy deepCopy = new DeepCopy();
        personCopy = (Person) deepCopy.clone(person);
        vehicleCopy = (Vehicle) deepCopy.clone(vehicle);
        carCopy = (Car) deepCopy.clone(car);
    }

    @Test
    public void testPersonId() {
        assert person.getId() == personCopy.getId();

        person.setId(2);
        assert person.getId() == 2;
        assert personCopy.getId() == 1;
    }

    @Test
    public void testPersonName() {
        assert Objects.equals(person.getName(), personCopy.getName());

        person.setName("Jane");
        assert person.getName().equals("Jane");
        assert personCopy.getName().equals("John");
    }

    @Test
    public void testPersonAge() {
        assert Objects.equals(person.getAge(), personCopy.getAge());

        person.setAge(30);
        assert person.getAge() == 30;
        assert personCopy.getAge() == 25;
    }

    @Test
    public void testVehicleId() {
        assert Objects.equals(vehicle.getId(), vehicleCopy.getId());

        vehicle.setId(2);
        assert vehicle.getId() == 2;
        assert vehicleCopy.getId() == 1;
    }

    @Test
    public void testVehicleAllOwners() {
        assert vehicle.getAllOwners().size() == vehicleCopy.getAllOwners().size();

        Person newOwner = new Person(2, "Jane", 30);
        vehicle.getAllOwners().add(newOwner);
        assert vehicle.getAllOwners().size() == 1;
        assert vehicleCopy.getAllOwners().isEmpty();
    }

    @Test
    public void testVehicleName() {
        assert Objects.equals(vehicle.getName(), vehicleCopy.getName());

        vehicle.setName("Honda");
        assert vehicle.getName().equals("Honda");
        assert vehicleCopy.getName().equals("Toyota");
    }

    @Test
    public void testVehicleYear() {
        assert vehicle.getYear() == vehicleCopy.getYear();

        vehicle.setYear(2015);
        assert vehicle.getYear() == 2015;
        assert vehicleCopy.getYear() == 2010;
    }

    @Test
    public void testVehiclePrice() {
        assert vehicle.getPrice() == vehicleCopy.getPrice();

        vehicle.setPrice(15000.0);
        assert vehicle.getPrice() == 15000.0;
        assert vehicleCopy.getPrice() == 10000.0;
    }

    @Test
    public void testVehicleCurrentOwnerId() {
        assert vehicle.getCurrentOwner().getId() == vehicleCopy.getCurrentOwner().getId();

        Person newOwner = new Person(2, "Jane", 30);
        vehicle.setCurrentOwner(newOwner);
        assert vehicle.getCurrentOwner().getId() == 2;
        assert vehicleCopy.getCurrentOwner().getId() == 1;
    }

    @Test
    public void testVehicleCurrentOwnerName() {
        assert Objects.equals(vehicle.getCurrentOwner().getName(), vehicleCopy.getCurrentOwner().getName());

        Person newOwner = new Person(2, "Jane", 30);
        vehicle.setCurrentOwner(newOwner);
        assert vehicle.getCurrentOwner().getName().equals("Jane");
        assert vehicleCopy.getCurrentOwner().getName().equals("John");
    }

    @Test
    public void testVehicleCurrentOwnerAge() {
        assert Objects.equals(vehicle.getCurrentOwner().getAge(), vehicleCopy.getCurrentOwner().getAge());

        Person newOwner = new Person(2, "Jane", 30);
        vehicle.setCurrentOwner(newOwner);
        assert vehicle.getCurrentOwner().getAge() == 30;
        assert vehicleCopy.getCurrentOwner().getAge() == 25;
    }

    @Test
    public void testCarNumberOfPassengers() {
        assert car.getNumberOfPassengers() == carCopy.getNumberOfPassengers();

        car.setNumberOfPassengers(7);
        assert car.getNumberOfPassengers() == 7;
        assert carCopy.getNumberOfPassengers() == 5;
    }

    @Test
    public void testCarIsElectric() {
        assert car.isElectric() == carCopy.isElectric();

        car.setElectric(true);
        assert car.isElectric();
        assert !carCopy.isElectric();
    }

    @Test
    public void testCarIsAutomatic() {
        assert Objects.equals(car.isAutomatic(), carCopy.isAutomatic());

        car.setAutomatic(false);
        assert !car.isAutomatic();
        assert carCopy.isAutomatic();
    }

    @Test
    public void testCarCarParts() {
        assert car.getCarParts().length == carCopy.getCarParts().length;

        String[] newCarParts = {"Engine", "Tires", "Brakes"};
        car.setCarParts(newCarParts);
        assert car.getCarParts().length == 3;
        assert carCopy.getCarParts().length == 5;
    }

    @Test
    public void testCarVehicleId() {
        assert Objects.equals(car.getId(), carCopy.getId());

        car.setId(2);
        assert car.getId() == 2;
        assert carCopy.getId() == 1;
    }

    @Test
    public void testCarVehicleAllOwners() {
        assert car.getAllOwners().size() == carCopy.getAllOwners().size();

        Person newOwner = new Person(2, "Jane", 30);
        car.getAllOwners().add(newOwner);
        assert car.getAllOwners().size() == 1;
        assert carCopy.getAllOwners().isEmpty();
    }

    @Test
    public void testCarVehicleName() {
        assert Objects.equals(car.getName(), carCopy.getName());

        car.setName("Honda");
        assert car.getName().equals("Honda");
        assert carCopy.getName().equals("Toyota");
    }

    @Test
    public void testCarVehicleYear() {
        assert car.getYear() == carCopy.getYear();

        car.setYear(2015);
        assert car.getYear() == 2015;
        assert carCopy.getYear() == 2010;
    }

@Test
    public void testCarVehiclePrice() {
        assert car.getPrice() == carCopy.getPrice();

        car.setPrice(15000.0);
        assert car.getPrice() == 15000.0;
        assert carCopy.getPrice() == 10000.0;
    }

    @Test
    public void testCarVehicleCurrentOwnerId() {
        assert car.getCurrentOwner().getId() == carCopy.getCurrentOwner().getId();

        Person newOwner = new Person(2, "Jane", 30);
        car.setCurrentOwner(newOwner);
        assert car.getCurrentOwner().getId() == 2;
        assert carCopy.getCurrentOwner().getId() == 1;
    }

    @Test
    public void testCarVehicleCurrentOwnerName() {
        assert Objects.equals(car.getCurrentOwner().getName(), carCopy.getCurrentOwner().getName());

        Person newOwner = new Person(2, "Jane", 30);
        car.setCurrentOwner(newOwner);
        assert car.getCurrentOwner().getName().equals("Jane");
        assert carCopy.getCurrentOwner().getName().equals("John");
    }

    @Test
    public void testCarVehicleCurrentOwnerAge() {
        assert Objects.equals(car.getCurrentOwner().getAge(), carCopy.getCurrentOwner().getAge());

        Person newOwner = new Person(2, "Jane", 30);
        car.setCurrentOwner(newOwner);
        assert car.getCurrentOwner().getAge() == 30;
        assert carCopy.getCurrentOwner().getAge() == 25;
    }
}
