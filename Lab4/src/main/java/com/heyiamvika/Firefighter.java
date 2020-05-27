package com.heyiamvika;

public class Firefighter extends Person {
    private int yearsExperience;

    public Firefighter(String name, int age, int yearsExperience) {
        super(name, age);
        this.yearsExperience = yearsExperience;
    }
}
