package org.example.trees;

import java.util.HashMap;
import java.util.Map;


// need to revisit
public class BinaryTreeWithInorderAndPreOrder {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void hashInorderValues(Map<Integer, Integer> map, int[] inOrder) {
        for(int i=0; i< inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
    }

    public TreeNode buildTree(Map<Integer, Integer> map, int[] inorder, int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {

        if(preStart > preEnd || inStart > inEnd) return null;

        int root = preorder[preStart];
        TreeNode rootNode = new TreeNode(root);

        int inRoot = map.get(root);

        rootNode.left = buildTree(map, inorder, preorder, preStart+1, preorder.length-1, inStart+1,  inRoot-1);
        rootNode.right = buildTree(map, inorder, preorder, preStart+2, preorder.length-1, inStart+1,  inRoot-1);

        return rootNode;
    }

    public void printPostOrder(TreeNode node) {
        if(node == null) return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTreeWithInorderAndPreOrder binaryTreeWithInorderAndPreOrder = new BinaryTreeWithInorderAndPreOrder();
        int[] inOrder = {40,20,50,10,60,30};
        int[] preOrder = {10,20,40,50,30,60};

        Map<Integer, Integer> map = new HashMap<>();
        binaryTreeWithInorderAndPreOrder.hashInorderValues(map, inOrder);
        TreeNode root =  binaryTreeWithInorderAndPreOrder.buildTree(map, inOrder, preOrder, 0, preOrder.length-1,0,  inOrder.length-1);
        binaryTreeWithInorderAndPreOrder.printPostOrder(root); // should print 40,50,20,60,30,10

    }
}
