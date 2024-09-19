package org.example.greedy_question;

import java.util.Arrays;

public class Question135 {
    // public int candy(int[] ratings) {
    //     // 三种情况：
    //     // 1.右边比左边大
    //     // 2.右边比左边小
    //     // 3.右边等于左边
    //
    //     int[] candies = new int[ratings.length];
    //     candies[0] = 1;
    //     int minIndex = 0;
    //
    //     for (int i = 1; i < ratings.length; i++) {
    //         if (ratings[i] > ratings[i - 1]) {
    //             candies[i] = candies[i - 1] + 1;
    //         } else if (ratings[i] < ratings[i - 1]) {
    //             candies[i] = Integer.min(candies[i - 1] - 1, 1);
    //             minIndex = i;
    //         } else {
    //             candies[i] = Integer.min(candies[i - 1], 1);
    //         }
    //     }
    //
    //     while (minIndex < ratings.length) {
    //
    //
    //         minIndex++;
    //     }
    //
    // }

    // 这在leetcode上是一道困难的题目，其难点就在于贪心的策略，如果在考虑局部的时候想两边兼顾，就会顾此失彼。
    //
    // 那么本题我采用了两次贪心的策略：
    //
    // 一次是从左到右遍历，只比较右边孩子评分比左边大的情况。
    // 一次是从右到左遍历，只比较左边孩子评分比右边大的情况。
    // 这样从局部最优推出了全局最优，即：相邻的孩子中，评分高的孩子获得更多的糖果。

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Integer.max(candies[i + 1] + 1, candies[i]);
        }

        return Arrays.stream(candies).sum();
    }
}
