package algorithm.graph;

import java.util.*;

public class Graph {
    private int v; //Number of verticies
    private LinkedList<Integer>[] adj; //Adjacency List 

    public Graph(int v) {
        this.v = v;
        for (int i=0; i<v; i++) 
            adj[i] = new LinkedList<Integer>();
    }

    public void addEdge(int from, int to) { adj[from].add(to); }

    public void dfsRecur(int source) {
        if (source < 0 || source >= adj.length) throw new IllegalArgumentException("Invalid source vertex");
        
        boolean[] visited = new boolean[v];
        dfsRecurHelp(source, visited);
    }

    private void dfsRecurHelp(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> iter = adj[vertex].listIterator();
        while (iter.hasNext()) {
            int neighbor = iter.next();
            if (!visited[neighbor]) dfsRecurHelp(neighbor, visited);
        }
    }

    public void dfsIter(int source) {
        if (source < 0 || source >= adj.length) throw new IllegalArgumentException("Invalid source vertex");

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        stack.push(source);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            visited[vertex] = true;
            System.out.print(vertex + " ");

            Iterator<Integer> iter = adj[vertex].listIterator();
            while (iter.hasNext()) {
                int neighbor = iter.next();
                if (!visited[neighbor]) stack.push(neighbor);
            }
        }
    }

    public void bfsIter(int source) {
        if (source < 0 || source >= adj.length) throw new IllegalArgumentException("Invalid source vertex");

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        //Visit source 
        visited[source] = true;
        System.out.print(source + " ");
        queue.offer(source);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            Iterator<Integer> iter = adj[vertex].iterator();
            while (iter.hasNext()) {
                int neighbor = iter.next();
                //Visit neighbor if not visited
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    System.out.print(source + " ");
                    queue.offer(neighbor);
                }
            }
        }
    }
}
