package org.example;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Question3 {

    public static void main(String[] args) {
        Question3 question3 = new Question3();
        int maxLength = question3.lengthOfLongestSubstring("dvdf");
        System.out.println(maxLength);
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;

        int[] length = new int[s.length()];
        for (int i = 0; i < length.length; i++) {
            length[i] = 1;
        }
        int maxLength = length[0];


        char[] charArray = s.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            int diffStringLength = getLastCommonCharBefore(s, charArray[i], i - length[i - 1], i);
            if (diffStringLength == length[i - 1]) {
                length[i] += length[i - 1];
                maxLength = maxLength > length[i] ? maxLength : length[i];
            } else {
                length[i] = diffStringLength + 1;
                maxLength = maxLength > length[i] ? maxLength : length[i];
            }

        }
        return maxLength;
    }

    /**
     * @param string     源字符串
     * @param targetChar 查找的字符
     * @param startIndex 源字符串要查找字符范围的起点（包括）
     * @param endIndex   源字符串要查找字符范围的终点（不包括）
     * @return 前一个字符所在的子串中可以与当前字符处在同一个子串中的子串的最大长度
     */
    public int getLastCommonCharBefore(String string, char targetChar, int startIndex, int endIndex) {
        String substring = string.substring(startIndex, endIndex);// beginIndex：指定子串的起始索引位置（包含）,endIndex：指定子串的结束索引位置（不包含）
        int index = substring.indexOf(targetChar);
        return substring.length() - 1 - index;
    }
}
