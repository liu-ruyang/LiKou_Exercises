package org.example.graph;

import java.util.*;

/**
 * Astar 是一种 广搜的改良版。 有的是 Astar是 dijkstra 的改良版。
 * 如果是无权图（边的权值都是1） 那就用广搜，代码简洁，时间效率和 dijkstra 差不多 （具体要取决于图的稠密）
 * Astar 关键在于 启发式函数， 也就是 影响 广搜或者 dijkstra 从 容器（队列）里取元素的优先顺序。
 * <p>
 * <p>
 * 每个节点的权值为F，给出公式为：F = G + H
 * G：起点达到目前遍历节点的距离
 * H：目前遍历的节点到达终点的距离
 * 起点达到目前遍历节点的距离 + 目前遍历的节点到达终点的距离 就是起点到达终点的距离。
 * <p>
 * 细节 1：G 和 H 的权重，应当保持一致，比如，本题H使用的是欧拉距离，且最终没有开平方，那么每一个下一个节点到起点的距离，应该在当前节点到起点的距离基础上 加5，（千万不能是 1，因为使用5时，G 和 H的权重才是一样的）
 * 细节 2：对于这种大型矩阵的定义语句，最好放在成员变量位置；经实验，虽然放在成员变量和局部变量中都需要有一个全部遍历复原0的操作，但是局部变量会多一个定义时分配空间的操作，单这一个步骤会导致超时错误！！
 * <p>
 * <p>
 * 本题的图是无权网格状，在计算两点距离通常有如下三种计算方式：
 * ① 曼哈顿距离，计算方式： d = abs(x1-x2)+abs(y1-y2)
 * ② 欧氏距离（欧拉距离） ，计算方式：d = sqrt( (x1-x2)^2 + (y1-y2)^2 )
 * ③ 切比雪夫距离，计算方式：d = max(abs(x1 - x2), abs(y1 - y2))
 */
public class KaMa127_A_star {
    static int[][] board = new int[1001][1001];    // 棋盘，记录起点到每个点的距离

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        ArrayList<List<Pair>> lists = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lists.add(Arrays.asList(new Pair(scanner.nextInt(), scanner.nextInt()), new Pair(scanner.nextInt(), scanner.nextInt())));
        }

        for (List<Pair> list : lists) {
            for (int[] ints : board) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            System.out.println(A_Star(list.get(0), list.get(1)) / 5);
        }

    }

    public static int A_Star(Pair start, Pair end) {

        int[][] rules = {
                {-1, 2},
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2},
                {-2, -1},
                {-2, 1}};

        // 用优先权队列实现堆排序（自定义排序规则）
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int d1 = board[o1.x][o1.y];
                int d2 = (end.x - o1.x) * (end.x - o1.x) + (end.y - o1.y) * (end.y - o1.y);
                int d3 = board[o2.x][o2.y];
                int d4 = (end.x - o2.x) * (end.x - o2.x) + (end.y - o2.y) * (end.y - o2.y);
                if (d1 + d2 < d3 + d4) {
                    return -1;
                } else if (d1 + d2 == d3 + d4) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        priorityQueue.add(start);
        board[start.x][start.y] = 0;

        int minStep = Integer.MAX_VALUE;

        while (!priorityQueue.isEmpty()) {
            Pair cur = priorityQueue.poll();
            if (cur.x == end.x && cur.y == end.y) {
                return board[cur.x][cur.y];
                // minStep = Math.min(minStep, board[cur.x][cur.y]);
            } else {
                for (int[] rule : rules) {
                    //
                    // if (cur.x + rule[0] >= 1 && cur.x + rule[0] <= 1000 && cur.y + rule[1] >= 1 && cur.y + rule[1] <= 1000) {
                    if (cur.x + rule[0] >= 1 && cur.x + rule[0] <= 1000 && cur.y + rule[1] >= 1 && cur.y + rule[1] <= 1000 && board[cur.x][cur.y] + 1 < board[cur.x + rule[0]][cur.y + rule[1]]) {
                        Pair pair = new Pair(cur.x + rule[0], cur.y + rule[1]);
                        board[pair.x][pair.y] = board[cur.x][cur.y] + 5;
                        // board[pair.x][pair.y] = board[cur.x][cur.y] + 1;
                        priorityQueue.add(pair);
                    }
                }
            }
        }
        return minStep;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
