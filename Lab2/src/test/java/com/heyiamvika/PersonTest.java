package com.heyiamvika;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {
    @Test
    void equals_EqualsMethodCorrect_ReturnsTrue() {
        EqualsVerifier.forClass(Person.class).verify();
    }

    @Test
    void equals_TwoObjectsAreEqual_ReturnsTrue() {
        var obj1 = new Person("Vika", "Nosova", 25, 162, true);
        var obj2 = new Person("Vika", "Nosova", 25, 162, true);

        var deserializedObj1 = Person.fromJSON(Person.toJSON(obj1));
        var deserializedObj2 = Person.fromJSON(Person.toJSON(obj2));
        boolean areEqual = deserializedObj1.equals(deserializedObj2);

        Assertions.assertTrue(areEqual);
    }

    @Test
    void equals_TwoObjectsNotEqual_ReturnsFalse() {
        var obj1 = new Person("Vika", "Nosova", 25, 162, true);
        var obj2 = new Person("Hanna", "Hrybinnyk", 27, 172, true);

        var deserializedObj1 = Person.fromJSON(Person.toJSON(obj1));
        var deserializedObj2 = Person.fromJSON(Person.toJSON(obj2));
        boolean areEqual = deserializedObj1.equals(deserializedObj2);

        Assertions.assertFalse(areEqual);
    }
}