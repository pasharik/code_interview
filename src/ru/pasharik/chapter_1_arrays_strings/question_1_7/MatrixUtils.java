package ru.pasharik.chapter_1_arrays_strings.question_1_7;

public class MatrixUtils {
    public static void printMatrix(int[][] matr) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
