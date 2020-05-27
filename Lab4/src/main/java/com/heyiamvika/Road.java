package com.heyiamvika;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle> carsInRoad;

    public Road() {
        this.carsInRoad = new ArrayList<Vehicle>();
    }

    public int getCountOfHumans() {
        // No vehicles on the road, so there are 0 people on the road
        if(carsInRoad.size() == 0)
            return 0;

        int totalHumansCount = 0;
        for(var vehicle: carsInRoad)
            totalHumansCount += vehicle.getOccupiedSeatsCount();

        return totalHumansCount;
    }

    public int getCountOfCars() {
        return carsInRoad.size();
    }

    // We need wildcard in this case to allow passing
    // List with any type of Car : Taxi, PoliceCar or FireTruck
    public void addCarsToRoad(List<? extends Car> carsList) {
        for(var car: carsList)
            carsInRoad.add(car);
    }

    @Override
    public String toString() {
        return "Cars count on the road: " + carsInRoad.size();
    }
}
