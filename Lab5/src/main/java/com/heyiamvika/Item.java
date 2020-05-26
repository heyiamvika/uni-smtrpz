package com.heyiamvika;

// This class implements Comparable interface
// to allow sorting Item list in CashRegister

public class Item implements Comparable<Item> {
    private String title;
    private int price;
    private int count;

    public Item(String title, int price) {
        this.title = title;
        this.price = price;
        this.count = 0;
    }

    public String getTitle() {
        return title;
    }

    public void increaseCount(int itemsCount) {
        count += itemsCount;
    }

    @Override
    public int compareTo(Item other) {
        // Will allow sorting items in lexicographical order
        return title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Item: " + title + "\n" +
                "Price: " + price + "\n" +
                "Count: " + count + "\n";
    }
}
