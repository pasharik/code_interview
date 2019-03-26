package ru.pasharik.chapter_1_arrays_strings.question_1_2;

/**
 * Created by pasharik on 27/11/18.
 *
 * Check if one string/array is permutation of another
 * Method 2: hash-table principle. Assume there is only 128 symbols in alphabet.
 * We use array (same idea with hash table) to map each symbol from the string -
 * count how many times it occurred
 *
 * [a] -> 1
 * [b] -> 2
 * [c] -> 55
 * ...
 *
 * Then we check if each symbol has the same count
 */
public class StringPermutationArray {
    public boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] arr = new int[128]; //Assume alphabet has 128 symbols
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            arr[ch]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            arr[ch]--;
            if (arr[ch] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StringPermutationArray().isPermutation(
                "321daCF",
                "123daFC"));
    }
}
