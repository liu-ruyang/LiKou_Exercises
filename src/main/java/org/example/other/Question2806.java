package org.example.other;

public class Question2806 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int num = purchaseAmount % 10;
        if (num < 5) {
            return 100 - purchaseAmount / 10 * 10;
        }
        int num2 = 100 - purchaseAmount;
        return (100 - purchaseAmount) / 10 * 10;
    }
}
