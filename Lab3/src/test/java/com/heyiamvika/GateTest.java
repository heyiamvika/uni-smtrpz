package com.heyiamvika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GateTest {
    private final String ENTRY_DENIED_MESSAGE = "Card is not valid. Entry denied";
    private final String ENTRY_ALLOWED_MESSAGE = "Entry allowed";

    @Test
    void validateCard_CardNotFoundInRegister_ReturnsEntryDeniedString() {
        // Can be any type of card,
        // card is not issued by register
        // and created manually instead
        CardRegister cardRegister = new CardRegister();
        Gate gate = new Gate(cardRegister);
        var card = new NumberOfTripsCard(4, false);

        String result = gate.validateCard(card);

        Assertions.assertEquals(result, ENTRY_DENIED_MESSAGE);
    }

    @Test
    void validateCard_CardIsBlocked_ReturnsEntryDeniedString() {
        // Can be any type of card
        CardRegister cardRegister = new CardRegister();
        Gate gate = new Gate(cardRegister);

        var card = cardRegister.issueANewCard(200);
        cardRegister.blockCard(card);
        String result = gate.validateCard(card);

        Assertions.assertEquals(result, ENTRY_DENIED_MESSAGE);
    }

    @Test
    void validateCard_SeasonCardExpired_ReturnsEntryDeniedString() {
        // Can be any type of Season card
        CardRegister cardRegister = new CardRegister();
        Gate gate = new Gate(cardRegister);

        var card = cardRegister.issueANewCard("Weekly", false);
        ((SeasonCard) card).setExpirationDate(-1);
        String result = gate.validateCard(card);

        Assertions.assertEquals(result, ENTRY_DENIED_MESSAGE);
    }

    @Test
    void validateCard_SeasonCardValid_ReturnsEntryAllowedString() {
        // Can be any type of Season card
        CardRegister cardRegister = new CardRegister();
        Gate gate = new Gate(cardRegister);

        var card = cardRegister.issueANewCard("Monthly", false);
        String result = gate.validateCard(card);

        Assertions.assertEquals(result, ENTRY_ALLOWED_MESSAGE);
    }

    @Test
    void validateCard_NumberOfTripsIsZero_ReturnsEntryDeniedString() {
        // Can be any type of Number of trips card
        CardRegister cardRegister = new CardRegister();
        Gate gate = new Gate(cardRegister);

        var card = cardRegister.issueANewCard(4, false);
        // Card used 4 times
        for(int i = 0; i < 4; i++)
            gate.validateCard(card);

        String result = gate.validateCard(card);

        Assertions.assertEquals(result, ENTRY_DENIED_MESSAGE);
    }

    @Test
    void validateCard_NumberOfTripsCardValid_ReturnsEntryAllowedString() {
        // Can be any type of Number of trips card
        CardRegister cardRegister = new CardRegister();
        Gate gate = new Gate(cardRegister);

        var card = cardRegister.issueANewCard(4, false);
        String result = gate.validateCard(card);

        Assertions.assertEquals(result, ENTRY_ALLOWED_MESSAGE);
    }

    @Test
    void validateCard_TopUpCardInsufficientFunds_ReturnsEntryDeniedString() {
        // Can be any type of Top up card
        CardRegister cardRegister = new CardRegister();
        Gate gate = new Gate(cardRegister);

        var card = cardRegister.issueANewCard(10);
        gate.validateCard(card);

        String result = gate.validateCard(card);
        Assertions.assertEquals(result, ENTRY_DENIED_MESSAGE);
    }

    @Test
    void validateCard_TopUpCardValid_ReturnsEntryAllowedString() {
        // Can be any type of Top up card
        CardRegister cardRegister = new CardRegister();
        Gate gate = new Gate(cardRegister);

        var card = cardRegister.issueANewCard(10);
        String result = gate.validateCard(card);

        Assertions.assertEquals(result, ENTRY_ALLOWED_MESSAGE);
    }

    @Test
    void validateCard_DiscountedCardDocumentsNotValid_ReturnsEntryDeniedString() {
        // Can be any type of card
        CardRegister cardRegister = new CardRegister();
        Gate gate = new Gate(cardRegister);

        var card = cardRegister.issueANewCard("Weekly", true);
        String result = gate.validateCard(card, false);

        Assertions.assertEquals(result, ENTRY_DENIED_MESSAGE);
    }

    @Test
    void validateCard_DiscountedCardDocumentsValid_ReturnsEntryAllowedString() {
        // Can be any type of card
        CardRegister cardRegister = new CardRegister();
        Gate gate = new Gate(cardRegister);

        var card = cardRegister.issueANewCard("Daily", true);
        String result = gate.validateCard(card, true);

        Assertions.assertEquals(result, ENTRY_ALLOWED_MESSAGE);
    }

}