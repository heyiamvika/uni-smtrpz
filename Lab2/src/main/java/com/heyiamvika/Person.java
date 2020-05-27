package com.heyiamvika;

import com.google.gson.Gson;

import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final int height;
    private final boolean isEmployed;

    public Person(String name, String surname, int age, int height, boolean isEmployed) {
        // I don't use setters, since it's impossible to modify final field from there
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.isEmployed = isEmployed;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getAge() {
        return this.age;
    }


    public int getHeight() {
        return this.height;
    }

    public boolean isEmployed() {
        return this.isEmployed;
    }

    @Override
    public final boolean equals(Object obj) {
        // The same object / same address in the memory
        if(this == obj)
            return true;

        // Objects are of different classes
        if(!(obj instanceof Person))
            return false;

        // We need to cast the obj to get access to the methods
        Person person = (Person) obj;
        return (getName() != null ? getName().equals(person.getName()) : person.getName() == null) &&
                (getSurname() != null ? getSurname().equals(person.getSurname()) : person.getSurname() == null) &&
                getAge() == person.getAge() &&
                getHeight() == person.getHeight() &&
                isEmployed() == person.isEmployed();
    }

    @Override
    public final int hashCode() {
        // Generate hash based on object's values
        return Objects.hash(getName(), getSurname(), getAge(), getHeight(), isEmployed());
    }

    public static String toJSON(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static Person fromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }
}
