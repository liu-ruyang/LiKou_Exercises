package org.example.interview150.divide_and_conquer;

/**
 * 将有序数组转换为二叉搜索树
 */
public class Question108 {
    public static void main(String[] args) {
        int[] a = {-10, -3, 0, 5, 9};
        new Question108().sortedArrayToBST(a);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        helper(nums, left, mid - 1, mid + 1, right, root);
        return root;
    }

    public void helper(int[] nums, int left1, int left2, int right1, int right2, TreeNode root) {

        if (left1 <= left2) {
            int leftMid = (left1 + left2) / 2;
            root.left = new TreeNode(nums[leftMid]);
            helper(nums, left1, leftMid - 1, leftMid + 1, left2, root.left);
        }


        if (right1 <= right2) {
            int rightMid = (right1 + right2) / 2;
            root.right = new TreeNode(nums[rightMid]);
            helper(nums, right1, rightMid - 1, rightMid + 1, right2, root.right);
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
