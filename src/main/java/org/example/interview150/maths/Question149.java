package org.example.interview150.maths;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 将两点之间的连线都记录下来，没遇到一条新线，就添加，遇到一条已经遇过的线就更新
 * 可以使用两层的HashMap加一层HashSet记录已经记录张的直线
 * 同时不要忘记斜率不存在的情况，单独使用一个HashMap进行记录
 */
public class Question149 {
    public int maxPoints(int[][] points) {
        // 前两个Integer分别代表k和b（一次函数表达式中的y = kx + b）
        HashMap map = new HashMap<Double, HashMap<Double, HashSet<Integer[]>>>();
        // 还要记录斜率不存在的情况
        HashMap<Integer, Integer> nokMap = new HashMap<>();

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length && i != j; j++) {
                if (points[i][0] != points[j][0]) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    double k = (y2 - y1) * 1.0 / (x2 - x1);
                    double b = (x1 * y2 - x2 * y1) * 1.0 / (x1 - x2);
                    if (map.containsKey(k)) {     // 已经存在改斜率k
                        Map map2 = (Map) map.get(k);
                        if (map2.containsKey(b)) {  // k斜率条件下，已经存在该b
                            Set set = (Set) map2.get(b);
                            set.add(points[i]);
                            set.add(points[j]);
                            res = Integer.max(res, set.size());
                        } else {    // k斜率条件下，不存在该b
                            Set set = new HashSet<Integer[]>();
                            set.add(points[i]);
                            set.add(points[j]);
                            map2.put(b, set);
                            res = Integer.max(res, set.size());
                        }
                    } else {    // 不存在该斜率k
                        Map map2 = new HashMap<Double, HashSet>();
                        map.put(k, map2);
                        Set set = new HashSet<Integer[]>();
                        set.add(points[i]);
                        set.add(points[j]);
                        map2.put(b, set);
                        res = Integer.max(res, set.size());
                    }

                }
            }
            if (nokMap.containsKey(points[i][0])) {
                nokMap.put(points[i][0], nokMap.get(points[i][0]) + 1);
            } else {
                nokMap.put(points[i][0], 1);
            }
            res = Integer.max(res, nokMap.get(points[i][0]));
        }
        return res;
    }
}
