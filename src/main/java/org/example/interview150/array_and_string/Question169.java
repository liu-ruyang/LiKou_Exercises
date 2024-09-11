package org.example.interview150.array_and_string;

import java.util.HashMap;

public class Question169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 1;
        int result = nums[0];
        for (int num : nums) {
            if (map.containsKey(num)) {
                int value = map.get(num) + 1;
                map.put(num, value);
                if (value >= max) {
                    max = value;
                    result = num;
                }
            } else {
                map.put(num, 1);
            }
        }

        return result;
    }
}
