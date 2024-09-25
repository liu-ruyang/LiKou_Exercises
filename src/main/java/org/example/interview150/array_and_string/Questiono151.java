package org.example.interview150.array_and_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Questiono151 {
    public String reverseWords(String s) {
        List<String> split = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(split);
        return String.join(" ", split);
    }

}
