package org.example.interview150.multi_dim_dp;

public class Question63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp[0].length && obstacleGrid[0][i] != 1; i++) {
            dp[0][i] = 1;
        }
        for (int j = 0; j < obstacleGrid.length && obstacleGrid[j][0] != 1; j++) {
            dp[j][0] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
