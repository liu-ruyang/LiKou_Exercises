package org.example.interview150.hash;

import java.util.HashSet;

public class Question202 {
    public static void main(String[] args) {
        new Question202().isHappy(19);
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            set.add(n);
            n = getSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            int num2 = num % 10;
            sum += num2 * num2;
            num /= 10;
        }
        return sum;
    }
}
