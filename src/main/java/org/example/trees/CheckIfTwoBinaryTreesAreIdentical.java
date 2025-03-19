package org.example.trees;

/**
 * apply in traversal and check if the node's data is identical for both trees
 * T.C: O(n)
 * S.C: O(n)
 */
public class CheckIfTwoBinaryTreesAreIdentical {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    boolean checkIfIdentical(TreeNode node1, TreeNode node2) {
        // preorder traversal
        if(node1 == null && node2 == null) return true;
        return node1.data == node2.data && checkIfIdentical(node1.left, node2.left) && checkIfIdentical(node1.right, node2.right);
    }

    public static void main(String[] args) {
        CheckIfTwoBinaryTreesAreIdentical checkIfTwoBinaryTreesAreIdentical = new CheckIfTwoBinaryTreesAreIdentical();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        System.out.println(checkIfTwoBinaryTreesAreIdentical.checkIfIdentical(root1,root2));

    }
}
