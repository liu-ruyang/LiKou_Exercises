package org.example.interview150.array_and_string;

/**
 * KMP算法
 */
public class Question28 {
    public static void main(String[] args) {
        int i = new Question28().strStr("sadbutsad", "sad");
    }

    /**
     * 本程序采用的next是在前缀表的基础上，全部右移，然后第一个位置初始化为-1
     * next[j] 表示的是如果j位置字符不匹配（发生冲突的位置），则继续跟next[j]位置的字符比较；如果退到了j=0,则j=next[j]=-1，则表示没有相等前缀了，需要后移一位重新开始比较
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        // int[] next = getNext(needle);
        //
        // for (int i = 0; i < haystack.length(); i++) {
        //
        // }
        // return haystack.indexOf(needle);
        int[] next = getNext(needle.toCharArray());
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {    // 如果j=-1，说明i位置和模式串第一个字符也不同，需要各自向后移一位，重新开始比较
                i++;
                j++;
                if (j == needle.length()) {
                    return i - needle.length();
                }
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    public int[] getNext(char[] chars) {
        int i = 0, j = -1;
        int[] next = new int[chars.length];
        next[0] = -1;
        while (i < chars.length - 1) {
            if (j == -1 || chars[i] == chars[j]) {      // 如果j=-1，说明i处的字符与第一个字符也不同，需要各自后移一位，重新开始比较
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
