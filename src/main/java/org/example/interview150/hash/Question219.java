package org.example.interview150.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = map.get(nums[i]);
                if (list.size() > 0 && i - list.get(0) <= k) {
                    return true;
                } else {
                    list.add(0, i);
                }
            }
        }
        return false;
    }
}
