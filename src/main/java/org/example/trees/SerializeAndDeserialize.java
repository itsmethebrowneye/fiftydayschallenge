package org.example.trees;

import java.util.LinkedList;
import java.util.Queue;


/**
 * use level order traversal to serialize a tree to String.
 * add 3 when there is null.
 * pass the serialized string to deserialize function.
 * use level order traversal to construct the tree and finally return the root.
 */
public class SerializeAndDeserialize {


    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public String serialize(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder("");
        queue.offer(node);
        str.append(node.data);
        while(!queue.isEmpty()) {
            int level = queue.size();

            for(int i=0;i<level;i++){
                if(queue.peek().left!=null) {
                    queue.offer(queue.peek().left);
                    str.append(","+queue.peek().left.data);
                } else {
                    if(queue.peek().data !=-1) {
                        queue.offer(new TreeNode(-1));
                        str.append(",#");
                    }

                }

                if(queue.peek().right!=null) {
                    queue.offer(queue.peek().right);
                    str.append(","+queue.peek().right.data);
                } else {
                    if(queue.peek().data!=-1) {
                        queue.offer(new TreeNode(-1));
                        str.append(",#");
                    }
                }
                queue.poll();
            }
        }

        return str.toString();
    }

    public TreeNode deSerialize(String serialized) {
        String[] nodes = serialized.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int startIndex = 0;
        TreeNode node = new TreeNode(Integer.valueOf(nodes[startIndex]).intValue());
        queue.offer(node);

        while(!queue.isEmpty()) {
            int level = queue.size();

            for(int i=0;i<level;i++) {
                TreeNode parent = queue.poll();

                int leftIndex = startIndex+1;
                if(!nodes[leftIndex].equals("#")) {
                    int left = Integer.valueOf(nodes[leftIndex]).intValue();
                    TreeNode leftNode = new TreeNode(left);
                    queue.offer(leftNode);
                    parent.left = leftNode;
                } else {
                    parent.left = null;
                }

                int rightIndex = leftIndex+1;
                if(!nodes[rightIndex].equals("#")) {
                    int right = Integer.valueOf(nodes[rightIndex]).intValue();
                    TreeNode rightNode = new TreeNode(right);
                    queue.offer(rightNode);
                    parent.right = rightNode;
                } else {
                    parent.right = null;
                }
                startIndex = rightIndex;
            }
         }

        return node;
    }

    public void printInorder(TreeNode node) {
      if(node == null) return;

      printInorder(node.left);
      System.out.println(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        SerializeAndDeserialize serializeAndDeserialize = new SerializeAndDeserialize();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println("before serialization");
        serializeAndDeserialize.printInorder(root);
        String serialized = serializeAndDeserialize.serialize(root);
        System.out.println("Serialized String: "+serialized);
        if(serialized.isEmpty()) {
            System.out.println("Empty root");
        }
        TreeNode deserialized = serializeAndDeserialize.deSerialize(serialized);
        System.out.println("After serialization");
        serializeAndDeserialize.printInorder(deserialized);
    }
}
