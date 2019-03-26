package ru.pasharik.chapter_1_arrays_strings.question_1_2;

import java.util.Arrays;

/**
 * Created by pasharik on 27/11/18.
 *
 * Check if one string/array is permutation of another
 * Method 1: sort both strings (log N), and then check if each symbol is the same
 */
public class StringPermutationSort {
    public boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        System.out.println(new StringPermutationSort().isPermutation(
                "321daCF",
                "123daFC"));
    }
}
