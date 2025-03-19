package org.example.trees;

import java.util.*;

public class BottomViewOfBinaryTree {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    public static class Tuple {
        TreeNode node;
        int line;
        public Tuple(TreeNode node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    void bottomView(TreeNode node, List<Integer> list){
        if(node == null) return;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(node,0));

        while(!queue.isEmpty()) {
            int level = queue.size();
            for(int i=0; i<level; i++) {
                if(queue.peek().node.left!=null) queue.offer(new Tuple(queue.peek().node.left,queue.peek().line-1));
                if(queue.peek().node.right!=null) queue.offer(new Tuple(queue.peek().node.right,queue.peek().line+1));

                Tuple tuple = queue.poll();
                int line = tuple.line;
                TreeNode treeNode = tuple.node;
                map.put(line, treeNode.data);
            }
        }

        list.addAll(map.values());
    }


    public static void main(String[] args) {
        BottomViewOfBinaryTree bottomViewOfBinaryTree = new BottomViewOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> list = new ArrayList<>();
        bottomViewOfBinaryTree.bottomView(root,list);
        System.out.println(list);

    }
}
