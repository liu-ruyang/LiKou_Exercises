package org.example.hot100.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Question763 {
    public static void main(String[] args) {
        new Question763().partitionLabels("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                int[] tem = {i, i};
                map.put(chars[i], tem);
            } else {
                map.get(chars[i])[1] = i;
            }
        }

        List<int[]> lists = new ArrayList<>();
        map.forEach((key, value) -> lists.add(value));

        Collections.sort(lists, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<Integer> res = new ArrayList<>();

        int left = lists.get(0)[0];
        int right = lists.get(0)[1];
        for (int i = 1; i < lists.size(); i++) {
            if (lists.get(i)[1] > right && lists.get(i)[0] <= right) {
                right = lists.get(i)[1];
            } else if (lists.get(i)[0] > right) {
                res.add(right - left + 1);
                left = lists.get(i)[0];
                right = lists.get(i)[1];
            } else {
            }
        }
        res.add(right - left + 1);

        return res;
    }
}
