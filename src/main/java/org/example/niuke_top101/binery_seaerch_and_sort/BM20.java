package org.example.niuke_top101.binery_seaerch_and_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题还推荐使用归并排序的算法，统计结果的过程发生在合并的时候，统计方法如下：
 * 在合并过程，会有一个遍历左右部分的过程，每遍历有部分的一个元素的时候，如果有部分元素比左部分小，那么左部分该元素之后的所有元素都可以和该右部分元素组成一个逆序对
 */
public class BM20 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int InversePairs(int[] nums) {
        // write code here
        List temp = new ArrayList<>(nums.length);

        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if ((int) temp.get(mid) > nums[i]) right = mid - 1;
                if ((int) temp.get(mid) < nums[i]) left = mid + 1;
            }
            if (temp.size() == 0 || (int) temp.get(left) >= nums[i]) {
                temp.add(left, nums[i]);
                res += i - left;
            } else {
                temp.add(left + 1, nums[i]);
                res += i - left - 1;
            }
        }
        return (int) (res % 1000000007);

    }
}
