package org.example.niuke_top101.binery_tree;

import java.util.LinkedList;

public class BM35 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree(TreeNode root) {
        // write code here
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int len = queue.size();
        int nullCount = 0;
        while (len > 0) {
            TreeNode node = queue.removeFirst();
            // if (node.right != null && node.left == null) return false;
            if (node.left != null) {
                if (nullCount > 0) return false;
                queue.add(node.left);
            } else {
                nullCount++;
            }
            if (node.right != null) {
                if (nullCount > 0) return false;
                queue.add(node.right);
            } else {
                nullCount++;
            }
            len--;
            if (len == 0) len = queue.size();
        }
        return true;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
