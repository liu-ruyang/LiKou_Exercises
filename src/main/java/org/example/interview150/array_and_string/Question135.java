package org.example.interview150.array_and_string;

import java.util.Arrays;

public class Question135 {
    public int candy(int[] ratings) {
        int[] num = new int[ratings.length];
        num[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            } else {
                num[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                num[i] = Integer.max(num[i + 1] + 1, num[i]);
            }
        }

        return Arrays.stream(num).sum();
    }
}
