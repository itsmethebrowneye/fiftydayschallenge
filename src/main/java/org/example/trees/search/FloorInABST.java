package org.example.trees.search;

public class FloorInABST {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public int calculateFloorBST(TreeNode node, int key) {
        int floor = -1;
        if(node == null) return floor;

        TreeNode curr = node;
        while(curr!=null) {
            if(curr.data == key) {
                floor = curr.data;
                return floor;
            }

            if(curr.data > key) {
                // left
                floor = curr.data;
                curr = curr.left;

            }
            else {
                // right
                floor = curr.data;
                curr = curr.right;

            }
        }

        return floor;

    }

    public static void main(String[] args) {
        FloorInABST floorInABST = new FloorInABST();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        int key = 7;
        System.out.println( floorInABST.calculateFloorBST(root,key));
    }

}
