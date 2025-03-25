package org.example.kama_realQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q207 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int target = Integer.parseInt(split[1]);

        int[] num = new int[n];
        int k = 0;
        for (String s : reader.readLine().split(" ")) {
            num[k++] = Integer.parseInt(s);
        }

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < num.length; i++) {
            // for (int j = 1; j < dp.length; j++) {
            for (int j = dp.length - 1; j > 0; j--) {
                if (num[i] <= j && dp[j - num[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - num[i]] + 1);
                }
            }
        }

        System.out.println(dp[dp.length - 1] == Integer.MAX_VALUE ? "No solution" : dp[dp.length - 1]);
    }
}
