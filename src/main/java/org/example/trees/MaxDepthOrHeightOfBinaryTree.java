package org.example.trees;

/**
 * calculate left height by traversing to the leaf in the left
 * calculate right height by traversing to the leaf in the right
 * take max of left height and right height and add 1 to it.
 * recursively do this for all nodes in the tree.
 *
 * T.C: O(n)
 * S.C: O(n)
 */
public class MaxDepthOrHeightOfBinaryTree {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    int maxDepth(TreeNode node) {
        if (node==null) return 0;

        int leftHeight = maxDepth(node.left);
        int rightHeight = maxDepth(node.right);

        return 1+Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        MaxDepthOrHeightOfBinaryTree binaryTree = new MaxDepthOrHeightOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);

        System.out.println(binaryTree.maxDepth(root));

    }
}
