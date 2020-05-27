package com.heyiamvika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RoadTest {
    @Test
    void getCountOfHumans_GetsCorrectCountOfHumans_ReturnsCorrectInteger() {
        int expectedPeopleCount = 6;

        Road road = new Road();

        PoliceCar<Policeman> policeCar = new PoliceCar<>();
        Policeman policeman1 = new Policeman("Jane", 30, "Sergeant");
        Policeman policeman2 = new Policeman("Joe", 27, "Sergeant");
        policeCar.getOnTheVehicle(policeman1);
        policeCar.getOnTheVehicle(policeman2);

        FireTruck<Firefighter> fireTruck = new FireTruck<>();
        Firefighter firefighter1 = new Firefighter("Karen", 54, 20);
        fireTruck.getOnTheVehicle(firefighter1);

        Taxi<Person> taxi = new Taxi<>();
        Person person1 = new Person("John", 25);
        Person person2 = new Person("Alice", 35);
        Person person3 = new Person("Alina", 27);
        taxi.getOnTheVehicle(person1);
        taxi.getOnTheVehicle(person2);
        taxi.getOnTheVehicle(person3);

        List<Car> carList = new ArrayList<>();
        carList.add(policeCar);
        carList.add(fireTruck);
        carList.add(taxi);

        road.addCarsToRoad(carList);

        int peopleCount = road.getCountOfHumans();

        Assertions.assertEquals(expectedPeopleCount, peopleCount);
    }

    @Test
    void addCarsToRoad_CarsAddedCorrectly_ReturnsCorrectCarsCountInteger() {
        int expectedCarsCount = 4;

        Road road = new Road();

        PoliceCar<Policeman> policeCar = new PoliceCar<>();
        FireTruck<Firefighter> fireTruck = new FireTruck<>();
        Taxi<Person> taxi = new Taxi<>();
        Taxi<Person> anotherTaxi = new Taxi<>();

        List<Car> carList = new ArrayList<>();
        carList.add(policeCar);
        carList.add(fireTruck);
        carList.add(taxi);
        carList.add(anotherTaxi);

        road.addCarsToRoad(carList);

        int carsCount = road.getCountOfCars();

        Assertions.assertEquals(expectedCarsCount, carsCount);
    }
}