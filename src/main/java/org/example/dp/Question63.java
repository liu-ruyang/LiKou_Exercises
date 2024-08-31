package org.example.dp;

public class Question63 {

    public static void main(String[] args) {
        // int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] a = {{1}};
        new Question63().uniquePathsWithObstacles(a);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len = obstacleGrid.length;
        int len2 = obstacleGrid[0].length;
        // if (len == len2 && len == 1)
        //     return 0;
        int[][] dp = new int[len][len2];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i < len2; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            } else
                dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i < len; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else
                dp[i][0] = dp[i - 1][0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len2; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[len - 1][len2 - 1];
    }
}
