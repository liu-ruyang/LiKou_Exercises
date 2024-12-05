package org.example.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 统一迭代法遍历二叉树：访问和处理节点同时进行，通过添加NULL标记的方式
 */
public class Question144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();        // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中

            if (node != null) {
                if (node.right != null) {       // 添加右节点(空节点不入栈)
                    stack.push(node.right);
                }
                if (node.left != null) {        // 添加左节点(空节点不入栈)
                    stack.push(node.left);
                }
                stack.push(node);               // 添加中节点
                stack.push(null);            // 中节点访问过，但是还没有处理，加入空节点做为标记。//要处理的最终都是作为某一个树结构的中间节点位置进行处理的
                
            } else {                            // 只有遇到空节点的时候，才将下一个节点放进结果集 // 说明栈中下一个是将要被处理的元素
                TreeNode node1 = stack.pop();   // 重新取出栈中元素
                res.add(node1.val);             // 加入到结果集
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
