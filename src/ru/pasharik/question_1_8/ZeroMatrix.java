package ru.pasharik.question_1_8;

import ru.pasharik.question_1_7.MatrixUtils;

import java.util.Arrays;

public class ZeroMatrix {
    private static void doZero(int[][] a) {
        int n = a.length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        //Elements in 0th row and 0th column will indicate if corresponding row/col should be all zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    a[0][j] = 0;
                    a[i][0] = 0;
                    if (i == 0) firstRowZero = true;
                    if (j == 0) firstColZero = true;
                }
            }
        }
        //Zero most of the matrix except 0th row and 0th column
        for (int i = 1; i < n; i++) {
            if (a[i][0] == 0) {
                Arrays.fill(a[i], 0);
            } else {
                for (int j = 1; j < a[i].length; j++) {
                    if (a[0][j] == 0)  a[i][j] = 0;
                }
            }
        }
        //Zero 0th row
        if (firstRowZero) Arrays.fill(a[0], 0);
        //Zero 0th column
        if (firstColZero) {
            for (int i = 0; i < n; i++) a[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1,0,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,0,1,1,1},
                {1,1,1,1,1,1,1,1,1}
        };
        MatrixUtils.printMatrix(arr);
        doZero(arr);
        System.out.println("Processing...");
        MatrixUtils.printMatrix(arr);
    }
}
