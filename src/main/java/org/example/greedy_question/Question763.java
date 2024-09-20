package org.example.greedy_question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question763 {
    public static void main(String[] args) {
        new Question763().partitionLabels("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {

            map.put(chars[i], i);
        }

        int index = 0;
        int right = map.get(chars[index]);
        int left = -1;
        List result = new ArrayList();
        while (index < chars.length) {
            while (index <= right) {
                right = Integer.max(right, map.get(chars[index]));
                index++;
            }
            result.add(right - left);
            left = right;
            if (index < chars.length)
                right = map.get(chars[index]);
        }
        return result;
    }
}
