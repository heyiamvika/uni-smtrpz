package com.heyiamvika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CashRegister {
    List<Item> items;

    public CashRegister() {
        this.items = new ArrayList<Item>();;
    }

    public void addItem(Item item, int count) {
        if(count < 1)
            throw new IllegalArgumentException("Count should be greater or equal to one");

        // Note: this is not the best solution in terms of performance,
        // since it has linear runtime complexity O(n)
        // I'll (probably) refactor it later

        for(var itemInList: items) {
            // Check if item already exists
            if(itemInList.getTitle().equals(item.getTitle())) {
                itemInList.increaseCount(count);
                return;
            }
        }

        // Item does not exist
        item.increaseCount(count);
        items.add(item);
    }

    public String getReceipt() {
        // I only sort items on receipt print to avoid unnecessary operations
        sortItems();

        String receipt = "RECEIPT" + "\n";
        for (var item: items)
            // String concatenation
            receipt += item;

        return receipt;
    }

    private void sortItems() {
        Collections.sort(items);
    }
}
