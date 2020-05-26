package com.heyiamvika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class VehicleTest {
    @Test
    void getOnTheVehicle_TheVehicleIsFull_ThrowsIllegalStateException() {
        // Can be any type of vehicle
        Random random = new Random();
        Bus<Person> bus = new Bus<>();
        int busCapacity = bus.getMaxCapacity();

        for(int i = 0; i < busCapacity; i++) {
            Person person = new Person("Random name", random.nextInt(100));
            bus.getOnTheVehicle(person);
        }

        Assertions.assertThrows(
                IllegalStateException.class, () -> bus.getOnTheVehicle(new Person("Another random name", random.nextInt(100)))
        );
    }

    @Test
    void getOnTheVehicle_TheSamePersonGetsOnTheVehicle_ThrowsIllegalArgumentException() {
        // Can be any type of vehicle
        Random random = new Random();
        FireTruck<Firefighter> fireTruck = new FireTruck<>();

        Firefighter firefighter = new  Firefighter("John", 30, 20);
        fireTruck.getOnTheVehicle(firefighter);

        Assertions.assertThrows(
                IllegalArgumentException.class, () -> fireTruck.getOnTheVehicle(firefighter)
        );
    }

    @Test
    void getOffTheVehicle_TriesToGoOffTheEmptyVehicle_ThrowsIllegalStateException() {
        // Can be any type of vehicle
        Random random = new Random();
        PoliceCar<Policeman> policeCar = new PoliceCar<>();

        Policeman policewoman = new Policeman("Alice", 28, "Sergeant");

        Assertions.assertThrows(
                IllegalStateException.class, () -> policeCar.getOffTheVehicle(policewoman)
        );
    }


    @Test
    void getOffTheVehicle_PersonNotOnTheVehicleTriesToGoOff_ThrowsIllegalArgumentException() {
        // Can be any type of vehicle
        Random random = new Random();
        Taxi<Person> taxi = new Taxi<>();

        Person person = new Person("Vika", 25);
        Person anotherPerson = new Person("Arthur", 25);

        taxi.getOnTheVehicle(person);

        Assertions.assertThrows(
                IllegalArgumentException.class, () -> taxi.getOffTheVehicle(anotherPerson)
        );
    }
}