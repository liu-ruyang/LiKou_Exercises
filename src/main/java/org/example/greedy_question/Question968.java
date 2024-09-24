package org.example.greedy_question;

public class Question968 {

    int result = 0;

    public static void main(String[] args) {
        TreeNode node1 = new Question968().new TreeNode(1);
        TreeNode node2 = new Question968().new TreeNode(2);
        TreeNode node3 = new Question968().new TreeNode(3);
        TreeNode node4 = new Question968().new TreeNode(4);
        TreeNode node5 = new Question968().new TreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        new Question968().minCameraCover(node1);
    }

    public int minCameraCover(TreeNode root) {
        result = 0;
        if (cameraTree(root) == 0)
            result += 1;
        return result;
    }

    /**
     * @param root
     * @return 0 无覆盖； 1 摄像头； 2 有覆盖，但无摄像头
     */
    public int cameraTree(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = cameraTree(root.left);
        int right = cameraTree(root.right);
        
        if (left == 0 || right == 0) {
            result = result + 1;
            return 1;
        }

        if (left == 1 || right == 1) {
            return 2;
        }

        // if (cameraTree(root.left) == 2 && cameraTree(root.right) == 2) {
        return 0;
        // }

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
