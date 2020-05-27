package com.heyiamvika;

import java.util.Arrays;
import java.util.HashMap;

public class CardRegister {
    // I'm using hash map to store cards,
    // since lookup runtime complexity is much better than Array's one - O(1) vs O(n)
    private HashMap<Integer, Card> cards;

    public CardRegister() {
        this.cards = new HashMap<Integer, Card>();
    }

    public Card issueANewCard(String cardType, boolean isDiscounted) {
        var card = new SeasonCard(cardType, isDiscounted);
        createCardEntry(card);
        return card;
    }

    public Card issueANewCard(int tripsCount, boolean isDiscounted) {
        var card = new NumberOfTripsCard(tripsCount, isDiscounted);
        createCardEntry(card);
        return card;
    }

    public Card issueANewCard(int uah) {
        var card = new TopUpCard(uah);
        createCardEntry(card);
        return card;
    }

    public void printHistory() {
        for(var card: cards.values())
            card.printCardHistory();
    }

    public void printHistory (String cardType) {
        String[] validCardTypes = { "Season card", "Number of trips card", "Top up card"};
        boolean isCardTypeValid = Arrays.asList(validCardTypes).contains(cardType);

        if(!isCardTypeValid)
            throw new IllegalArgumentException("Card type is not valid");

        for(var card: cards.values()) {
            if(cardType == validCardTypes[0] && card instanceof SeasonCard ||
                    cardType == validCardTypes[1] && card instanceof NumberOfTripsCard ||
                    cardType == validCardTypes[2] && card instanceof TopUpCard
            )
                card.printCardHistory();
        }
    }

    public void printHistory(int id) {
        cards.get(id).printCardHistory();
    }

    public Card findCard(Card card) {
        return cards.get(card.getId());
    }

    public void blockCard(Card card) {
        card.blockCard();
    }

    private void createCardEntry(Card card) {
        cards.put(card.getId(), card);
    }
}
