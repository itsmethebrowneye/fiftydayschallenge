package org.example.trees.search;

public class CeilInABST {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public int calculateCeil(TreeNode node, int key) {
        int ceil = -1;
        TreeNode curr = node;
        while(curr!=null) {
            if(curr.data == key) {
                ceil = curr.data;
                return ceil;
            }

            if(curr.data > key) {
              // left
                ceil = curr.data;
                curr = curr.left;

            } else {
                // right
                ceil = curr.data;
                curr = curr.right;
            }
        }
        return  ceil;
    }

    public static void main(String[] args) {
        CeilInABST ceilInABST = new CeilInABST();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        System.out.println(ceilInABST.calculateCeil(root, 9));
    }


}
