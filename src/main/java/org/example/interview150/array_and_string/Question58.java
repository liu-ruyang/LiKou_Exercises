package org.example.interview150.array_and_string;

public class Question58 {
    // public int lengthOfLastWord2(String s) {
    //     if (s.equals(""))
    //         return 0;
    //     String[] split = s.split(" ");
    //     return split[split.length - 1].length();
    // }

    public int lengthOfLastWord(String s) {
        int right = -1;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (right == -1 && s.charAt(i) != ' ') {
                right = i;
            }
            if (right != -1 && s.charAt(i) == ' ') {
                res = right - i;
                break;
            }
            if (right != -1 && i == 0) {
                res = right - i + 1;
                break;
            }
        }
        return res;
    }
}
