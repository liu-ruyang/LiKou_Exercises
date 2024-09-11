package org.example.interview150.array_and_string;

public class Question121 {
    public int maxProfit(int[] prices) {
        int lowest = prices[0];

        int max = 0;

        for (int price : prices) {
            if (price < lowest) {
                lowest = price;
            }
            if (price - lowest > max) {
                max = price - lowest;
            }
        }
        return max;
    }
}
