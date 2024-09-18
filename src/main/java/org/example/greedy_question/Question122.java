package org.example.greedy_question;

public class Question122 {
    // 局部最优：收集每天的正利润，全局最优：求得最大利润。
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Integer.max(max, max + prices[i] - prices[i - 1]);
        }
        return max;
    }
}
