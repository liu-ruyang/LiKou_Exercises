package org.example.interview150.array_and_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question6 {
    public static void main(String[] args) {
        new Question6().convert("PAYPALISHIRING", 3);
    }

    public String convert(String s, int numRows) {
        HashMap<Integer, List> map = new HashMap<>();
        for (int i = 1; i <= numRows; i++) {
            map.put(i, new ArrayList<Character>());
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {
            for (int j = 1; j <= numRows && i < chars.length; j++) {
                map.get(j).add(chars[i]);
                i++;
            }
            for (int j = numRows - 1; j > 1 && i < chars.length; j--) {
                map.get(j).add(chars[i]);
                i++;
            }
        }

        StringBuffer buffer = new StringBuffer();
        map.forEach((a, b) -> {
            for (int i = 0; i < b.size(); i++) {
                buffer.append(b.get(i));
            }
        });
        return buffer.toString();

    }
}
