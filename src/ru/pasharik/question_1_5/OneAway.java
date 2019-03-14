package ru.pasharik.question_1_5;

public class OneAway {
    public static boolean isOneAway(char[] arr1, char[] arr2) {
        if((Math.abs(arr1.length - arr2.length)) > 1) return false;
        if (arr1.length == arr2.length) {
            //check if there is only one difference
            boolean hasDiff = false;
            for(int i = 0; i < arr1.length; i++) {
                if(arr1[i] != arr2[i]) {
                    if (hasDiff) return false;
                    hasDiff = true;
                }
            }
        } else {
            char[] longArr = arr1.length > arr2.length ? arr1 : arr2;
            char[] shortArr = arr1.length > arr2.length ? arr2 : arr1;
            boolean hasDiff = false;
            for (int i = 0, j = 0; i < longArr.length && j < shortArr.length; i++, j++) {
                if(longArr[i] != shortArr[j]) {
                    if (hasDiff) return false;
                    hasDiff = true;
                    j--; //Stay on the same element of smaller array
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isOneAway(
                "pale".toCharArray(),
                "ple".toCharArray()
        ));
    }
}
