package com.heyiamvika;

import java.util.HashMap;

// Only people can get on the vehicle
// so we use bounded type parameter here
public abstract class Vehicle<T extends Person> {
    private int capacity;
    private int occupiedSeatsCount;
    private HashMap<Integer, Person> passengers;

    public Vehicle(int capacity) {
        this.capacity = capacity;
        this.occupiedSeatsCount = 0;
        this.passengers = new HashMap<Integer, Person>();
    }

    public int getMaxCapacity() { return capacity; }
    public int getOccupiedSeatsCount() { return occupiedSeatsCount; }
    public void getOnTheVehicle(T person) {
        int id = person.getId();

        if(occupiedSeatsCount == capacity)
            throw new IllegalStateException("This vehicle is full");

        if(passengers.get(id) != null)
            throw new IllegalArgumentException("This person is already on the vehicle");

        passengers.put(person.getId(), person);
        occupiedSeatsCount++;
    }
    public void getOffTheVehicle(T person) {
        int id = person.getId();

        if(passengers.size() == 0)
            throw new IllegalStateException("This vehicle is empty");

        if(passengers.get(id) == null)
            throw new IllegalArgumentException("This person is not on the vehicle");

        passengers.remove(person.getId());
        occupiedSeatsCount--;
    }
}
