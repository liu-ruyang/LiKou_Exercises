package org.example.interview150.maths;

public class Question66 {
    public int[] plusOne(int[] digits) {
        int pre = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + pre;
            pre = temp / 10;
            digits[i] = temp % 10;
        }

        if (pre == 0) {
            return digits;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        // 使用System.array复制指定位置的数组到数组的指定位置
        System.arraycopy(digits, 0, res, 1, res.length - 1);
        return res;
    }
}
