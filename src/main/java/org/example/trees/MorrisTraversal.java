package org.example.trees;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Morris take O(1) space while usual Inorder trversal takes O(n) auxillary space.
 * root can be null. If yes, return
 * there are two cases.
 * case 1: root's left can be null, then print root and move to root's right
 * case 2: take the curr into a prev
 * iterate until prev.right is null or prev.right == curr
 * again two cases,
 * case1: if prev.right == null, then prev.right = curr. and move left (adding a thread - threaded binary tree)
 * case 2: if prev.right == curr, then remove that connection - prev.right =null and add print the current value and move to right.
 */
public class MorrisTraversal {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void printInorder(TreeNode node, List<Integer> inOrder) {

        if(node == null) return;

        TreeNode curr = node;

        while(curr!=null) {
            if(curr.left==null){
                inOrder.add(curr.data);
                curr = curr.right;
            } else {
               // we have left subtree
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inOrder.add(curr.data);
                    curr=curr.right;
                }
            }
        }
    }

    public void printPreOrder(TreeNode node, List<Integer> inOrder) {

        if(node == null) return;

        TreeNode curr = node;

        while(curr!=null) {
            if(curr.left==null){
                inOrder.add(curr.data);
                curr = curr.right;
            } else {
                // we have left subtree
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = curr;
                    inOrder.add(curr.data);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr=curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        MorrisTraversal morrisTraversal = new MorrisTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.right = new TreeNode(6);
        List<Integer> inOrder = new ArrayList<>();
        morrisTraversal.printInorder(root,inOrder );
        List<Integer> preOrder = new ArrayList<>();
        morrisTraversal.printPreOrder(root,preOrder );
        System.out.println(inOrder);
        System.out.println(preOrder);
    }
}
