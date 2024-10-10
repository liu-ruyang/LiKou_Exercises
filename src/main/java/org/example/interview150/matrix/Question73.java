package org.example.interview150.matrix;

import java.util.HashSet;

public class Question73 {
    public void setZeroes(int[][] matrix) {

        HashSet<Integer> rowsSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        rowsSet.forEach(integer -> {
            for (int j = 0; j < matrix[integer].length; j++) {
                matrix[integer][j] = 0;
            }
        });

        columnSet.forEach(integer -> {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][integer] = 0;
            }
        });
    }
}
