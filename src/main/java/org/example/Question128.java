package org.example;

import java.util.List;
import java.util.TreeSet;

public class Question128 {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        new Question128().longestConsecutive(nums);
    }

    public int longestConsecutive(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }


        // (Integer[]) set.toArray();
        // Integer[] list = (Integer[]) set.stream().toArray();
        List<Integer> list = set.stream().toList();
        if (list.size() <= 0) return 0;

        int maxLength = 0;
        int previous = list.get(0) - 1;
        int tempLength = 0;

        for (Integer num : set) {
            if (num == previous + 1) {
                tempLength++;
            } else {
                tempLength = 1;
            }

            maxLength = Integer.max(tempLength, maxLength);
            previous = num;
        }

        return maxLength;
    }
}
