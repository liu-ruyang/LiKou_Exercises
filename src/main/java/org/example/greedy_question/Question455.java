package org.example.greedy_question;

import java.util.Arrays;

public class Question455 {
    public int findContentChildren(int[] g, int[] s) {
        // 默认是升序排序
        // 若想要降序排序：先转换为对象类型Integer数组，再结合Arrays和Comparator
        Arrays.sort(g);
        Arrays.sort(s);

        int max = 0;

        int i = g.length - 1;
        int j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                max++;
                j--;
                i--;
            } else {
                i--;
            }
        }
        return max;

    }
}
