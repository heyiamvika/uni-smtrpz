package com.heyiamvika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    public void findWordsInLexicographicalOrder_WordsFound_ReturnsWordsArray() {
        String[] expected = { "abcdefg", "is", "my" };
        String[] actual = Main.findWordsInLexicographicalOrder("abcdefg is my test input");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findWordsInLexicographicalOrder_WordsNotFound_ReturnsEmptyArray() {
        String[] expected = { };
        String[] actual = Main.findWordsInLexicographicalOrder("This sentence doesn't include lexicographically ordered words");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findWordsInLexicographicalOrder_EmptyStringInput_ReturnsEmptyArray() {
        String[] expected = { };
        String[] actual = Main.findWordsInLexicographicalOrder(" ");
        Assertions.assertArrayEquals(expected, actual);
    }
}