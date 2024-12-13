package org.example.niuke_top101.binery_tree;

import java.util.LinkedList;

public class BM39 {
    public static void main(String[] args) {
        BM39 bm39 = new BM39();

        // TreeNode node = bm39.Deserialize("{1,2,3,#,#,6,7}");
        TreeNode node = bm39.Deserialize("{}");
        String serialize = bm39.Serialize(node);
        System.out.println(serialize);
    }

    String Serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            if (pop != null) {
                str.append(pop.val + ",");
                queue.add(pop.left);
                queue.add(pop.right);
            } else str.append("#,");
        }
        String res = str.toString();
        return res.equals("") ? "{}" : "{" + res.substring(0, res.length() - 1) + "}";
    }

    TreeNode Deserialize(String str) {
        String[] strs = str.replace("{", "").replace("}", "").split(",");

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (strs[0].equals("")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(strs[0]));
        TreeNode root = node;
        queue.add(node);
        int index = 1;

        while (!queue.isEmpty() && index < strs.length) {
            node = queue.pop();
            if (strs[index].equals("#")) node.left = null;
            else {
                node.left = new TreeNode(Integer.valueOf(strs[index]));
                queue.add(node.left);
            }
            index++;
            if (strs[index].equals("#")) node.right = null;
            else {
                node.right = new TreeNode(Integer.valueOf(strs[index]));
                queue.add(node.right);
            }
            index++;
        }

        return root;
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
