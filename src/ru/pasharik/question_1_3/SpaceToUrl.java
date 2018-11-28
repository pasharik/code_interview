package ru.pasharik.question_1_3;

/**
 * Created by pasharik on 28/11/18.
 * Replace all spaces with '%20'
 */
public class SpaceToUrl {
    void replaceSpaces(char[] arr, int trueLength) {
        int numSpaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (arr[i] == ' ') numSpaces++;
        }
        for (int i = trueLength - 1; i >= 0; i--) {
            if (arr[i] != ' ') {
                arr[numSpaces * 2 + i] = arr[i];
            } else {
                arr[numSpaces * 2 + i - 2] = '%';
                arr[numSpaces * 2 + i - 1] = '2';
                arr[numSpaces * 2 + i] = '0';
                numSpaces--;
            }
        }
    }

    public static void main(String[] args) {
        char[] arr = "Mr John Smith Abc      ".toCharArray();
        System.out.println(arr);
        new SpaceToUrl().replaceSpaces(arr, 17);
        System.out.println(arr);
    }
}
