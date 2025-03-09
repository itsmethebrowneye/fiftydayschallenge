package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// In a directed acyclic graph with liner ordering of vertices having  an edge U,V such that, U always appears before V.
public class TopologicalSort {

    // TC: O(v+e)
    // whenever the dfs is completed, you push it to the stack
    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();

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

        int[] sortedArray = topologicalSort.sort(v, adj);
        System.out.println("After Sorting:" + Arrays.toString(sortedArray));
    }

    public void dfs(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        for (int it : adj.get(node)) {
            if (visited[it] == 0) {
                dfs(it, visited, st, adj);
            }
        }
        st.push(node);
    }

    public int[] sort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, stack, adj);
            }
        }
        int[] finalArray = new int[v];
        int i = 0;
        while (!stack.isEmpty()) {
            int vertex = stack.peek();
            finalArray[i++] = vertex;
            stack.pop();
        }
        return finalArray;
    }
}
