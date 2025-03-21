package org.example.trees.search;

/**
 * searching a node in a binary search tree takes order of log n.
 */
public class SearchNode {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    TreeNode searchBST(TreeNode node, TreeNode nodeToBeSearched) {
        if(node == null) return node;

        if(node.data == nodeToBeSearched.data) return node;

        if(node.data > nodeToBeSearched.data) {
            return searchBST(node.left, nodeToBeSearched);
        }
        else {
            return searchBST(node.right, nodeToBeSearched);
        }
    }

    public static void main(String[] args) {
        SearchNode searchNode = new SearchNode();

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        TreeNode nodeToBeSearched1 = root.right.left;
        TreeNode nodeToBeSearched2 = new TreeNode(47);
        TreeNode search1 = searchNode.searchBST(root, nodeToBeSearched1);
        TreeNode search2 = searchNode.searchBST(root, nodeToBeSearched2);
        if(search1!=null) {
            System.out.println(search1.data);
        } else
            System.out.println(-1);

        if(search2!=null) {
            System.out.println(search2.data);
        } else
            System.out.println(-1);

    }
}
