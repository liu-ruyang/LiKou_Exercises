package org.example.interview150.maths;

/**
 * 在java中，int类型值范围是 [-2147483648, 2147483647]，int类型表示不了 2147483648
 */
public class Question50 {
    public static void main(String[] args) {
        new Question50().myPow(2, -2);
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (n == 0) {
            return 1;
        }

        long n2 = n;
        double res = dfs(Math.abs(x), Math.abs(n2));
        if (x < 0 && n % 2 != 0) {
            res = -res;
        }
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }

    public double dfs(double x, long n) {
        if (n == 1) {
            return x;
        }
        long m = n / 2;
        double res = dfs(x, m);
        if (m * 2 == n) {
            return res * res;
        } else {
            return res * res * x;
        }
    }
}
