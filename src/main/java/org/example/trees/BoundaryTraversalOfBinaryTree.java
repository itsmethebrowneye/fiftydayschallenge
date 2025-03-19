package org.example.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * fetch left boundary except leaf
 * fetch leaf nodes
 * fetch right boundary except leaf
 */
public class BoundaryTraversalOfBinaryTree {


    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    void addLeftBoundary(TreeNode node, Queue<Integer> result) {
        if(node == null || (node.left == null && node.right == null)) return;

        result.offer(node.data);
        if(node.left !=null) {
            addLeftBoundary(node.left, result);
        } else
        {
            addLeftBoundary(node.right, result);
        }

    }

    void addLeafNodes(TreeNode node, Queue<Integer> result) {
        // inorder traversal Left, Root, Right

        if(node == null) return;

        addLeafNodes(node.left, result);
        if (node.left == null && node.right == null) {
            result.offer(node.data);
        }
        addLeafNodes(node.right, result);

    }

    void addRightBoundary(TreeNode node, Stack<Integer> result) {
        // use a stack for reverse order
        if(node == null || (node.left == null && node.right == null)) return;

        result.push(node.data);
        if(node.right!=null) {
            addRightBoundary(node.right, result);
        } else {
            addRightBoundary(node.left, result);
        }
    }

    void calculateBoundaryTraversal(TreeNode node, Queue<Integer> result, Stack<Integer> rightBoundary) {
        addLeftBoundary(node,result);
        addLeafNodes(node,result);
        addRightBoundary(node.right,rightBoundary);
    }

    public static void main(String[] args) {
        BoundaryTraversalOfBinaryTree boundaryTraversalOfBinaryTree = new BoundaryTraversalOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);
        Queue<Integer> result = new LinkedList<>();
        Stack<Integer> rightBoundary = new Stack<>();
        boundaryTraversalOfBinaryTree.calculateBoundaryTraversal(root, result, rightBoundary);
        while(!rightBoundary.isEmpty()) {
            result.offer(rightBoundary.pop());
        }
        System.out.println(result);
    }
}
