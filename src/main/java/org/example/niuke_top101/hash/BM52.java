package org.example.niuke_top101.hash;

import java.util.HashMap;

public class BM52 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce(int[] nums) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }

        int[] res = new int[2];
        int i = 0;
        for (int key : map.keySet()) {
            res[i++] = key;
        }
        if (res[0] > res[1]) {
            int tmp = res[0];
            res[0] = res[1];
            res[1] = tmp;
        }

        return res;
    }
}
