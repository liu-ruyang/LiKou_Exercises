package org.example.kama_realQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1.使用new BufferedReader(new InputStreamReader(System.in))替代new Scanner(System.in); 效率快很多
 */
public class Q211 {
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        // scanner.nextLine();
        // BufferedReader的读取速度远快于Scanner(尤其在大数据量时)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>(10000);
        while (n > 0) {
            // String s = scanner.nextLine();
            String s = reader.readLine();
            if (!set.contains(s)) {
                set.add(s);
                res.add(s);
            }
            n--;
        }
        // res.forEach(s -> System.out.println(s));
        for (String re : res) {
            System.out.println(re);
        }
    }

    public void test() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    }
}
