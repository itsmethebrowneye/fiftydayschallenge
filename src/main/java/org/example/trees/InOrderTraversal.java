package org.example.trees;

public class InOrderTraversal {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int key) {
            data = key;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        InOrderTraversal traversal = new InOrderTraversal();
        traversal.inorder(root);
    }

    public void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }


}
