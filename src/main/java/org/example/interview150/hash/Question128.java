package org.example.interview150.hash;

import java.util.HashMap;
import java.util.TreeSet;

public class Question128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (Integer num : set) {
            if (!map.containsKey(num - 1)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num - 1) + 1);
            }
        }

        int res = 0;
        for (Integer i : map.keySet()) {
            res = res >= map.get(i) ? res : map.get(i);
        }
        return res;

    }
}
