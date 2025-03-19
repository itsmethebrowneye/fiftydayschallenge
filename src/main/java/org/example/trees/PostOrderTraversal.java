package org.example.trees;

public class PostOrderTraversal {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node() {}

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        postOrderTraversal.postOrder(root);

    }




}
