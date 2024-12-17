package org.example.interview150.bit_operation;

public class Question137 {
    /**
     * 原理：答案的第 i 个二进制位就是数组中所有元素的第 i 个二进制位之和除以 3 的余数。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int sum = 0;
            for (int num : nums) {
                num >>= i;
                sum += num & 1; // 得到num的第0位，并加到sum中
            }
            res <<= 1;
            res += sum % 3;
        }
        return res;
    }
}
