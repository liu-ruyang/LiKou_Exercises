package org.example;

import java.util.TreeMap;

public class Question575 {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3};
        new Question575().distributeCandies(a);
    }

    public int distributeCandies(int[] candyType) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int count = 0;
        int limit = candyType.length / 2;
        for (int type : candyType) {
            if (!map.containsKey(type)) {
                map.put(type, 1);
                count++;
                if (count >= limit) {
                    return limit;
                }
            }
        }

        return count;
        // for (int type : candyType) {
        //     if (map.containsKey(type)) {
        //         Integer count = map.get(type);
        //         map.put(type, count + 1);
        //     } else {
        //         map.put(type, 1);
        //     }
        // }
        //
        // int left = candyType.length / 2;
        // int count = 0;
        // List<Integer> values = map.values().stream().toList();
        // while (left > 0) {
        //     left -= values.get(count);
        //     count++;
        // }
        // return count;

    }
}
