package org.example.kama_realQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q208 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        double res = Math.pow(2, n - 1) * n;
        System.out.println(res);
    }
}
