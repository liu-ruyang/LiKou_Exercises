package org.example.other;

/**
 * 差分数组性质：
 * 计算d数组：在给区间[l,r]的元素加上k时，只需要将差分数组d[l]+=k，d[r+1]-=k即可
 * 对d数组求前缀和，即可得到对区间[l,r]的元素加上k的结果
 * <p>
 * 把 [l,r] 中的元素都减一，最终数组中的所有元素是否都 ≤0？
 */

public class Question3355 {
    public static void main(String[] args) {
        int[] a = {1, 0, 1};
        int[][] b = {{0, 2}};
        new Question3355().isZeroArray(a, b);
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        // 1.构造差分数组d[]
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i] - nums[i - 1];
        }

        for (int[] query : queries) {
            nums[query[0]]--;
            if (query[1] + 1 < nums.length) {
                nums[query[1] + 1]++;
            }
        }

        // 2.计算前缀和
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > 0)
                    return false;
            } else {
                nums[i] = nums[i - 1] + nums[i];
                if (nums[i] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
