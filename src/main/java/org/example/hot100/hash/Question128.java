package org.example.hot100.hash;

import java.util.HashSet;

public class Question128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {   // 确保当前的num是所在连续序列的最小的数字，可以剪掉绝大部分的枝叶
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    if (count > res) {
                        res = count;
                    }
                    num++;
                }
            }
        }
        return res;

    }
}
