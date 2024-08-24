package org.example.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Question2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            if (!map.containsKey(match[0])) {
                map.put(match[0], 0);
            }
            if (!map.containsKey(match[1])) {
                map.put(match[1], 1);
            } else if (map.containsKey(match[1])) {
                Integer count = map.get(match[1]);
                count++;
                map.put(match[1], count);
            }
        }

        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        map.forEach((key, value) -> {
            if (value == 0) {
                set1.add(key);
            } else if (value == 1) {
                set2.add(key);
            }
        });

        List<List<Integer>> lists = new ArrayList<>();

        lists.add(set1.stream().toList());
        lists.add(set2.stream().toList());
        return lists;
    }

    /**
     * 最终排序结果解释：
     * 根据compareTo结果：
     * 返回 0，即 a-b < 0。说明a小于b，所以两者的顺序是:a, b。
     * 返回 1，即 a-b > 0。说明a大于b，所以两者的顺序是:b, a。
     * 返回-1，即 a-b=0。说明a等于b，所以两个数的顺序是:a, b
     */


}
