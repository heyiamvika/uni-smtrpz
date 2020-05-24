package com.heyiamvika;

import java.util.Random;

public class Gate {
    private CardRegister register;

    public Gate(CardRegister register) {
        this.register = register;
    }

    public String validateCard(Card card) {
        if(register.findCard(card) == null || !card.isValid()) {
            return rejectEntrance(card);
        }

        return allowEntrance(card);
    }

    public String validateCard(Card card, boolean documentsValid) {
        if(register.findCard(card) == null || !card.isValid()) {
            return rejectEntrance(card);
        }

        if(card instanceof SeasonCard && ((SeasonCard) card).isDiscounted() ||
                card instanceof NumberOfTripsCard && ((NumberOfTripsCard) card).isDiscounted()
        ){
            return warn(card, documentsValid);
        }

        return allowEntrance(card);
    }

    private String warn(Card card, boolean documentsValid) {
        return  documentsValid ? allowEntrance(card) : rejectEntrance(card);
    }

    private String allowEntrance(Card card) {
        card.useCard();
        card.registerPass();
        return "Entry allowed";
    }

    private String rejectEntrance(Card card) {
        card.registerRejection();
        return "Card is not valid. Entry denied";
    }
}
