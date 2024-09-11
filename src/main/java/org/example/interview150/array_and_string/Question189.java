package org.example.interview150.array_and_string;

public class Question189 {
    public void rotate(int[] nums, int k) {
        int distance = k % nums.length;
        if (distance == 0)
            return;
        int leftEndIndex = distance - 1;

        reverseStartEnd(nums, 0, nums.length - 1);
        reverseStartEnd(nums, 0, leftEndIndex);
        reverseStartEnd(nums, leftEndIndex + 1, nums.length - 1);
    }

    public void reverseStartEnd(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = nums[endIndex];
            nums[endIndex] = nums[startIndex];
            nums[startIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
