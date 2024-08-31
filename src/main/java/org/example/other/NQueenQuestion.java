package org.example.other;

/**
 * 在搜索过程中
 * 约束函数：避免无谓地搜索那些已知不包含答案状态地子树
 * 限界函数：减去那些不可能包含最优答案结点地子树
 * 剪枝函数：约束函数和限界函数统称为剪枝函数，因为约束函数和限界函数目的都是为了剪去不必要搜索的子树，减少问题求解所需实际生成的状态结点树
 */
public class NQueenQuestion {

    public static void main(String[] args) {
        int[] queens = {-1, -1, -1, -1, -1};
        new NQueenQuestion().NQueens(0, 5, queens);
    }

    public Boolean place(int k, int i, int[] x) {
        for (int j = 0; j < k; j++) {
            if ((x[j] == i) || (Math.abs(x[j] - i) == Math.abs(j - k))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param k 前k个已经符合要求的k个皇后
     * @param n 一共有n个皇后需要处理
     * @param x 数组，记录n个皇后分别在第几列，下标指皇后的序号
     * @return 当前皇后如果有满足条件的位置，则返回true；找到第一个满足条件的解，也返回true；如果按照前k-1个皇后布局，导致当前皇后无合适位置，则返回false；
     */
    public boolean NQueens(int k, int n, int[] x) {
        for (int i = 0; i < n; i++) {
            if (place(k, i, x)) {
                x[k] = i;
                if (k == n - 1) {
                    for (int j = 0; j < n; j++) {
                        System.out.print("\t" + x[j]);
                    }
                    return true;
                } else if (NQueens(k + 1, n, x)) {
                    return true;
                }
            }
        }
        return false;
    }
}
