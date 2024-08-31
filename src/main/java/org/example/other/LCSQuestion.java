package org.example.other;


/**
 * 最长公共字串：需要连续
 * 最长公共子序列：不一定要连续
 */
public class LCSQuestion {


    public static void main(String[] args) {

        String a = "xzyzzyx";
        String b = "zxyyzxz";

        int aLen = a.length();
        int bLen = b.length();

        int[][] c = new int[aLen + 1][bLen + 1];
        int maxValue = 0;
        int maxX = 0, maxY = 0;

        for (int i = 0; i < aLen + 1; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < bLen + 1; j++) {
            c[0][j] = 0;
        }

        String lcsString = LCS(a, b, c, maxValue, maxX, maxY);
        System.out.println(lcsString);
    }

    // LCS算法思想计算最长公共字串
    // 本质思想都是使用动态规划的思想，转移方程类似，最长公共字串是最长公共子序列的特殊情况，所以最长公共字串的代码写起来稍微简单一点
    // 区别在于：最长公共字串可以先使用for循环得到矩阵，最长公共子序列需要使用递归的方法只得到有用的部分矩阵
    public static String LCS(String a, String b, int[][] c, int maxValue, int maxX, int maxY) {

        for (int i = 1; i < c.length; i++) {
            for (int j = 1; j < c[i].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    if (c[i][j] > maxValue) {
                        maxValue = c[i][j];
                        maxX = i;
                        maxY = j;
                    }
                } else {
                    c[i][j] = 0;
                }
            }
        }

        // 根据计算结果，写出最长公共子串
        StringBuffer longestString = new StringBuffer();
        if (maxX != 0) {
            while (c[maxX][maxY] != 0) {
                longestString.append(a.charAt(maxX - 1));
                maxX--;
                maxY--;
            }
        }
        return longestString.reverse().toString();
    }
}
