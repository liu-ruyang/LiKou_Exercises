package org.example.interview150.array_and_string;

public class Question13 {
    public static void main(String[] args) {
        new Question13().romanToInt("III");
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I' -> {
                    if (i < chars.length - 1 && chars[i + 1] == 'V') {
                        res += 4;
                        i++;
                    } else if (i < chars.length - 1 && chars[i + 1] == 'X') {
                        res += 9;
                        i++;
                    } else
                        res += 1;
                }
                case 'V' -> {
                    res += 5;
                }
                case 'X' -> {
                    if (i < chars.length - 1 && chars[i + 1] == 'L') {
                        res += 40;
                        i++;
                    } else if (i < chars.length - 1 && chars[i + 1] == 'C') {
                        res += 90;
                        i++;
                    } else
                        res += 10;
                }
                case 'L' -> {
                    res += 50;
                }
                case 'C' -> {
                    if (i < chars.length - 1 && chars[i + 1] == 'D') {
                        res += 400;
                        i++;
                    } else if (i < chars.length - 1 && chars[i + 1] == 'M') {
                        res += 900;
                        i++;
                    } else
                        res += 100;
                }
                case 'D' -> {
                    res += 500;
                }
                case 'M' -> {
                    res += 1000;
                }
            }
        }
        return res;
    }
}
