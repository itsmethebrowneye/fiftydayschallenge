package org.example.trees;

import java.util.*;

/**
 * Follow level order traversal
 * Maintain a queue of node val and node line
 * Maintain a data structure(preferably a Map) that has line to first level data in the tree
 * T.C: O(N)
 * S.C: O(N)
 */
public class TopViewOfBinaryTree {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static class Tuple{
        TreeNode node;
        int line;
        public Tuple(TreeNode node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    void topView(TreeNode node, List<Integer> list) {
        if(node == null) return;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(node,0));

        while(!queue.isEmpty()) {
            int level = queue.size();
            for(int i=0; i< level; i++) {
                if(queue.peek().node.left != null) queue.offer(new Tuple(queue.peek().node.left, queue.peek().line -1 ));
                if(queue.peek().node.right != null) queue.offer(new Tuple(queue.peek().node.right, queue.peek().line +1 ));

                Tuple tuple = queue.poll();
                TreeNode queueNode = tuple.node;
                Integer nodeLine = tuple.line;

                if(!map.containsKey(nodeLine)) {
                    map.put(nodeLine,queueNode.data);
                }
            }
        }

        list.addAll(map.values());
    }

    public static void main(String[] args) {

        TopViewOfBinaryTree topViewOfBinaryTree = new TopViewOfBinaryTree();
        List<Integer> list = new ArrayList<>();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        topViewOfBinaryTree.topView(root, list);
        System.out.println(list);

    }
}
