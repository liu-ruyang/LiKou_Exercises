package org.example.interview150.hash;

import java.util.HashMap;

public class Question1 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] a = {map.get(target - nums[i]), i};
                return a;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
