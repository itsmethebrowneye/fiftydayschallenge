package org.example.trees;


/**
 * t.c: O((log(n)^)2)
 * s.c: O(n)
 * complete tree - all levels are completely filled except last as left as possible.
 * we need to solve it under O(n)
 * at any node, check if height of left sub tree == height of right sub tree, if yes, return 1+ lh+rh
 * if node, recursively count the nodes in left and right and treturn count of lh + count of rh + 1
 */
public class CountNumberOfNodesInACompleteBinaryTree {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    int height(TreeNode node) {
        if (node == null) return 0;

        return 1 + height(node.left) + height(node.right);
    }

    int countNumberOfNodes(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight == rightHeight) return 1 + leftHeight + rightHeight;
        else return 1 + countNumberOfNodes(node.left) + countNumberOfNodes(node.right);
    }

    public static void main(String[] args) {
        CountNumberOfNodesInACompleteBinaryTree countNumberOfNodesInACompleteBinaryTree = new CountNumberOfNodesInACompleteBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        System.out.println(countNumberOfNodesInACompleteBinaryTree.countNumberOfNodes(root));

    }
}
