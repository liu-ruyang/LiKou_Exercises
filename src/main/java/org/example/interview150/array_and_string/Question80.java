package org.example.interview150.array_and_string;

public class Question80 {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        new Question80().removeDuplicates(a);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 2, j = 2;
        while (j < nums.length) {
            if (nums[i - 2] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
