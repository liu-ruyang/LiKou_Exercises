package org.example.niuke_top101.string;

public class BM86 {
    public static void main(String[] args) {
        new BM86().solve("1", "99");
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();

        int i = ss.length - 1;
        int j = ts.length - 1;

        int high = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int low = (ss[i] - '0' + ts[j] - '0' + high) % 10;
            high = (ss[i] - '0' + ts[j] - '0' + high) / 10;
            res.append(low);
            i--;
            j--;
        }

        while (i >= 0) {
            int low = (ss[i] - '0' + high) % 10;
            high = (ss[i] - '0' + high) / 10;
            res.append(low);
            i--;
        }

        while (j >= 0) {
            int low = (ts[j] - '0' + high) % 10;
            high = (ts[j] - '0' + high) / 10;
            res.append(low);
            j--;
        }

        if (high > 0) {
            res.append(high);
        }

        return res.reverse().toString();
    }
}
