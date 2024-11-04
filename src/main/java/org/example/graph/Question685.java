package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 考虑三种情况：
 * 情况一：没有出现入度为2的节点，则一定是出现了环，所以只需使用并查集，直接遍历
 * <p>
 * 情况二、三：出现入度为2的节点
 * ① 两条入弧都可以删除
 * ② 只有一条弧可以删除，因为如果删除另一条弧，剩余的图存在环
 */
public class Question685 {

    int[] father;

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        new Question685().findRedundantDirectedConnection(a);
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {

        father = new int[edges.length + 1];

        ArrayList<List<Integer>> twoDegreeEdges = new ArrayList<>();

        int[] inDegree = new int[edges.length + 1]; // 记录各节点的入度
        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i][1]]++;
        }
        for (int i = 0; i < edges.length; i++) {
            if (inDegree[edges[i][1]] >= 2) {
                twoDegreeEdges.add(Arrays.asList(edges[i][0], edges[i][1]));
            }
        }

        if (twoDegreeEdges.size() > 0) {    // 存在入度为2的节点
            if (isTreeAfterRemoveEdge(edges, twoDegreeEdges.get(1))) {
                return twoDegreeEdges.get(1).stream().mapToInt(Integer::intValue).toArray();
            } else if (isTreeAfterRemoveEdge(edges, twoDegreeEdges.get(0))) {
                return twoDegreeEdges.get(0).stream().mapToInt(Integer::intValue).toArray();
            }
        } else {    // 不存在入度为2的节点，即只存在环
            init(); // 初始化并查集
            for (int i = 0; i < edges.length; i++) {
                if (isSame(edges[i][0], edges[i][1])) {
                    return edges[i];
                }
                join(edges[i][0], edges[i][1]);
            }
        }

        return null;
    }

    public boolean isTreeAfterRemoveEdge(int[][] edges, List<Integer> list) {
        init(); // 初始化并查集

        for (int i = 0; i < edges.length; i++) {
            if (!(edges[i][0] == list.get(0) && edges[i][1] == list.get(1))) {  // 跳过删除的边
                if (isSame(edges[i][0], edges[i][1])) { // 存在环
                    return false;
                }
                join(edges[i][0], edges[i][1]);
            }
        }
        return true;
    }

    public void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public int find(int u) {
        if (u == father[u]) {
            return u;
        }
        return father[u] = find(father[u]);
    }

    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[u] = v;
    }

    public boolean isSame(int u, int v) {
        return find(u) == find(v);
    }
}
