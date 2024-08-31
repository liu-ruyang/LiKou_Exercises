package org.example.other;

public class Question2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (rolls.length + n);
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum < n || sum > 6 * n) {
            int[] results = new int[0];
            return results;
        }

        int base = sum / n;
        int left = sum % n;
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = base;
        }

        if (left == 0) {
            return result;
        } else {
            for (int i = 0; i < left; i++) {
                result[i]++;
            }
            return result;
        }
    }
}
