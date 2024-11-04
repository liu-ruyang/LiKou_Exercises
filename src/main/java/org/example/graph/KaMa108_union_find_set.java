package org.example.graph;

import java.util.Scanner;

/**
 * 并查集可以解决什么问题：
 * 1.两个节点是否在一个集合
 * 2.将两个节点添加到一个集合中
 */
public class KaMa108_union_find_set {
    static int[] father;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();

            if (!isSame(s, t)) {
                join(s, t);
            } else {
                System.out.println((s) + " " + (t));
                break;
            }
        }
    }

    public static int find(int u) {
        if (u == father[u]) {
            return u;
        }
        return father[u] = find(father[u]);
    }

    public static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[u] = v;
    }

    public static boolean isSame(int u, int v) {
        return find(u) == find(v);
    }
}
