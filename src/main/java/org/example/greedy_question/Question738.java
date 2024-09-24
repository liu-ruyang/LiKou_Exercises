package org.example.greedy_question;

import java.util.ArrayList;

public class Question738 {
    // public int monotoneIncreasingDigits(int n) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     while (n != 0) {
    //         list.add(n % 10);
    //         n /= 10;
    //     }
    //
    //     int result = list.get(0);
    //     int times = 10;
    //
    //     if (list.get(0) >= list.size()) {
    //         for (int i = 1; i < list.size(); i++) {
    //             result += Integer.min(list.get(i - 1), list.get(i)) * times;
    //             times *= 10;
    //         }
    //         return result;
    //     } else {
    //         result = 9;
    //         for (int i = 1; i < list.size() - 1; i++) {
    //             result += 9 * times;
    //             times *= 10;
    //         }
    //         result += (list.get(list.size() - 1) - 1) * times;
    //         return result;
    //     }
    // }
    public static void main(String[] args) {
        int result = new Question738().monotoneIncreasingDigits(100);
        System.out.println(result);
    }

    // public int monotoneIncreasingDigits(int n) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     while (n != 0) {
    //         list.add(n % 10);
    //         n /= 10;
    //     }
    //
    //     for (int i = 0; i < list.size() - 1; i++) {
    //         if (list.get(i + 1) > list.get(i)) {
    //             list.set(i, 9);
    //             list.set(i + 1, list.get(i + 1) - 1);
    //         }
    //     }
    //
    //     int result = 0;
    //     int times = 1;
    //     for (int i = 0; i < list.size(); i++) {
    //         // if (list.get(i) > 0) {
    //         result += list.get(i) * times;
    //         times *= 10;
    //         // }
    //     }
    //
    //     return result;
    // }
    public int monotoneIncreasingDigits(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }

        int flag = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) > list.get(i)) {
                flag = i;
                list.set(i + 1, list.get(i + 1) - 1);
            }
        }

        for (int i = 0; i <= flag; i++) {
            list.set(i, 9);
        }

        int result = 0;
        int times = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                result += list.get(i) * times;
                times *= 10;
            }
        }

        return result;
    }
}
