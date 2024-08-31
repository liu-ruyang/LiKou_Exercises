package org.example.other;

public class Question2928 {

    public static void main(String[] args) {
        new Question2928().distributeCandies(3, 3);
    }

    public int distributeCandies(int n, int limit) {
        int count = 0;
        for (int i = Integer.max(0, n - 2 * limit); i <= limit; i++) {
            for (int j = Integer.max(0, n - i - limit); j <= Integer.min(n - i, limit); j++) {
                count++;
            }
        }
        return count;
    }
}
