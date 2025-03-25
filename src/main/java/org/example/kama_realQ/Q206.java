package org.example.kama_realQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q206 {
    // public static void main(String[] args) throws IOException {
    //     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //     int n = Integer.parseInt(reader.readLine());
    //     int[] record = new int[n + 1];
    //     int res = 0;
    //     int i = 0;
    //     for (String s : reader.readLine().split(" ")) {
    //         record[i++] = Integer.parseInt(s);
    //     }
    //     record[i] = record[0];
    //
    //     for (int j = 0; j < record.length - 1; j++) {
    //         res = Math.max(res, Math.abs(record[j] - record[j + 1]));
    //     }
    //     System.out.println(res);
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        int n = Integer.parseInt(reader.readLine());
        int[] record = new int[n];
        for (String s : reader.readLine().split(" ")) {
            integers.add(Integer.parseInt(s));
        }

        boolean flag = true;
        int left = 0, right = n - 1;
        while (!integers.isEmpty()) {
            if (flag) {
                record[left++] = integers.poll();
            } else {
                record[right--] = integers.poll();
            }
            flag = !flag;
        }
        int res = 0;
        for (int j = 0; j < record.length - 1; j++) {
            res = Math.max(res, Math.abs(record[j] - record[j + 1]));
        }
        System.out.println(res);
    }
}
