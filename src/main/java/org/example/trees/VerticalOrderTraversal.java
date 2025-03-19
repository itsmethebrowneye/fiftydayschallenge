package org.example.trees;

import java.util.*;

/**
 * plot the nodes with x and y axis (row, col)
 * follow level order traversal
 * for every level put the respective row and column values in the datastruture
 *
 */
public class VerticalOrderTraversal {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static class Tuple {
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row; // level
            this.col = col; // vertical
        }
    }

    void verticalOrder(TreeNode node, List<List<Integer>> finalList) {
        if(node == null) return;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(node, 0, 0));

        while(!queue.isEmpty()) {
            int level = queue.size();
            TreeMap<Integer, PriorityQueue<Integer>> subMap = new TreeMap<>();

            for(int i=0; i < level; i++) {

                if(queue.peek().node.left != null) queue.offer(new Tuple(queue.peek().node.left, queue.peek().row+1, queue.peek().col-1));
                if(queue.peek().node.right != null) queue.offer(new Tuple(queue.peek().node.right, queue.peek().row+1, queue.peek().col+1));

                Tuple tuple = queue.poll();
                int row = tuple.row; // 0
                int col = tuple.col; // 0

                if(!map.containsKey(col)) {
                    TreeMap<Integer, PriorityQueue<Integer>> innerMap = new TreeMap<>();
                    PriorityQueue<Integer> innerQueue = new PriorityQueue<>();
                    innerQueue.offer(tuple.node.data);
                    innerMap.put(row, innerQueue);
                    map.put(col,innerMap);
                } else {
                    if(map.get(col).get(row)!= null) {
                        map.get(col).get(row).offer(tuple.node.data);
                    } else {
                        PriorityQueue<Integer> innerQueue = new PriorityQueue<>();
                        innerQueue.offer(tuple.node.data);
                        map.get(col).put(row, innerQueue);
                    }
                }

            }
        }


        for( TreeMap<Integer, PriorityQueue<Integer>> innerMapValues : map.values()) {
            List<Integer> subList = new ArrayList<>();
            for (PriorityQueue<Integer> innerValues: innerMapValues.values()) {
                subList.addAll(innerValues.stream().toList());
            }
            finalList.add(subList);
        }

    }

    public static void main(String[] args) {
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);

        root.left.right = new TreeNode(10);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);
        List<List<Integer>> finalList = new LinkedList<>();
        verticalOrderTraversal.verticalOrder(root, finalList);
        System.out.println(finalList);
    }
}
