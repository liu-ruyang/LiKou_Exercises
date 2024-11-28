package org.example.interview150.maths;

public class Question9 {
    public boolean isPalindrome(int x) {
        String num = "" + x;
        int left = 0;
        int right = num.length() - 1;

        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
