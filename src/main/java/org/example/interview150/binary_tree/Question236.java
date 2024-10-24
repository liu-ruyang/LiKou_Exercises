package org.example.interview150.binary_tree;

public class Question236 {
    /*
    二叉树如何实现自底向上？ 回溯
    后序遍历（左右中）就是天然的回溯过程，根据左右子树的返回值，来处理中节点的逻辑
     */

    /*
    算法逻辑：
    判断左右子树是否返回p、q节点，返回了则当前节点为其祖先节点（注意当前节点也可以当作祖先节点）
     */
    // 返回p、q的最近公共祖先节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = null;
        if (root.left != null) {
            left = lowestCommonAncestor(root.left, p, q);
        }
        TreeNode right = null;
        if (root.right != null) {
            right = lowestCommonAncestor(root.right, p, q);
        }

        if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            // 刚好p、q分别出现在root节点的左、右子树中
            return root;
        }

    }

    public
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
