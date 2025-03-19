package org.example.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * create a final list that stores list of integers
 * insert the root node in the queue
 * run a while loop until the queue is empty
 * create a sublist of Integers (numbers at every level)
 * calculate the queue size (this is the level)
 * run a for loop for the number of levels
 * check if left of head of the queue is not null, if yes, insert it into the queue
 * check if right of the head of the queue is not null, if yes, insert it into the queue
 * remove the head from the queue and add the element in the sublist
 * once the for loops ends, add the sublist into the final list
 * once the while loop ends, return the final list
 */

public class LevelOrderTraversal {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
           this.data = data;
           this.left = null;
           this.right = null;
        }
    }

    List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new LinkedList<List<Integer>>();
        if(root == null) return finalList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
           int level =  queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0; i < level; i++) {
              if(queue.peek().left != null) queue.offer(queue.peek().left);
              if(queue.peek().right != null) queue.offer(queue.peek().right);
              subList.add(queue.poll().data);
           }
            finalList.add(subList);
        }
        return  finalList;
    }

    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        List<List<Integer>> finalList = levelOrderTraversal.levelOrder(root);
        System.out.println(finalList);
    }
}
