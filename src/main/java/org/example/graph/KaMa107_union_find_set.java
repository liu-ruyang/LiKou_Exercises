package org.example.graph;


import java.util.Scanner;

/**
 * 并查集主要有三个功能：
 * 1.寻找根节点，函数：find（int u），也就是判断这个节点的祖先节点是哪个（过程中会进行路径压缩）
 * 注意：每次第二次find同一个节点的时候，这条路径就会被压缩
 * 2.将两个节点接入到同一个集合，函数：join（int u，int v）m将两个节点连在同一个根节点上
 * 3.判断两个节点是否在同一个集合，函数：isSame（int u，int v），就是判断两个节点是不是同一个根节点
 */
public class KaMa107_union_find_set {
    static int[] father;
    // 在进行比较的时候，都要使用find函数返回值比较，father只用于修改祖先节点，
    // （不用于比较，有时候比较的时候，是第一次访问节点，出现路径还未压缩的情况，导致直接比较父节点出现错误）

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // father初始化
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }

        // 读取双向图（无向图）的边，重新整理并查集
        for (int i = 0; i < m; i++) {
            join(scanner.nextInt() - 1, scanner.nextInt() - 1);
        }

        int u = scanner.nextInt();
        int v = scanner.nextInt();
        System.out.println(isSame(u - 1, v - 1) ? 1 : 0);
    }

    static int find(int u) {
        if (u == father[u]) {
            return u;
        }
        return father[u] = find(father[u]);
    }

    static void join(int u, int v) {
        u = find(u);
        v = find(v);
        // 经过上述两次find函数，u和v可能不是原来的u和v
        if (u == v) return;
        // 最后需要将v的祖先节点设置为u的祖先节点的父节点
        father[u] = find(v);
    }

    static boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }
}
