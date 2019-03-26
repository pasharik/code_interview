package ru.pasharik.chapter_1_arrays_strings.question_1_4;

/**
 * Created by pasharik on 18/12/18.
 */
public class Polindrome1 {
    public static boolean isPolindrome(String str) {
        int[] a = new int[128];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') a[str.charAt(i)]++;
        }
        boolean hasOdd = false;
        for (int i = 0; i < 128; i++) {
            if (a[i] % 2 == 1) {
                if (hasOdd) {
                    return false;
                }
                hasOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPolindrome("taco ca  t"));
    }
}
