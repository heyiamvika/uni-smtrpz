package com.heyiamvika;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class Card {
    // This class is abstract,
    // since it's created solely for sharing common data across Card implementations
    // We shouldn't use this class directly

    // id is set once and should never be changed
    private final int id;
    private boolean isBlocked;
    // I'm using ArrayList and not Array here,
    // since I'm not sure how many items will be in this data structure
    private ArrayList<LocalDate> passes;
    private ArrayList<LocalDate> rejections;

    public Card() {
        this.id = createCardId();
        this.isBlocked = false;
        this.passes = new ArrayList<LocalDate>();
        this.rejections = new ArrayList<LocalDate>();;
    }

    public int getId() {
        return id;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void blockCard() {
        isBlocked = true;
    }

    public void printCardHistory() {
        System.out.println("CARD id: " + id);

        System.out.println("PASSES");
        for(var pass: passes)
            System.out.println("Pass: " + pass);

        System.out.println("REJECTIONS");
        for(var rejection: rejections)
            System.out.println("Rejection: " + rejection);
    }

    public void registerPass() {
        passes.add(LocalDate.now());
    }

    public void registerRejection() {
        rejections.add(LocalDate.now());
    }

    private int createCardId() {
        // Let's say this is the overall number of cards that can be issued
        int totalCardsNumber = 100000;
        return new Random().nextInt(totalCardsNumber);
    }

    // Polymorphism: this is default method
    // actual implementations of the method are in it' subclasses
    public void useCard() { }
    public boolean isValid() { return true; }
}
