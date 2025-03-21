package org.example.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * do a level order traversal from root and map the parent node
 * do a level order traversal from source node and process radially outward for every node at a level (parent, left, right)
 * use queue data structure to store level data and hashMap to track visited nodes.
 * use variable isBurned and timeTaken
 * timeTaken is incremented only when burned is true.
 * burned should be set to true when nodes are insert to queue and visited map.
 */
public class MinimumTimeTakenToBurnABinaryTree {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void mapParentNodes(TreeNode node, Map<Integer, TreeNode> map) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    map.put(queue.peek().left.data, queue.peek());
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    map.put(queue.peek().right.data, queue.peek());
                    queue.offer(queue.peek().right);
                }
                queue.poll();
            }
        }
    }

    public  int calculateTotalTime(TreeNode startNode, Map<Integer, TreeNode> parentMapping) {
        int totalTimeTaken = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Boolean> visitedMap = new HashMap<>();

        queue.offer(startNode);
        visitedMap.put(startNode.data, true);

        while(!queue.isEmpty()) {
           int level = queue.size();
            boolean burned = false; // important to note
           for(int i=0;i<level;i++){
               if(parentMapping.containsKey(Integer.valueOf(queue.peek().data))) {
                   TreeNode parent = parentMapping.get(Integer.valueOf(queue.peek().data));
                   if(!visitedMap.containsKey(Integer.valueOf(parent.data))) {
                       queue.offer(parent);
                       visitedMap.put(Integer.valueOf(parent.data),true);
                       burned = true;
                   }
               }

               if(queue.peek().left!=null) {
                   if(!visitedMap.containsKey(Integer.valueOf(queue.peek().left.data))) {
                       queue.offer(queue.peek().left);
                       visitedMap.put(Integer.valueOf(queue.peek().left.data),true);
                       burned = true;
                   }
               }

               if(queue.peek().right!=null) {
                   if(!visitedMap.containsKey(Integer.valueOf(queue.peek().right.data))) {
                       queue.offer(queue.peek().right);
                       visitedMap.put(Integer.valueOf(queue.peek().right.data),true);
                       burned = true;
                   }
               }

               queue.poll();
           }
           if(burned)  totalTimeTaken+=1;

        }


        return totalTimeTaken;
    }


    public static void main(String[] args) {
        MinimumTimeTakenToBurnABinaryTree minimumTimeTakenToBurnABinaryTree = new MinimumTimeTakenToBurnABinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Map<Integer, TreeNode> parentMapping = new HashMap<>();
        minimumTimeTakenToBurnABinaryTree.mapParentNodes(root, parentMapping);
        TreeNode startNode = root.left;
        System.out.println(minimumTimeTakenToBurnABinaryTree.calculateTotalTime(startNode,parentMapping));
    }
}
