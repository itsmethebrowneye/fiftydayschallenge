package org.example.trees;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBinaryTree {

    public  static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void preOrderInReverse(TreeNode node, int level, List<Integer> list) {
        if(node == null) return;

        if(list.size() == level) {
            list.add(node.data);
        }

        preOrderInReverse(node.left,level+1, list);
        preOrderInReverse(node.right,level+1, list);
    }

    public void leftView(TreeNode node, List<Integer> list) {
        // preorder in reverse
        preOrderInReverse(node,0, list);
    }

    public static void main(String[] args) {
        LeftViewOfBinaryTree leftViewOfBinaryTree = new LeftViewOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> list= new ArrayList<>();
        leftViewOfBinaryTree.leftView(root, list);
        System.out.println(list);


    }
}
