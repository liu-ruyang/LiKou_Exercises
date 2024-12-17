package org.example.interview150.bit_operation;

public class Question191 {
    /**
     * n&(n-1)可以去掉n中的最低位
     * n&(-n) 可以获取n中的最低位
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;     // 去掉n中的最低位
            res++;
        }
        return res;
    }
}
