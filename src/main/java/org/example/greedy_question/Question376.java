package org.example.greedy_question;

public class Question376 {
    public static void main(String[] args) {
        int[] a = {51, 226, 208, 165, 202, 286, 190, 212, 219, 271, 36, 245, 20, 238, 238, 89, 105, 66, 73, 9, 254, 206, 221, 237, 203, 33, 249, 253, 150, 102, 57, 249, 203, 10, 123, 178, 85, 203, 35, 276, 129, 116, 37, 163, 99, 142, 187, 249, 134, 77, 217, 298, 29, 127, 174, 115, 122, 178, 12, 80, 122, 76, 16, 41, 115, 84, 104, 121, 127, 40, 287, 129, 9, 172, 112, 51, 40, 135, 205, 53, 259, 196, 248, 5, 123, 184, 209, 130, 271, 42, 18, 143, 24, 101, 10, 273, 252, 50, 173, 80, 119, 129, 45, 257, 299, 78, 278, 78, 190, 215, 284, 129, 200, 232, 103, 97, 167, 120, 49, 298, 141, 146, 154, 233, 214, 196, 244, 50, 110, 48, 152, 82, 226, 26, 254, 276, 292, 286, 215, 56, 128, 122, 82, 241, 222, 12, 272, 192, 224, 136, 116, 70, 39, 207, 295, 49, 194, 90, 210, 123, 271, 18, 276, 87, 177, 240, 276, 33, 155, 200, 51, 6, 212, 36, 149, 202, 48, 114, 58, 91, 83, 221, 175, 148, 278, 300, 284, 86, 191, 95, 77, 215, 113, 257, 153, 135, 217, 76, 85, 269, 126, 194, 199, 195, 20, 204, 194, 50, 220, 228, 90, 221, 256, 87, 157, 246, 74, 156, 9, 196, 16, 259, 234, 79, 31, 206, 148, 12, 223, 151, 96, 229, 165, 9, 144, 26, 255, 201, 33, 89, 145, 155, 1, 204, 37, 107, 80, 212, 88, 186, 254, 9, 158, 180, 24, 45, 158, 100, 52, 131, 71, 174, 229, 236, 296, 299, 184, 168, 41, 45, 76, 68, 122, 85, 292, 238, 293, 179, 143, 128, 47, 87, 267, 53, 187, 76, 292, 0, 160, 70, 172, 292, 9, 64, 156, 153, 26, 145, 196, 222};
        new Question376().wiggleMaxLength(a);
    }

    // 情况一：上下坡中有平坡
    // 情况二：数组首尾两端
    // 情况三：单调坡中有平坡
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int curDiff = 0; // 当前一对差值
        int preDiff = 0; // 前一对差值
        int result = 1;  // 记录峰值个数，序列默认序列最右边有一个峰值

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];

            if (preDiff <= 0 && curDiff > 0 || preDiff >= 0 && curDiff < 0) {
                result++;
                preDiff = curDiff;// 注意这里，只在摆动变化的时候更新prediff
            }
        }
        return result;
    }

    public int wiggleMaxLengt3(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int curDiff = 0; // 当前一对差值
        int preDiff = 0; // 前一对差值
        int result = 1;  // 记录峰值个数，序列默认序列最右边有一个峰值

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if (curDiff > 0 && preDiff < 0 || curDiff < 0 && preDiff > 0) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int maxLength = 0;
        int len = 1;
        if (nums[0] == nums[1]) {
            maxLength = 1;
            len = 1;
        } else if (nums[0] != nums[1]) {
            maxLength = 2;
            len = 2;
        }


        int pre = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 0) {
                len = 1;
            } else {
                if (pre == 0) {
                    len = 2;
                }

                if (pre * (nums[i] - nums[i - 1]) < 0) {
                    len++;
                }

                maxLength = len > maxLength ? len : maxLength;
            }
            pre = nums[i] - nums[i - 1];
        }

        return maxLength;
    }
}
