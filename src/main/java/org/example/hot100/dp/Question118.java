package org.example.hot100.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) { // 逐行遍历
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {   // 逐个生成
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }

        return res;
    }
}
