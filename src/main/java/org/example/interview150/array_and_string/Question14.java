package org.example.interview150.array_and_string;

import java.util.Arrays;

public class Question14 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a, b) -> a.length() - b.length());

        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {
            for (int j = result.length(); j >= 0; j--) {
                if (result.substring(0, j).equals(strs[i].substring(0, j))) {
                    result = result.substring(0, j);
                    if (result.length() == 0) {
                        return "";
                    }
                    break;
                }
            }
        }

        return result;
    }
}
