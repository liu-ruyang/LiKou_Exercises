package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 考虑三种情况：
 * 情况一：没有出现入度为2的节点，则一定是出现了环，所以只需使用并查集，直接遍历
 * <p>
 * 情况二、三：出现入度为2的节点
 * ① 两条入弧都可以删除
 * ② 只有一条弧可以删除，因为如果删除另一条弧，剩余的图存在环
 */
public class KaMa109_union_find_set {
    static ArrayList<List<Integer>> list;
    static int[] father;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        father = new int[n + 1];
        int[] inDegree = new int[n + 1];    // 记录所有节点入度
        list = new ArrayList<>();  // 记录所有边
        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            list.add(Arrays.asList(s, t));
            inDegree[t]++;
        }
        ArrayList<List<Integer>> twoDegreeEdges = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (inDegree[list.get(i).get(1)] == 2) {
                twoDegreeEdges.add(list.get(i));
            }
        }

        if (twoDegreeEdges.size() > 0) {    // 情况一、二：有入度为2
            // 去掉入度为2的节点的一条入边，还可能存在环
            if (isTreeAfterRemoveEdge(twoDegreeEdges.get(1))) {
                System.out.println(twoDegreeEdges.get(1).get(0) + " " + twoDegreeEdges.get(1).get(1));
            } else if (isTreeAfterRemoveEdge(twoDegreeEdges.get(0))) {
                System.out.println(twoDegreeEdges.get(0).get(0) + " " + twoDegreeEdges.get(0).get(1));
            }
        } else {    // 情况三：没有入度为2的节点，即只有有向环
            init();
            for (int i = 0; i < list.size(); i++) {
                List<Integer> list1 = list.get(i);
                if (isSame(list1.get(0), list1.get(1))) {
                    System.out.println(list1.get(0) + " " + list1.get(1));
                }
                join(list1.get(0), list1.get(1));
            }
        }
    }

    // 判断如果删除一条边之后，剩余部分是否有环
    public static boolean isTreeAfterRemoveEdge(List<Integer> twoDegreesList) {
        init();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list1 = list.get(i);
            if (list1.get(0) != twoDegreesList.get(0) || list1.get(1) != twoDegreesList.get(1)) {   // 跳过删除的边
                if (isSame(list1.get(0), list1.get(1))) {
                    return false;
                } else {
                    join(list1.get(0), list1.get(1));
                }
            }
        }
        return true;
    }

    public static void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
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
