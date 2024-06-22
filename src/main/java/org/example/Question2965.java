package org.example;

public class Question2965 {
    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 2}};
        new Question2965().findMissingAndRepeatedValues(a);
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] records = new int[grid.length * grid.length + 1];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                records[grid[i][j]]++;
            }
        }

        int index0 = 0, index2 = 0;
        for (int i = 1; i < records.length; i++) {
            if (records[i] == 2) {
                index2 = i;
            }
            if (records[i] == 0) {
                index0 = i;
            }
        }
        return new int[]{index2, index0};
    }
}
