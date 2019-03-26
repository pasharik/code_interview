package ru.pasharik.chapter_1_arrays_strings.question_1_7;

import static ru.pasharik.chapter_1_arrays_strings.question_1_7.MatrixUtils.printMatrix;

public class RotateMatrix90 {
    private static int[][] rotate90(int[][] a) {
        int n = a.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //Top quarter: join of two triangles
                if ((i <= j) //Top-right triangle
                        && ((n - j) > i)) { //Top-left triangle
                    int buf = a[i][j];
                    a[i][j] = a[n - j][i];          //Left -> Top
                    a[n - j][i] = a[n - i][n - j];  //Bottom -> Left
                    a[n - i][n - j] = a[j][n - i];  //Right -> Bottom
                    a[j][n - i] = buf;              //Top -> Right
                }
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1,0,1,1,1,1},
                {1,0,1,1,1,1},
                {1,0,1,1,1,0},
                {1,0,1,1,1,1},
                {1,0,1,1,1,1},
                {1,0,1,1,1,1}
        };
        printMatrix(arr);
        System.out.println("Rotating...");
        printMatrix(rotate90(arr));
    }
}
