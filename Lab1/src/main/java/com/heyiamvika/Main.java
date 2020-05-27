package com.heyiamvika;

import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    }

    public static String[] findWordsInLexicographicalOrder (String input) {
        String[] words = input.split(" ");
        // I'm using Linked List here, since I don't want to allocate memory I don't need
        LinkedList<String> result = new LinkedList<String>();

        for(String word: words) {
            char[] charArray = word.toCharArray();
            Stack<Integer> numValuesStack = new Stack<Integer>();

            for(char ch: charArray) {
                int numericValue = Character.getNumericValue(ch);
                if(!numValuesStack.isEmpty() && numericValue < numValuesStack.peek()) {
                    // word doesn't match the requirement
                    break;
                }
                numValuesStack.add(numericValue);
            }

            if(numValuesStack.size() == charArray.length) {
                result.addLast(word);
            }
        }

        return result.toArray(new String[result.size()]);
    }
}
