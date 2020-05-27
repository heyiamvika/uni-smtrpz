package com.heyiamvika;

public class Bus<T extends Person> extends Vehicle<T> {
    public Bus() {
        super(20);
    }
}
