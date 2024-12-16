package org.example.niuke_top101.heap_and_stack_and_queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 双端队列法：
 * 遍历数组的每一个元素，
 * 如果容器为空，则直接将当前元素加入到容器中。
 * 如果容器不为空，则让当前元素和容器的最后一个元素比较，如果大于，则将容器的最后一个元素删除，然后继续讲当前元素和容器的最后一个元素比较
 * 如果当前元素小于容器的最后一个元素，则直接将当前元素加入到容器的末尾
 * 如果容器头部的元素已经不属于当前窗口的边界，则应该将头部元素删除
 */
public class BM45 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param num  int整型一维数组
     * @param size int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        // write code here
        LinkedList<Integer> deque = new LinkedList();
        ArrayList<Integer> res = new ArrayList();
        if (size == 0 || size > num.length) return res;


        // 每一轮视为处理一个新的元素，在添加新元素前（如果能形成窗口，那么一定是以该元素为终止位置的），做如下判断：
        // 队列中比新元素小的元素，直接弹出（因为每个元素的左边更小的元素不需要维护，迟早是要舍弃的）
        // 新元素添加到队尾
        // 新元素添加之后，在添加队头元素到返回列表中之前，判断当前的队头元素是否需要因为不在新的窗口中而需要弹出
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.getLast()] < num[i]) {
                deque.removeLast();
            }

            deque.add(i);

            // 判断队列的头部的下表是否过期
            if (deque.peek() + size - 1 < i) {
                deque.pop();
            }
            // 判断是否形成了窗口
            if (i + 1 >= size) {
                res.add(num[deque.peek()]);
            }
        }

        return res;
    }
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param num  int整型一维数组
//     * @param size int整型
//     * @return int整型ArrayList
//     */
//    public ArrayList<Integer> maxInWindows(int[] num, int size) {
//        // write code here
//        LinkedList<Integer> queue = new LinkedList();
//        ArrayList<Integer> res = new ArrayList();
//        if (num.length < size || size <= 0) {
//            return res;
//        }
//        int temp = Integer.MIN_VALUE;
//        for (int i = 0; i < size; i++) {
//            temp = Math.max(temp, num[i]);
//            queue.add(num[i]);
//        }
//        res.add(temp);
//
//        for (int i = size; i < num.length; i++) {
//            queue.removeFirst();
//            queue.add(num[i]);
//            temp = Integer.MIN_VALUE;
//            for (int j = 0; j < queue.size(); j++) {
//                temp = Math.max(temp, queue.get(j));
//            }
//            res.add(temp);
//        }
//        return res;

//    }
}
