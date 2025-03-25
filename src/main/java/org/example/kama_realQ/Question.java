package org.example.kama_realQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] split = s.split("],");
        String[] nums = split[0].replace("[", "").split(",");
        String chars = split[1].replace("\"", "");
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < chars.length(); i++) {
            if (chars.charAt(i) == 'W') {
                list.add(Integer.parseInt(nums[i]));
            } else {
                sum += Integer.parseInt(nums[i]);
            }
        }

        int[][] dp = new int[list.size()][2];
        if (list.size() <= 0) {
            System.out.println(sum % 2 == 0 ? 1 : 0);
        } else {
            if (sum % 2 == 0) {
                dp[0][0] = list.get(0) % 2 == 0 ? 0 : 1;
                dp[0][1] = list.get(0) % 2 == 0 ? 2 : 1;
            } else if (sum % 2 != 0) {
                dp[0][0] = list.get(0) % 2 == 0 ? 2 : 1;
                dp[0][1] = list.get(0) % 2 == 0 ? 0 : 1;
            }
            // if (list.get(0) % 2 == 0) { // 当前是偶数
            //     dp[0][0] = sum % 2 != 0 ? 2 : 0;
            //     dp[0][1] = sum % 2 == 0 ? 2 : 0;
            // } else {    // 当前是奇数
            //     dp[0][0] = sum % 2 == 0 ? 1 : 0;
            //     dp[0][1] = sum % 2 != 0 ? 1 : 0;
            // }
            for (int i = 1; i < list.size(); i++) {
                dp[i][0] = list.get(i) % 2 == 0 ? dp[i - 1][0] * 2 : dp[i - 1][0] + dp[i - 1][1];
                dp[i][1] = list.get(i) % 2 == 0 ? dp[i - 1][1] * 2 : dp[i - 1][1] + dp[i - 1][0];
                // if (list.get(i) % 2 == 0) { // 当前是偶数
                //     dp[i][0] = dp[i - 1][0] + 1;
                //     dp[i][1] = dp[i - 1][1] + 1;
                // } else {    // 当前是奇数
                //     dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                //     dp[i][1] = dp[i - 1][1] + dp[i - 1][0];
                // }
            }
            System.out.println(dp[dp.length - 1][1]);
        }
    }
}
