package org.example.other;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 本方法超时：解决办法key2fqMap的键值对改为<Integer, Pair>
 */
public class Question460 {
    HashMap<Integer, Integer> key2fqMap;
    HashMap<Integer, LinkedList<Pair>> fq2nodeMap;
    int k;

    public Question460(int capacity) {
        // 键值代表key、频次
        key2fqMap = new HashMap<>();
        fq2nodeMap = new HashMap<>();
        this.k = capacity;
    }

    public static void main(String[] args) {
        Question460 q = new Question460(2);
        q.put(3, 1);
        q.put(2, 1);
        q.put(2, 2);
        q.put(4, 4);
        q.get(2);
    }

    public int get(int key) {
        if (!key2fqMap.containsKey(key)) {  // 元素不存在
            return -1;
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
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (key2fqMap.containsKey(key)) {   // key值已经存在
            Integer freqKey = key2fqMap.get(key);
            // 删除旧位置的元素
            LinkedList<Pair> list1 = fq2nodeMap.get(freqKey);
            Pair node = null;
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).key == key) {
                    node = list1.get(i);
                    node.value = value;
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
}
