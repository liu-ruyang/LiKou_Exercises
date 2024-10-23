package org.example.interview150.binary_tree;

import java.util.LinkedList;

public class Question173 {
    class BSTIterator {
        LinkedList<TreeNode> queue;

        public BSTIterator(TreeNode root) {
            queue = new LinkedList<>();

            LinkedList<TreeNode> stack = new LinkedList<>();

            stack.push(root);

            /*
            需注意：
            ① 添加到栈中节点，只是记录一下后期处理进结果列表中的节点的顺序；
            ② 栈中的右节点和中间节点，不同于中节点和左节点的关系。左节点处理完，处理的就是中间节点；但是中间节点处理完，不是直接处理右节点，而是对右节点以及右节点的子节点继续进行入栈记录顺序，然后重复之前的逻辑继续处理的
             */
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();    // 将该节点弹出，避免重复操作，下面再将中左节点添加到栈中
                if (node != null) {
                    if (node.right != null) {
                        stack.push(node.right); // 右
                    }
                    stack.push(node);       // 中
                    stack.push(null);   // 中节点访问过，但是还没有处理，加入空节点作为标记
                    if (node.left != null) {
                        stack.push(node.left);  // 左
                    }
                } else {    // 只有遇到空节点的时候，才将下一个节点放进结果集
                    node = stack.pop();
                    queue.add(node);    // 加入到结果集
                }
            }
        }

        public int next() {
            return queue.pop().val;
        }

        public boolean hasNext() {
            return queue.size() > 0;
        }

        class TreeNode {
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
}
