package org.example.other;

public class Question43 {
    public static void main(String[] args) {
        new Question43().multiply("9", "9");
    }

    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        int start = res.length - 1;
        for (int i = num2.length() - 1; i >= 0; i--) {
            single_multi(num1, num2.charAt(i), res, start);
            start--;
        }

        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == 0) i++;
        while (i < res.length) {
            builder.append(res[i]);
            i++;
        }
        return builder.length() > 0 ? builder.toString() : "0";
    }

    public void single_multi(String num1, char c, int[] res, int start) {
        int rest = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x1 = c - '0';
            int x2 = num1.charAt(i) - '0';
            int temp = res[start] + x1 * x2 + rest;
            res[start] = temp % 10;
            rest = temp / 10;
            start--;
        }
        // if (rest != 0) {
        //
        // }
        int temp = rest + res[start];
        while (temp != 0) {
            res[start] = temp % 10;
            rest = temp / 10;
            start--;
            if (start < 0) {
                break;
            }
            temp = rest + res[start];
        }
    }
}
