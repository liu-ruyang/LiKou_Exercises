package org.example.hot100.array;

public class Question41 {
    // 置换：将i处于1~n的数字恢复到对应的下标为i-1位置上
    public int firstMissingPositive(int[] nums) {
        // 置换恢复
        for (int i = 0; i < nums.length; i++) {
            // while循环中判断三个条件：
            // ① 1 <= nums[i] <= nums.length
            // ② nums[i] != i+1
            // ③ nums[i] != nums[nums[i] - 1]   防止出现死循环，由置换的两个数字相等导致的
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    // 优先队列法
//    public int firstMissingPositive(int[] nums) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                heap.add(nums[i]);
//            }
//        }
//        int res = 1;
//        while (!heap.isEmpty() && heap.peek() == res) {
//            Integer poll = heap.poll();
//            if (heap.isEmpty()) return res + 1;
//            if (heap.peek() >= poll + 1) {
//                res++;
//            }
//        }
//        return res;
//    }
}
