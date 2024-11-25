package org.example.interview150.binary_search;

/**
 * 可以通过模拟旋转n次发现，旋转n次的效果就可以视为旋转一次的效果
 * <p>
 * 心得：
 * 结合74题，意识到一点：
 * ① 在和下标mid所在位置值比较时候，先考虑比较right所在值，修改right值
 * （因为使用的整除，mid和left可能一样）
 * ② 最后返回的时候，即right和left不满足left < right时候，使用left
 * （因为right可能出界了）
 * <p>
 * 否则，很容易出现，最后两个数比较的时候，因为整除原因，导致本该选取后一个数的，结果却选取了前一个数（需要在循环判断的时候修改判断条件），导致结果错误
 */
public class Question153 {
    public static void main(String[] args) {
        int[] a = {2, 1};
        // int[] a = {3, 4, 5, 1, 2};
        // int[] a = {2, 3, 4, 5, 1};
        // int[] a = {4, 5, 6, 7, 0, 1, 2};
        new Question153().findMin(a);
    }

    // public int findMin(int[] nums) {
    //     int left = 0, right = nums.length - 1;
    //
    //     while (left < right) {
    //         int mid = (left + right) / 2;
    //         if (nums[mid] < nums[right]) {
    //             right = mid;
    //         } else {
    //             left = mid + 1;
    //         }
    //
    //     }
    //     return nums[left];
    // }
    // 错误
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[mid]) {
                if (nums[mid] < nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid;
            }

        }

        return Math.min(nums[left], nums[right]);
    }
}
