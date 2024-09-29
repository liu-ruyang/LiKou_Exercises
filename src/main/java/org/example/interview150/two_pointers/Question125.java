package org.example.interview150.two_pointers;

public class Question125 {
    public static void main(String[] args) {
        new Question125().isPalindrome("0P");
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while (left < right) {
            if (!((s.charAt(left) <= 'z' && s.charAt(left) >= 'a') || s.charAt(left) <= '9' && s.charAt(left) >= '0')) {
                left++;
            } else if (!((s.charAt(right) <= 'z' && s.charAt(right) >= 'a') || s.charAt(right) <= '9' && s.charAt(right) >= '0')) {
                right--;
            } else if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
