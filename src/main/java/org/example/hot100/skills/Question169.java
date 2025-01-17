package org.example.hot100.skills;

import java.util.HashMap;

public class Question169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        int[] res = {nums[0], map.get(nums[0])};
        map.forEach((num, count) -> {
            if (res[1] < count) {
                res[0] = num;
                res[1] = count;
            }
        });
        return res[0];
    }
//    public int majorityElement(int[] nums) {
//        int res = filter(nums, 0, nums.length - 1);
//        return res;
//    }
//
//    public int filter(int[] nums, int left, int right) {
//        if (left == right) {
//            return nums[left];
//        }
//        if (left + 1 == right) {
//            if (nums[left] == nums[right]) {
//                return nums[left];
//            } else {
//                return Integer.MIN_VALUE;
//            }
//        }
//        int mid = (left + right) / 2;
//        int leftNum = filter(nums, left, mid);
//        int rightNum = filter(nums, mid + 1, right);
//
//        if (leftNum == Integer.MIN_VALUE && rightNum == Integer.MIN_VALUE) {
//            return Integer.MIN_VALUE;
//        } else if (leftNum != Integer.MIN_VALUE && rightNum == Integer.MIN_VALUE) {
//            return leftNum;
//        } else if (leftNum == Integer.MIN_VALUE && rightNum != Integer.MIN_VALUE) {
//            return rightNum;
//        } else {
//            if (leftNum == rightNum) {
//                return rightNum;
//            } else {
//                return Integer.MIN_VALUE;
//            }
//        }
//    }
}
