package org.example.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question2981 {

    public static void main(String[] args) {
        new Question2981().maximumLength("ceeeeeeeeeeeebmmmfffeeeeeeeeeeeewww");
        new Question2981().maximumLength("acc");
        new Question2981().maximumLength("abcaba");
        new Question2981().maximumLength("aaaa");
        new Question2981().maximumLength("akphhppppp");
    }

    public int maximumLength(String s) {
        HashMap<Character, List> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (map.containsKey(chars[i])) {
                List<Integer> list = map.get(chars[i]);
                boolean flag = chars[i] == chars[i - 1];
                int temp = flag ? list.get(0) : 0;
                do {
                    temp++;
                    // if (temp >= list.get(0)) {
                    //     list.set(2, list.get(1));
                    //     list.set(1, list.get(0));
                    //     list.set(0, temp);
                    //
                    // } else if (temp >= list.get(1)) {
                    //     list.set(2, list.get(1));
                    //     list.set(1, temp);
                    // } else if (temp >= list.get(2)) {
                    //     list.set(2, temp);
                    // }
                    i++;

                } while (i < chars.length && chars[i] == chars[i - 1]);

                i--;

                if (temp >= list.get(0) && flag) {
                    // list.set(2, list.get(1));
                    // list.set(1, list.get(0));
                    list.set(0, temp);

                } else if (temp >= list.get(1) && flag) {
                    // list.set(2, list.get(1));
                    list.set(1, temp);
                } else if (temp >= list.get(2) && flag) {
                    list.set(2, temp);
                } else if (temp >= list.get(0)) {
                    list.set(2, list.get(1));
                    list.set(1, list.get(0));
                    list.set(0, temp);

                } else if (temp >= list.get(1)) {
                    list.set(2, list.get(1));
                    list.set(1, temp);
                } else if (temp >= list.get(2)) {
                    list.set(2, temp);
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(0);
                list.add(0);
                map.put(chars[i], list);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);

        map.forEach((key, list) -> {


            int maxTemp = Integer.max(Integer.max((Integer) list.get(0) - 2, Integer.min(((Integer) list.get(0) - 1), (Integer) list.get(1))), (Integer) list.get(2));
            result.set(0, Integer.max(result.get(0), maxTemp));
        });

        if (result.get(0) <= 0) {
            return -1;
        }
        return result.get(0);

    }
}
