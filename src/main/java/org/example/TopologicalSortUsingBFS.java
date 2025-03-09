package org.example;

import java.util.*;

// Kahns algorithm

// insert all nodes with indegree 0;
public class TopologicalSortUsingBFS {
    public static void main(String[] args) {
        TopologicalSortUsingBFS topologicalSortUsingBFS = new TopologicalSortUsingBFS();
        System.out.println("Enter the number of vertices in the graph: ");
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            System.out.println("Enter the number of edges for vertex " + i);
            int edges = scan.nextInt();
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < edges; j++) {
                int edge = scan.nextInt();
                innerList.add(edge);
            }
            adj.add(i, innerList);
        }
        int[] inDegreeArray = topologicalSortUsingBFS.calculateInDegree(adj,v);
        int[] sortedArray = topologicalSortUsingBFS.sort(v, adj, inDegreeArray);
        System.out.println("After Sorting:" + Arrays.toString(sortedArray));
    }

    public int[] sort(int v, ArrayList<ArrayList<Integer>> adj, int[] inDegreeArray) {
        int[] result = new int[v];
        Queue<Integer> queue= new LinkedList<>();
        int j=0;
        for (int k=0; k < inDegreeArray.length; k++) {
            if (inDegreeArray[k] == 0) {
                queue.add(k);
            }
        }

        while(!queue.isEmpty()) {
            int front = queue.peek();
            queue.remove();
            result[j++] = front;
            ArrayList<Integer> edges = adj.get(front);
            for(int edge: edges) {
                inDegreeArray[edge]--;
                if(inDegreeArray[edge]==0) {
                    queue.add(edge);
                }
            }
        }
        return  result;

    }

    public int[] calculateInDegree(ArrayList<ArrayList<Integer>> adj, int v) {
        int[] inDegreeArray = new int[v];
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> edges = adj.get(i);
            for (int edge : edges) {
                inDegreeArray[edge]++;
            }
        }
        return inDegreeArray;
    }


}
