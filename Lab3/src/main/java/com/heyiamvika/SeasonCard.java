package com.heyiamvika;

import java.time.LocalDate;

public class SeasonCard extends Card {
    private String cardType;
    private boolean isDiscounted;
    private LocalDate expirationDate;

    public SeasonCard(String cardType, boolean isDiscounted) {
        // Calling paren't constructor first
        super();
        setCardType(cardType);
        setDiscounted(isDiscounted);
    }

    private void setCardType(String cardType) {
        if(!(cardType.equals("Daily") || cardType.equals("Weekly") || cardType.equals("Monthly")))
            throw new IllegalArgumentException("Invalid card type");

        if(cardType == "Daily")
            setExpirationDate(1);
        else if(cardType == "Weekly")
            setExpirationDate(7);
        else
            // Let's not worry about the actual number of days here
            setExpirationDate(30);

        this.cardType = cardType;
    }

    // This method should be private, but I've set it as protected
    // to be able to create a unit test (to test expired card)
    protected void setExpirationDate(int days) {
        expirationDate = LocalDate.now().plusDays(days);
    }

    private void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    @Override
    public boolean isValid() {
        return !isBlocked() && expirationDate.compareTo(LocalDate.now()) > 0;
    }

    @Override
    public String toString() {
        return "Card id: " + getId() + "\n" +
                "Expiration date: " + expirationDate;
    }
}
