package org.example.trees;

class Node {
    int data;
    Node left;
    Node right;

    Node(int key) {
        data = key;
    }
}

public class PreOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        PreOrderTraversal traversal = new PreOrderTraversal();
        traversal.preorder(root);
    }

    public void preorder(Node node) {
        if (node == null) return;

        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }


}
