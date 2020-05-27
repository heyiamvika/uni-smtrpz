package com.heyiamvika;

public abstract class Car<T extends Person> extends Vehicle<T> {
    public Car() {
        super(4);
    }
}

