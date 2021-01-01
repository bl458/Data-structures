package algorithm.sort;

import java.util.*;

public class TopologicalSort<T> {
    static class Edge implements Comparator<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compare(Edge e1, Edge e2) { return e1.weight - e2.weight; }
    }

    public static int[] sort(Map<Integer, List<Edge>> graph, int numNodes) {
        int[] ordering = new int[numNodes];
        boolean[] visited = new boolean[numNodes];
        
        //Next idx of ordering to fill
        int i = numNodes - 1;
        for (int at=0; at<numNodes; at++) 
            if (!visited[at]) i = dfs(i, at, graph, ordering, visited);

        return ordering;
    }

    private static int dfs(int i, int at, Map<Integer, List<Edge>> graph, int[] ordering, boolean[] visited) {
        visited[at] = true;
        List<Edge> edges = graph.get(at);
        if (edges != null) 
            for (Edge e : edges) if (!visited[e.to]) i = dfs(i, e.to, graph, ordering, visited);            

        ordering[i] = at;
        return i - 1; 
    }
}
