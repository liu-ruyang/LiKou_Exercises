package org.example.interview150.array_and_string;

public class Question238 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        new Question238().productExceptSelf(a);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] * dp[i - 1];
        }

        int[] dp2 = new int[nums.length];
        for (int i = 0; i < dp2.length; i++) {
            dp2[i] = 1;
        }
        dp2[dp2.length - 1] = nums[nums.length - 1];
        for (int i = dp2.length - 2; i >= 0; i--) {
            dp2[i] = nums[i] * dp2[i + 1];
        }

        int[] answer = new int[nums.length];
        answer[0] = dp2[1];
        answer[nums.length - 1] = dp[nums.length - 2];
        for (int i = 1; i < answer.length - 1; i++) {
            answer[i] = dp[i - 1] * dp2[i + 1];
        }
        return answer;
    }

    public int[] productExceptSelf2(int[] nums) {

        boolean[][] flag = new boolean[nums.length][nums.length];
        int[][] record = new int[nums.length][nums.length];

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = getProduct(nums, flag, record, 0, i - 1) * getProduct(nums, flag, record, i + 1, nums.length - 1);
        }
        return answer;
    }

    public int getProduct(int[] nums, boolean[][] flag, int[][] record, int left, int right) {
        if (right < 0 || left >= nums.length) {
            return 1;
        }
        if (flag[left][right]) {
            return record[left][right];
        }
        if (left >= right) {
            flag[left][right] = true;
            record[left][right] = nums[left];
            return nums[left];
        }

        int mid = (left + right) / 2;
        int leftProduct = getProduct(nums, flag, record, left, mid > left ? mid - 1 : mid);
        int rightProduct = getProduct(nums, flag, record, mid < right ? mid + 1 : mid, right);
        int result = mid > left ? leftProduct * nums[mid] * rightProduct : leftProduct * rightProduct;

        flag[left][right] = true;
        record[left][right] = result;

        return result;
    }
}
