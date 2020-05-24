package com.heyiamvika;

public class NumberOfTripsCard extends Card{
    private int tripsLeft;
    private boolean isDiscounted;

    public NumberOfTripsCard(int trips, boolean isDiscounted) {
        // Calling paren't constructor first
        super();
        setTripsLeft(trips);
        setDiscounted(isDiscounted);
    }

    private void setTripsLeft(int trips) {
        if(!(trips == 4 || trips == 10 || trips == 20))
            throw new IllegalArgumentException("Invalid trips number");
        tripsLeft = trips;
    }

    private void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    @Override
    public void useCard() {
        tripsLeft--;
    }

    @Override
    public boolean isValid() {
        return !isBlocked() && tripsLeft > 0;
    }

    @Override
    public String toString() {
        return "Card id: " + getId() + "\n" +
                "Trips left: " + tripsLeft;
    }
}
