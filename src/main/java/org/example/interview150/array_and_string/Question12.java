package org.example.interview150.array_and_string;

public class Question12 {
    public static void addChar(StringBuffer buffer, String a, int count) {
        for (int i = 0; i < count; i++) {
            buffer.append(a);
        }
    }

    public String intToRoman(int num) {
        StringBuffer buffer = new StringBuffer();
        addChar(buffer, "M", num / 1000);
        num %= 1000;
        addChar(buffer, "CM", num / 900);
        num %= 900;
        addChar(buffer, "D", num / 500);
        num %= 500;
        addChar(buffer, "CD", num / 400);
        num %= 400;
        addChar(buffer, "C", num / 100);
        num %= 100;
        addChar(buffer, "XC", num / 90);
        num %= 90;
        addChar(buffer, "L", num / 50);
        num %= 50;
        addChar(buffer, "XL", num / 40);
        num %= 40;
        addChar(buffer, "X", num / 10);
        num %= 10;
        addChar(buffer, "IX", num / 9);
        num %= 9;
        addChar(buffer, "V", num / 5);
        num %= 5;
        addChar(buffer, "IV", num / 4);
        num %= 4;
        addChar(buffer, "I", num);
        return buffer.toString();
    }
}
