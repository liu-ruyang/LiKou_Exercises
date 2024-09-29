package org.example.interview150.two_pointers;

public class Question167 {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        new Question167().twoSum(a, 9);
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 1;
        int right = numbers.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                res[0] = numbers[left];
                res[1] = numbers[left];
                return res;
            }
        }
        return res;
    }
}
