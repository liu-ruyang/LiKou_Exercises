package org.example.niuke_top101.dp;

public class BM67 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths(int m, int n) {
        // write code here
        int mm = m - 1;
        int nn = n - 1;

        long res = 1;
        long a = 1;
        long b = 1;
        for (int i = 1; i <= Math.min(mm, nn); i++) {
            a *= (mm + nn - i + 1);
            b *= i;
            if (res * a % b == 0) {
                res = res * a / b;
                a = 1;
                b = 1;
            }
        }
        return (int) res;
    }
}
