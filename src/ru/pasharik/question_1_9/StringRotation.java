package ru.pasharik.question_1_9;

public class StringRotation {
    private static boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        return (str1 + str1).contains(str2);
    }

    public static void main(String[] args) {
        System.out.println(isRotation(
                "waterbottle",
                "erbottlewat"));
    }
}
