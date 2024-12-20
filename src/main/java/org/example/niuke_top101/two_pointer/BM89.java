package org.example.niuke_top101.two_pointer;

import java.util.ArrayList;
import java.util.Collections;

public class BM89 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // write code here
        Collections.sort(intervals, (o1, o2) -> {
            return Integer.compare(o1.start, o2.start);
        });

        ArrayList<Interval> res = new ArrayList();
        if (intervals.size() == 0) return res;
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        // 还需要处理最后一个区间
        res.add(new Interval(start, end));
        return res;
    }

    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
