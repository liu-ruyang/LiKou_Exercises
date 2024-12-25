package org.example.other;

public class Question168 {
    public static void main(String[] args) {
        new Question168().convertToTitle(52);
        new Question168().convertToTitle(701);
    }

    /**
     * A-Z对应1-25，0（如果出现0，即Z，那么需要将高一位减一）
     *
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            int num = columnNumber % 26;
            res.append((char) ('A' - 1 + (num == 0 ? 26 : num)));
            if (num == 0) {     // 如果是Z，那么当前的columnNumber需要减一，因为有1是由Z得来的
                columnNumber--;
            }
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}
