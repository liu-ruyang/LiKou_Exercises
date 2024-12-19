package org.example.niuke_top101.dp;

import java.util.ArrayList;

public class BM74 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> res = new ArrayList();
        StringBuilder str = new StringBuilder();

        recResolve(s, res, str, 0, 0);
        return res;
    }

    public void recResolve(String s, ArrayList<String> res, StringBuilder str,
                           int startIndex, int count) {
        String ss = str.toString();
        if (count == 4 && ss.replace(".", "").length() == s.length()) {
            res.add(str.substring(1, str.length()));
            return;
        } else if (count == 4) return;
        else if (ss.replace(".", "").length() == s.length()) return;

        if (startIndex <= s.length() - 3 && s.charAt(startIndex) != '0') {
            if (Integer.valueOf(s.substring(startIndex, startIndex + 3)) <= 255) {
                str.append("." + s.substring(startIndex, startIndex + 3));
                recResolve(s, res, str, startIndex + 3, count + 1);
                str.delete(str.length() - ("." + s.substring(startIndex,
                        startIndex + 3)).length(), str.length());
            }
            str.append("." + s.substring(startIndex, startIndex + 2));
            recResolve(s, res, str, startIndex + 2, count + 1);
            str.delete(str.length() - ("." + s.substring(startIndex,
                    startIndex + 2)).length(), str.length());

            str.append("." + s.charAt(startIndex));
            recResolve(s, res, str, startIndex + 1, count + 1);
            str.delete(str.length() - ("." + s.charAt(startIndex
            )).length(), str.length());

        } else if (startIndex <= s.length() - 2 && s.charAt(startIndex) != '0') {
            str.append("." + s.substring(startIndex, startIndex + 2));
            recResolve(s, res, str, startIndex + 2, count + 1);
            str.delete(str.length() - ("." + s.substring(startIndex,
                    startIndex + 2)).length(), str.length());

            str.append("." + s.charAt(startIndex));
            recResolve(s, res, str, startIndex + 1, count + 1);
            str.delete(str.length() - ("." + s.charAt(startIndex
            )).length(), str.length());

        } else if (startIndex <= s.length() - 1) {
            str.append("." + s.charAt(startIndex));
            recResolve(s, res, str, startIndex + 1, count + 1);
            str.delete(str.length() - ("." + s.charAt(startIndex
            )).length(), str.length());
        }
    }
}
