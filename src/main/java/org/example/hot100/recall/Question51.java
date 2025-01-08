package org.example.hot100.recall;

import java.util.ArrayList;
import java.util.List;

public class Question51 {
    public static void main(String[] args) {
        new Question51().solveNQueens(4);
//        new Question51().solveNQueens(5);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        boolean[] occupied1 = new boolean[n];
        boolean[] occupied2 = new boolean[n * 2];
        boolean[] occupied3 = new boolean[n * 2];
        dfs(n, 0, res, list, occupied1, occupied2, occupied3);

        return res;
    }

    public void dfs(int n, int row, List<List<String>> res, List<String> list, boolean[] occupied1, boolean[] occupied2, boolean[] occupied3) {
        if (row >= n) {
            res.add(new ArrayList<>(list));
            return;
        }
        StringBuilder builder = new StringBuilder(".".repeat(n));
        for (int j = 0; j < n; j++) {
            if (occupied1[j] == false && occupied2[j - row + n] == false && occupied3[row + j] == false) {
                occupied1[j] = occupied2[j - row + n] = occupied3[row + j] = true;
                builder.replace(j, j + 1, "Q");
                list.add(new String(builder));
                dfs(n, row + 1, res, list, occupied1, occupied2, occupied3);
                builder.replace(j, j + 1, ".");
                list.remove(list.size() - 1);
                occupied1[j] = occupied2[j - row + n] = occupied3[row + j] = false;
            }
        }
    }
//    public boolean dfs(int n, int row, List<List<String>> res, List<String> list, boolean[] occupied1, boolean[] occupied2, boolean[] occupied3) {
//        if (row >= n) {
//            return true;
//        }
//        StringBuilder builder = new StringBuilder(".".repeat(n));
//        for (int j = 0; j < n; j++) {
//            if (occupied1[j] == false && occupied2[j - row + n] == false && occupied3[row + j] == false) {
//                occupied1[j] = occupied2[j - row + n] = occupied3[row + j] = true;
////                builder.append("Q");
//                boolean dfs = dfs(n, row + 1, res, list, occupied1, occupied2, occupied3);
//                occupied1[j] = occupied2[j - row + n] = occupied3[row + j] = false;
//                if (dfs == true) {
//                    builder.replace(j, j + 1, "Q");
//                    list.add(new String(builder));
//                    builder.replace(j, j + 1, ".");
//                    if (list.size() == n) {
//                        res.add(new ArrayList<>(list));
//                        list.clear();
//                    }
//                    if (row == 0) {
//                        continue;
//                    }
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    ["...Q.",".Q...","....Q","..Q..","Q...."]
//    ["....Q","..Q..","Q....","...Q.",".Q..."]
//    ["....Q",".Q...","...Q.","Q....","..Q.."]
//    [".Q...","....Q","..Q..","Q....","...Q."]
//    ["..Q..","Q....","...Q.",".Q...","....Q"]
//
//    ["Q....","..Q..","....Q",".Q...","...Q."]
//    ["Q....","...Q.",".Q...","....Q","..Q.."]
//    [".Q...","...Q.","Q....","..Q..","....Q"]
//    [".Q...","....Q","..Q..","Q....","...Q."]
//    ["..Q..","Q....","...Q.",".Q...","....Q"]
//    ["..Q..","....Q",".Q...","...Q.","Q...."]
//    ["...Q.","Q....","..Q..","....Q",".Q..."]
//    ["...Q.",".Q...","....Q","..Q..","Q...."]
//    ["....Q",".Q...","...Q.","Q....","..Q.."]
//    ["....Q","..Q..","Q....","...Q.",".Q..."]
}
