package org.example.trees;

/**
 * calculate left path sum
 * calculate right path sum
 * update max in the array such that the max of a current node is equal to the sum of node value, left path su,m and right path sum
 * in order to take which path, left or right, we are using return node.data + max(leftSum , rightSum)
 */
public class MaxPathSum {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    int maxPath(TreeNode node, int[] arr) {
        if(node == null) return 0;

        int leftPathSum = maxPath(node.left,arr);
        int rightPathSum = maxPath(node.right,arr);

        arr[0] = Math.max(arr[0], leftPathSum + rightPathSum + node.data);

        return node.data + Math.max(leftPathSum, rightPathSum);
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int[] maxSumArray = new int[1];
        maxPathSum.maxPath(root, maxSumArray);
        System.out.println("max path sum:"+maxSumArray[0]);

    }
}
