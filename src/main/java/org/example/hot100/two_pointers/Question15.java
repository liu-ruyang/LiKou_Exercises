package org.example.hot100.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Question15 {
    public static void main(String[] args) {
        // int[] a = {-1, 0, 1, 2, -1, -4};
        int[] a = {3, 0, -2, -1, 1, 2};

        new Question15().threeSum(a);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 && !set.contains(nums[i])) {
                set.add(nums[i]);
                int j = i + 1, k = nums.length - 1;
                HashSet<Integer> set2 = new HashSet<>();
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0 && !set2.contains(nums[j])) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        set2.add(nums[j]);
                        j++;
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return res;
    }
    // public List<List<Integer>> threeSum(int[] nums) {
    //     Arrays.sort(nums);
    //     ArrayList<Integer> negative = new ArrayList<>();
    //     HashSet<Integer> positive = new HashSet<>();
    //     for (int num : nums) {
    //         if (num > 0) {
    //             positive.add(num);
    //         } else {
    //             negative.add(num);
    //         }
    //     }
    //
    //     List<List<Integer>> res = new ArrayList<>();
    //     for (int i = 0; i < negative.size(); i++) {
    //         for (int j = i + 1; j < negative.size(); j++) {
    //             int num1 = negative.get(i) + negative.get(j);
    //             int num2 = -num1;
    //             if (positive.contains(num2)) {
    //                 res.add(Arrays.asList(negative.get(i), negative.get(j), num2));
    //             }
    //         }
    //     }
    //     return res;
    // }

}
