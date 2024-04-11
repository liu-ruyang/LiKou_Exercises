package org.example;

public class Bag01Question {

    // 编程优化：本次变成有个缺点，没有将w和p数组的初始化大小设置为实际数值数+1；设置成实际数值数+1可以减少很多地方的下标-1操作
    public static void main(String[] args) {
        // 二维数组的行数和列数都要比实际的+1
        int dp[][] = new int[8][17];
        // 初始化：dp二维数组的第一行和第一列都初始化为0
        for (int i = 0; i < 8; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < 17; i++) {
            dp[0][i] = 0;
        }

        int w[] = {2, 3, 5, 7, 1, 4, 1};
        int p[] = {10, 5, 15, 7, 6, 18, 3};

        int maxValue = calculate(w, p, dp);
        System.out.println("最大收益为：" + maxValue);
        System.out.print("方案：");
        print(w, p, dp, dp.length - 1, dp[0].length - 1);

    }

    // 思路：先通过遍历dp二维数组，计算出最大收益
    // f[i][j] 集合：为只从前i个物品中选且价值总和<=j的所有选法
    // 状态转移方程：f[i][j]=max(f[i-1][j], f[i-1][j-v[i]]+w[i])
    public static int calculate(int w[], int p[], int dp[][]) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int oldSum = dp[i - 1][j];
                int newSum = oldSum;
                if (w[i - 1] < j)
                    newSum = dp[i - 1][j - w[i - 1]] + p[i - 1];
                dp[i][j] = oldSum > newSum ? oldSum : newSum;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    // 思路：根据最大收益值和计算出来的dp二维数组，使用回溯法，计算出具体的拿取方案
    public static void print(int w[], int p[], int dp[][], int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (dp[i][j] == dp[i - 1][j]) {
            print(w, p, dp, i - 1, j);
        } else {
            print(w, p, dp, i - 1, j - w[i - 1]);
            System.out.print("\t" + i);
        }
    }
}
