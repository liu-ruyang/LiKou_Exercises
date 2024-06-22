package org.example;

import java.util.HashMap;

public class Question2779 {
    public static void main(String[] args) {
        int[] a = {4, 6, 1, 2};
        new Question2779().maximumBeauty(a, 2);
    }

    public int maximumBeauty(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = -k; j <= k; j++) {
                if (map.containsKey(nums[i] + j)) {
                    map.put(nums[i] + j, map.get((nums[i] + j)) + 1);
                } else {
                    map.put(nums[i] + j, 1);
                }
            }
        }


        int[] result = {Integer.MIN_VALUE};
        map.forEach((key, value) -> {
            result[0] = result[0] > value ? result[0] : value;
        });
        return result[0];
    }
}
