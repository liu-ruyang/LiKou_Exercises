package org.example.interview150.interval;

import java.util.ArrayList;
import java.util.List;

public class Question228 {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        int left = 0;
        int right = 1;
        for (; right < nums.length; right++) {
            if (nums[right] != nums[right - 1] + 1) {
                if (left == right - 1) {
                    res.add(nums[left] + "");
                } else {
                    res.add(nums[left] + "->" + nums[right - 1]);
                }
                left = right;
            }
        }
        if (left != nums.length - 1) {
            res.add(nums[left] + "->" + nums[right - 1]);
        } else {
            res.add(nums[left] + "");
        }
        return res;
    }
}
