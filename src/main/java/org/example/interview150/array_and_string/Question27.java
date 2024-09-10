package org.example.interview150.array_and_string;

public class Question27 {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 2, 3, 0, 4, 2};
        new Question27().removeElement(a, 2);
    }

    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
