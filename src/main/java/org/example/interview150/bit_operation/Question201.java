package org.example.interview150.bit_operation;

public class Question201 {
    public static void main(String[] args) {
        new Question201().rangeBitwiseAnd(1, 2147483647);
        new Question201().rangeBitwiseAnd(5, 7);
    }

    public int rangeBitwiseAnd(int left, int right) {
        // int num = left + 1;
        // int res = left;
        // while (num <= right) {
        //     res &= num;
        //     num++;
        // }
        // return res;

        // if (((right - left + 1) & 1) == 1) {
        //     // 共有奇数个数字
        //     int mid = (left + right) >> 1;
        //     return left & right & mid;
        // } else {
        //     // 共有偶数个数字
        //     return left & right;
        // }

        // 最终转换为只要寻找到left和right的二进制字符串的最长公共前缀，然后用位运算左移即可
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return left << count;
    }
}
