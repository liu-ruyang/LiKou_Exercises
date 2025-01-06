package org.example.hot100.bineryTree;

import java.util.HashMap;

public class Question437 {
    int res;

    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        dfs(root, targetSum, 0, map);
        return res;
    }

    public void dfs(TreeNode root, int targetSum, long tempSum, HashMap<Long, Integer> map) {
        if (root == null) {
            return;
        }
        if (map.containsKey(tempSum + root.val - targetSum)) {  // 判断是否有当前节点为路径终点的路径符合条件
            res += map.get(tempSum + root.val - targetSum);
        }
        // 计算当前节点的前缀和
        if (map.containsKey(tempSum + root.val)) {
            map.put(tempSum + root.val, map.get(tempSum + root.val) + 1);
        } else {
            map.put(tempSum + root.val, 1);
        }
        // 递归处理左右子树
        dfs(root.left, targetSum, tempSum + root.val, map);
        dfs(root.right, targetSum, tempSum + root.val, map);

        // 递归结束，恢复现场
        if (map.get(tempSum + root.val) == 1) {
            map.remove(tempSum + root.val);
        } else {
            map.put(tempSum + root.val, map.get(tempSum + root.val) - 1);
        }
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
