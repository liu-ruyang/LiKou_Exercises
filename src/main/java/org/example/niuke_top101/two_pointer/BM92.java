package org.example.niuke_top101.two_pointer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class BM92 {
    public static void main(String[] args) {
        int[] a = {2, 2, 3, 4, 8, 99, 3};
        new BM92().maxLength(a);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        if (arr.length == 0) return 0;
        int left = 0;
        int right = 1;
        HashMap<Integer, Integer> map = new HashMap();
        int res = 1;
        map.put(arr[0], 0);
        while (right < arr.length) {
            if (map.containsKey(arr[right])) {
                // res = Math.max(res, right - left);
                res = Math.max(res, map.size());
                left = map.get(arr[right]) + 1;
                Set<Integer> set = map.keySet();
                // for (int index : set) {
                //     if (map.get(index) < left) {
                //         // 在遍历 map.keySet() 时直接修改 map（删除元素）可能会导致 ConcurrentModificationException 异常
                //         // 因为 map.keySet() 返回的是 map 的键集，而当你在遍历过程中修改 map（删除元素）时，map 的结构发生了变化，导致 set 迭代器的状态不再有效
                //         map.remove(index);
                //     }
                // }
                // Iterator 并不是在集合的基础上复制了一份，而是和集合直接关联。当你通过 Iterator 遍历集合时，Iterator 会跟踪集合的结构修改（modification count）。
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    int index = iterator.next();
                    if (map.get(index) < left) {
                        iterator.remove(); // 使用迭代器的remove方法删除元素
                    }
                }
            }
            map.put(arr[right], right);
            right++;
        }
        res = Math.max(res, map.size());
        return res;
    }
}
