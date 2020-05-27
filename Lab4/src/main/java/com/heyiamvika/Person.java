package com.heyiamvika;

import java.util.Random;

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = createPersonId();
    }

    private int createPersonId() {
        return (new Random()).nextInt(100000);
    }
    public int getId() { return id; }

    @Override
    public String toString() {
        return "Person name: " + name + "\n" +
                "Person age: " + age;
    }
}
