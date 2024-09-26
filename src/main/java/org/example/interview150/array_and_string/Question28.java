package org.example.interview150.array_and_string;

public class Question28 {
    public int strStr(String haystack, String needle) {
        // int[] next = getNext(needle);
        //
        // for (int i = 0; i < haystack.length(); i++) {
        //
        // }
        return haystack.indexOf(needle);
    }

    int[] getNext(String str) {
        int[] next = new int[str.length()];
        next[1] = 0;

        int i = 1, j = 0;
        while (i < str.length()) {
            if (j == 0 || str.charAt(i) == str.charAt(j))
                next[++i] = ++j;
            else
                j = next[j];    // j回退
        }
        return next;
    }
}
