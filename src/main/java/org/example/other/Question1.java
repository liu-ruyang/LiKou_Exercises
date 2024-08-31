package org.example.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question1 {
    int[] result;

    public static void main(String[] args) {
        int[] a = {-1, -2, -3, -4, -5};
        new Question1().twoSum(a, -8);
    }

    public int[] twoSum(int[] nums, int target) {
        result = new int[2];

        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                map.get(nums[i]).add(i);
            }
        }

        map.forEach((key, value) -> {
            // if (key <= target) {
            if (map.containsKey(target - key)) {
                if (key != target - key) {
                    result[1] = map.get(key).get(0);
                    result[0] = map.get(target - key).get(0);
                } else if (map.get(key).size() > 1) {
                    result[0] = map.get(key).get(0);
                    result[1] = map.get(key).get(1);
                }
                // result = {map.get(key), map.get(target - key)};

                // System.out.println(result);
            }
            // }
        });

        return result;
    }
}
