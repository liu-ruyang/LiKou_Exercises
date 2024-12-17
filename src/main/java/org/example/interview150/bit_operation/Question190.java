package org.example.interview150.bit_operation;

public class Question190 {
    public static void main(String[] args) {
        new Question190().reverseBits(43261596);
        new Question190().reverseBits(-3);
        new Question190().reverseBits(-4);
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = n & 1;        // 得到第0位
            res <<= 1;              // 左移一位
            res += tmp;             // 新的到第0位的加到res中
            n = n >> 1;             // n右移一位
        }
        return res;
    }

    // jdk源码解法
    // private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    // private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    // private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    // private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111
    // public int reverseBits(int n) {
    //     n = n >>> 1 & M1 | (n & M1) << 1;
    //     n = n >>> 2 & M2 | (n & M2) << 2;
    //     n = n >>> 4 & M4 | (n & M4) << 4;
    //     n = n >>> 8 & M8 | (n & M8) << 8;
    //     return n >>> 16 | n << 16;
    // }
}
