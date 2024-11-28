package org.example.interview150.maths;

/**
 * 判断零的个数，即判断因数中 2-5对 的个数
 * 2的个数一定大于等于5的个数，只需计算5的个数
 * 规律：
 * 每隔5个数出现一次5
 * 每隔5*5个数出现二次5
 * 每隔5*5*5个数出现三次5
 * ……
 * 在计算隔5次数时候，会各包括一次5*5、5*5*5、……的个数，所以按照下面法二的计算方式，可以直接将商直接加到最终结果上
 */
public class Question172 {
    // 法二：时间复杂度O(logn)
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }

    // 法一：时间复杂度O(n*logn)
    // int num_2;
    // int num_5;
    //
    // public static void main(String[] args) {
    //     new Question172().trailingZeroes(3);
    // }
    //
    // public int trailingZeroes(int n) {
    //     if (n == 0 || n == 1) {
    //         return 0;
    //     }
    //     num_2 = 0;
    //     num_5 = 0;
    //     count(n);
    //     return Integer.min(num_2, num_5);
    // }
    //
    // public void count(int n) {
    //     if (n == 2) {
    //         num_2++;
    //         return;
    //     }
    //     int m = n;
    //     while (m % 2 == 0) {
    //         num_2++;
    //         m /= 2;
    //     }
    //     m = n;
    //     while (m % 5 == 0) {
    //         num_5++;
    //         m /= 5;
    //     }
    //     count(n - 1);
    // }
}
