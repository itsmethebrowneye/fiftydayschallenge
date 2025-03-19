package org.example.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * follow the same logic similar to level order traversal.
 * except inserting into the same order, based on the boolean flag, insert it into reverse order for alternate lists.
 */
public class ZigZagTraversalOfBinaryTree {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    List<List<Integer>> traverseZigZag(TreeNode node) {
        List<List<Integer>> finalList = new LinkedList<>();
        if (node == null) return finalList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node); // 1
        boolean flag = false;
        while (!queue.isEmpty()) {
            int level = queue.size(); // 1
            List<Integer> sublist = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if(flag) {
                    sublist.addFirst(queue.poll().data);
                } else {
                    sublist.add(queue.poll().data);
                }

            }
            flag = !flag;
            finalList.add(sublist);
        }
        return finalList;
    }

    public static void main(String[] args) {
        ZigZagTraversalOfBinaryTree zigZagTraversalOfBinaryTree = new ZigZagTraversalOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(zigZagTraversalOfBinaryTree.traverseZigZag(root));
    }
}
