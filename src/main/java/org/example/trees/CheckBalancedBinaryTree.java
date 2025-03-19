package org.example.trees;


/**
 * update the height function in such as way that if the abs of difference of left height and right height of a node is > 1, then return -1
 * check left height is -1, if yes, return -1
 * check right height is -1, if yes, return -1
 */
public class CheckBalancedBinaryTree {


    public  static  class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    public int checkHeight(TreeNode node) {
      if (node == null) return 0;

      int leftHeight = checkHeight(node.left);
      if(leftHeight == -1) return -1;
      int rightHeight = checkHeight(node.right);
      if(rightHeight == -1) return -1;

      if(Math.abs(leftHeight - rightHeight) > 1) return -1;
      return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean check(TreeNode node) {
        return !(checkHeight(node)== -1);
    }

    public static void main(String[] args) {

        CheckBalancedBinaryTree tree = new CheckBalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(tree.check(root));


        TreeNode unBalancedRoot = new TreeNode(1);
        unBalancedRoot.left = new TreeNode(2);
        unBalancedRoot.left.left = new TreeNode(3);
        unBalancedRoot.left.left.left = new TreeNode(9);


        unBalancedRoot.right = new TreeNode(4);
        unBalancedRoot.right.left = new TreeNode(5);
        unBalancedRoot.right.right = new TreeNode(6);
        unBalancedRoot.right.right.right = new TreeNode(7);
        unBalancedRoot.right.right.right.right = new TreeNode(8);
        System.out.println(tree.check(unBalancedRoot));
    }
}
