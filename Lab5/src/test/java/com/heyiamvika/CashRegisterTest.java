package com.heyiamvika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CashRegisterTest {
    @Test
    void addItem_CountIsLessThanOne_ThrowsIllegalArgumentException() {
        var cashRegister = new CashRegister();
        var butter = new Item("Butter", 12);

        Assertions.assertThrows(
                IllegalArgumentException.class, () -> cashRegister.addItem(butter, -1)
        );
    }
}