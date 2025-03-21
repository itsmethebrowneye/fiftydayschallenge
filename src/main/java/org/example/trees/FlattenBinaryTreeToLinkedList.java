package org.example.trees;

/**
 * the preorder traversal of the tree should match the linked list ordering
 * keep a prev pointer = null initially
 * traverse right and then left
 * after traversing left and right for a subtree, assign node's left = null and node's right = prev
 * assign prev = node
 */
public class FlattenBinaryTreeToLinkedList {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    private static TreeNode prev = null;

    void flatten(TreeNode node) {
        if(node ==null) return;

        flatten(node.right);
        flatten(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }

    void printPreOrder(TreeNode node) {
        if(node == null) return;

        System.out.print(node.data+ " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    void printLinkedList(TreeNode node) {
        TreeNode curr = node;
        while(curr!=null) {
            System.out.print(curr.data+ " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        flattenBinaryTreeToLinkedList.printPreOrder(root);
        flattenBinaryTreeToLinkedList.flatten(root);
        System.out.println("\n");
        flattenBinaryTreeToLinkedList.printLinkedList(root);
    }
}
