package com.heyiamvika;

public class TopUpCard extends Card{
    private final int TRIP_FEE = 8;
    private int uahLeft;

    public TopUpCard(int uah) {
        // Calling paren't constructor first
        super();
        setUahLeft(uah);
    }

    public void setUahLeft(int uah) {
        uahLeft = uah;
    }

    @Override
    public void useCard() {
        uahLeft -= TRIP_FEE;
    }

    @Override
    public boolean isValid() {
        return !isBlocked() && uahLeft > TRIP_FEE;
    }

    @Override
    public String toString() {
        return "Card id: " + getId() + "\n" +
                "Current balance : " + uahLeft;
    }
}
