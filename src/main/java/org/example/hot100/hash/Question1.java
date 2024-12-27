package org.example.hot100.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class Question1 {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int num2 = target - num1;
            if (map.containsKey(num2) && num2 != num1) {
                res.add(i);     // num1的下标
                res.add(map.get(num2).get(0));  // num2的下标
                break;
            } else if (map.containsKey(num2) && num2 == num1) {     // nums中有重复元素
                if (map.get(num1).size() >= 2) {
                    res.add(map.get(num1).get(0));  // num1的下标
                    res.add(map.get(num1).get(1));  // num2的下标
                    break;
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
