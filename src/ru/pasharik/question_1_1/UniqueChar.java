package ru.pasharik.question_1_1;

/**
 * Created by pasharik on 21/11/18.
 *
 * Check if all characters in String are unique:
 * Have a Int array, each element correspond to each symbol of alphabet
 */
public class UniqueChar {
    public boolean allUnique(String str) {
        //Assuming we have only 256 symbols in alphabet.
        if (str.length() > 256) return false; // If string is longer, it will have duplicates
        Integer[] intArr = new Integer[256];
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (intArr[ch] != null) return false;
            intArr[ch] = 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueChar().allUnique("abcd123a"));
    }
}
