package org.example.trees;

/**
 * update the height function in such a way that find the max of current max and max(leftheight,rightheight)
 *  T.C: O(n)
 *  S.C: O(n)
 */
public class DiameterOfBinaryTree {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    public int diameter(TreeNode node, int[] diameter) {

        if(node == null) return 0;
        int leftHeight = diameter(node.left,diameter);
        int rightHeight = diameter(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight+rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);

    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        int[] diameter = new int[1];
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.right.left.left.left = new TreeNode(9);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);
        diameterOfBinaryTree.diameter(root, diameter);
        System.out.println("Diameter:"+diameter[0]);



    }
}
