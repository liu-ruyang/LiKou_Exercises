package org.example.interview150.bit_operation;

public class Question67 {
    public String addBinary(String a, String b) {
        if (a.equals("0")) return b;
        if (b.equals("0")) return a;

        int index1 = a.length() - 1;
        int index2 = b.length() - 1;

        StringBuffer res = new StringBuffer();
        int pre = 0;

        while (index1 >= 0 && index2 >= 0) {
            int c1 = a.charAt(index1) - '0';
            int c2 = b.charAt(index2) - '0';

            int cur = (c1 + c2 + pre) % 2;
            res.insert(0, (char) (cur + '0'));
            pre = (c1 + c2 + pre) / 2;
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            int c1 = a.charAt(index1) - '0';
            int cur = (c1 + pre) % 2;
            res.insert(0, (char) (cur + '0'));
            pre = (c1 + pre) / 2;
            index1--;
        }
        while (index2 >= 0) {
            int c2 = b.charAt(index2) - '0';
            int cur = (c2 + pre) % 2;
            res.insert(0, (char) (cur + '0'));
            pre = (c2 + pre) / 2;
            index2--;
        }

        if (pre != 0) res.insert(0, (char) (pre + '0'));

        return res.toString();
    }
}
