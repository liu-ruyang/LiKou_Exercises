package org.example.interview150.array_and_string;

import java.util.*;

/**
 * 变长数组（ArrayList）+哈希表
 * 变长数组可以随机获取元素，可以根据下标获取元素，但无法随机判断元素是否存在，无法随机插入和删除
 * 哈希表可以随机获取元素，可以随机判断元素是否存在，可以随机插入和删除，但无法根据下标定位到特定元素
 */
public class Question380 {
    class RandomizedSet {
        Map map;
        List<Integer> list;

        public RandomizedSet() {
            map = new HashMap<Integer, Integer>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                list.add(val);
                map.put(val, list.size() - 1);
                return true;
            }
            return false;
        }

        /**
         * 删除逻辑：
         * 从哈希表中获得 val 的下标 index；
         * 将变长数组的最后一个元素 last 移动到下标 index 处，在哈希表中将 last 的下标更新为 index；
         * 在变长数组中删除最后一个元素，在哈希表中删除 val；
         * 返回 true
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int index = (int) map.get(val);
                Integer num = list.get(list.size() - 1);
                map.put(num, index);
                list.set(index, num);
                list.remove(list.size() - 1);
                map.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            int index = new Random().nextInt(list.size());
            return list.get(index);
        }
    }
}
