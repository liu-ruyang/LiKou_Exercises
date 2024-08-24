package org.example.other;

public class Question2938 {
    // public long minimumSteps(String s) {
    //     char[] chars = s.toCharArray();
    //     long result = 0;
    //     int left = 0;
    //     for (int i = 0; i < chars.length; i++) {
    //         if (chars[i] == '0') {
    //             result += i - left;
    //             left++;
    //         }
    //     }
    //     return result;
    // }

    public long minimumSteps(String s) {
        // char[] chars = s.toCharArray();
        long result = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                result += i - left;
                left++;
            }
        }
        return result;
    }
}
