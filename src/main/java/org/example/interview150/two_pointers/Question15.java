package org.example.interview150.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question15 {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        new Question15().threeSum(a);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int left = 0;
        int right = left + 1;

        Arrays.sort(nums);

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                map.get(nums[i]).add(i);
            }
        }


        List<List<Integer>> lists = new ArrayList<>();
        int preI = Integer.MIN_VALUE;
        int preJ = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == preI) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] == preJ) {
                    continue;
                }
                int need = -nums[i] - nums[j];
                if (map.containsKey(need)) {
                    List<Integer> list = map.get(need);
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k) > j) {
                            lists.add(Arrays.asList(nums[i], nums[j], need));
                            break;
                        }
                    }
                }
                preJ = nums[j];
            }
            preI = nums[i];
        }

        return lists;
    }
}
