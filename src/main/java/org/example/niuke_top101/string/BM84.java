package org.example.niuke_top101.string;

public class BM84 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix(String[] strs) {
        // write code here
        if (strs.length == 0) return "";
        for (int i = strs[0].length(); i > 0; i--) {
            int count = 0;
            String subStr = strs[0].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].contains(subStr)) {
                    count++;
                }
            }

            if (count == strs.length) {
                return subStr;
            }
        }
        return "";
    }
}
