package org.example.hot100.skills;

public class Question287 {
    public int findDuplicate(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == index + 1) {
                index++;
            } else {
                int index2 = nums[index];
                if (nums[index2 - 1] == index2) {
                    return index2;
                }
                int temp = nums[index2 - 1];
                nums[index2 - 1] = nums[index];
                nums[index] = temp;
            }
        }
        return -1;
    }
}
