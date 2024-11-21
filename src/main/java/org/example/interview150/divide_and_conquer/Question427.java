package org.example.interview150.divide_and_conquer;

public class Question427 {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    // 判断一个矩阵代表的区域对应的Node是要改为叶子节点
    // 返回该节点
    public Node dfs(int[][] grid, int xStart, int xEnd, int yStart, int yEnd) {
        if (xStart >= xEnd && yStart >= yEnd) {
            return new Node(grid[xStart][yStart] == 1, true, null, null, null, null);
        }

        int midX = (xStart + xEnd) / 2;
        int midY = (yStart + yEnd) / 2;
        Node leftTop = dfs(grid, xStart, midX, yStart, midY);
        Node leftBottom = dfs(grid, midX + 1, xEnd, yStart, midY);
        Node rightTop = dfs(grid, xStart, midX, midY + 1, yEnd);
        Node rightBottom = dfs(grid, midX + 1, xEnd, midY + 1, yEnd);

        if (leftTop.isLeaf && leftBottom.isLeaf && rightTop.isLeaf && rightBottom.isLeaf && leftTop.val == leftBottom.val && leftTop.val == rightTop.val && leftTop.val == rightBottom.val) {
            return new Node(leftTop.val, true, null, null, null, null);
        } else {
            return new Node(leftTop.val, false, leftTop, rightTop, leftBottom, rightBottom);
        }
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
