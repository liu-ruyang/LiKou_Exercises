package org.example.interview150.bit_operation;

public class Question136 {
    /**
     * n^0s = n     n和全0异或得到n本身
     * n^1s = ~n    n和全1异或得到n的非
     * n^n = 0      n和n自身异或得到0
     * <p>
     * 异或的性质：
     * ‌交换律‌：a⊕b=b⊕a。
     * ‌结合律‌：(a⊕b)⊕c=a⊕(b⊕c)。
     * ‌自反性‌：a⊕a=0，任何数与0异或的结果是其本身。
     * ‌恒等性‌：a⊕0=a。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
