package org.example.niuke_top101.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BM101 {
    HashMap<Integer, Integer> key2fqMap;
    HashMap<Integer, LinkedList<Pair>> fq2nodeMap;
    ArrayList<Integer> res;
    int k;

    public static void main(String[] args) {
        int[][] a = {{1, 1, 1}, {1, 2, 2}, {1, 3, 3}, {1, 4, 4}, {2, 4}, {2, 3}, {2, 2}, {2, 1}, {1, 5, 5}, {2, 4}};
        new BM101().LFU(a, 4);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * lfu design
     *
     * @param operators int整型二维数组 ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LFU(int[][] operators, int k) {
        // 键值代表key、频次
        key2fqMap = new HashMap<>();
        fq2nodeMap = new HashMap<>();
        res = new ArrayList<>();
        this.k = k;

        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {   // set操作
                int key = operators[i][1];
                int value = operators[i][2];
                set(key, value);
            } else if (operators[i][0] == 2) { // get操作
                int key = operators[i][1];
                get(key);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void set(int key, int value) {
        if (key2fqMap.containsKey(key)) {   // key值已经存在
            Integer freqKey = key2fqMap.get(key);
            // 删除旧位置的元素
            LinkedList<Pair> list1 = fq2nodeMap.get(freqKey);
            Pair node = null;
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).key == key) {
                    node = list1.get(i);
                    list1.remove(i);
                    break;
                }
            }
            // 新位置添加元素
            if (!fq2nodeMap.containsKey(freqKey + 1)) {
                fq2nodeMap.put(freqKey + 1, new LinkedList<Pair>());
            }
            fq2nodeMap.get(freqKey + 1).add(0, node);
            // 更新key2FqMap表
            key2fqMap.put(key, freqKey + 1);
        } else {    // key值不存在
            if (key2fqMap.size() < k) { // 有剩余空间存放新值
                // 新位置添加元素
                if (!fq2nodeMap.containsKey(1)) {
                    fq2nodeMap.put(1, new LinkedList<Pair>());
                }
                fq2nodeMap.get(1).add(0, new Pair(key, value));
                // 更新Key2FqMap表
                key2fqMap.put(key, 1);
            } else {    // 需要删除旧值存放新值
                // 删除最少最远使用的元素
                int min = Integer.MAX_VALUE;
                for (Integer i : fq2nodeMap.keySet()) {
                    min = min > i && !fq2nodeMap.get(i).isEmpty() ? i : min;
                }
                Pair pair = fq2nodeMap.get(min).removeLast();
                // 新位置添加元素
                fq2nodeMap.get(1).add(0, new Pair(key, value));
                // 更新Key2FqMap表
                key2fqMap.remove(pair.key);
                key2fqMap.put(key, 1);
            }
        }
    }

    public void get(int key) {
        if (!key2fqMap.containsKey(key)) {  // 元素不存在
            res.add(-1);
        } else {    // 元素存在
            Integer freqKey = key2fqMap.get(key);
            // 旧位置删除元素
            LinkedList<Pair> list = fq2nodeMap.get(freqKey);
            Pair node = null;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key == key) {
                    node = list.get(i);
                    list.remove(i);
                    break;
                }
            }
            // 新位置添加元素
            if (!fq2nodeMap.containsKey(freqKey + 1)) {
                fq2nodeMap.put(freqKey + 1, new LinkedList<Pair>());
            }
            fq2nodeMap.get(freqKey + 1).add(0, node);
            // 更新key2FqMap表
            key2fqMap.put(key, freqKey + 1);
            // 记录结果
            res.add(node.value);
        }
    }

    static class Pair {
        int key;
        int value;

        public Pair() {

        }

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    // public int[] LFU(int[][] operators, int k) {
    //     // write code here
    //     HashMap<Integer, Integer> record = new HashMap();
    //     HashMap<Integer, ArrayList<Pair>> listMap = new HashMap();
    //
    //     ArrayList<Integer> res = new ArrayList<>();
    //
    //     for (int i = 0; i < operators.length; i++) {
    //         if (operators[i][0] == 1) {   // set操作
    //             int key = operators[i][1];
    //             int value = operators[i][2];
    //             if (record.containsKey(key)) {  // 是旧元素
    //                 int count = record.get(key);
    //                 record.put(key, count + 1); // 更新record表
    //                 // 更新元素位置
    //                 for (int j = 0; j < listMap.get(count).size(); j++) {   // 删除旧位置的元素
    //                     if (listMap.get(count).get(j).key == key) {
    //                         listMap.get(count).remove(j);
    //                         break;
    //                     }
    //                 }
    //                 // 添加元素到新位置
    //                 if (listMap.containsKey(count + 1)) {
    //                     listMap.get(count + 1).add(0, new Pair(key, value));
    //                 } else {
    //                     ArrayList<Pair> list = new ArrayList<>();
    //                     list.add(0, new Pair(key, value));
    //                     listMap.put(count + 1, list);
    //                 }
    //             } else {    // 是新元素
    //                 if (record.size() < k) {    // 不需要删除元素
    //                     record.put(key, 1);
    //                     if (listMap.containsKey(1)) {   // 不需要新建list存储元素
    //                         listMap.get(1).add(new Pair(key, value));
    //                     } else { // 需要新建list存储元素
    //                         listMap.put(1, new ArrayList<Pair>());
    //                         listMap.get(1).add(0, new Pair(key, value));
    //                     }
    //                 } else {     // 需要删除元素
    //                     record.put(key, 1);
    //
    //                     Set<Integer> keySet = listMap.keySet();
    //                     int min = Integer.MAX_VALUE;
    //                     for (Integer integer : keySet) {
    //                         if (integer < min && listMap.get(integer).size() > 0) {
    //                             min = integer;
    //                         }
    //                     }
    //                     // 删除旧元素
    //                     Pair removeElement = listMap.get(min).get(listMap.get(min).size() - 1);
    //                     listMap.get(min).remove(listMap.get(min).size() - 1);
    //                     record.remove(removeElement.key);
    //                     // 添加新元素
    //                     listMap.get(1).add(0, new Pair(key, value));
    //
    //                     record.remove(removeElement.key);
    //                 }
    //             }
    //
    //
    //         } else if (operators[i][0] == 2) { // get操作
    //             int key = operators[i][1];
    //             if (!record.containsKey(key)) {
    //                 res.add(-1);
    //             } else {
    //                 Integer count = record.get(key);
    //                 ArrayList<Pair> list = listMap.get(count);
    //                 Pair moveElement = null;
    //                 for (int j = 0; j < list.size(); j++) {
    //                     if (list.get(j).key == key) {
    //                         moveElement = list.get(j);
    //                         list.remove(j);
    //                         break;
    //                     }
    //                 }
    //                 if (listMap.containsKey(count + 1)) {
    //                     listMap.get(count + 1).add(0, moveElement);
    //                 } else {
    //                     ArrayList<Pair> list1 = new ArrayList<>();
    //                     list1.add(0, moveElement);
    //                     listMap.put(count + 1, list1);
    //                 }
    //                 record.put(key, count + 1);
    //                 res.add(moveElement.value);
    //             }
    //         }
    //     }
    //
    //     int[] result = new int[res.size()];
    //     for (int i = 0; i < res.size(); i++) {
    //         result[i] = res.get(i);
    //     }
    //     return result;
    //     // return res.stream().mapToInt(Integer::intValue).toArray();
    // }


}
