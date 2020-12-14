package algorithm;

import java.util.*;

//Refer to WilliamFiset git
public class PrimPQ {
    public class Edge implements Comparator<Edge>{
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compare(Edge e1, Edge e2) {
            if (e1.cost < e2.cost) return -1;
            else if (e1.cost == e2.cost) return 0;
            else return 0;
        }
    }

    //Inputs
    //[<nodeIdx>: [Edge1, Edge2, ...], <nodeIdx>: [Edge1, Edge2, ...], ...] 
    //# nodes = graph.size()
    private List<List<Edge>> graph; 

    //Internal
    private boolean[] visited;
    private Queue<Edge> pq;

    //Ouput
    private Edge[] mst;
    private int mstSum;

    public PrimPQ(List<List<Edge>> graph) {
        if (graph == null || graph.isEmpty()) throw new IllegalArgumentException();
        
        this.graph = graph;
        mst = new Edge[graph.size()];
    }

    public Edge[] getMst() { return mst; }

    public int getMstSum() { return mstSum; }

    //O(ElogE). Using IndexedMinHeap gives us O(ElogV), Fib heap gives us O(E + VlogV)
    public void prim() {
        pq = new PriorityQueue<>();
        visited = new boolean[graph.size()];
        visitNode(0);
        int mstLength = 0;
        //While pq is not empty && minimum spanning tree size < # nodes
        while (!pq.isEmpty() && mst.length != graph.size() - 1) {
            Edge minEdge = pq.poll();
            if (!visited[minEdge.to]) {
                visitNode(minEdge.to);
                mst[mstLength++] = minEdge;
                mstSum += minEdge.cost;
            }
        }
    }

    //For a node with index of nodeIdx, 
    //1. Mark this node visited 
    //2. Add all edges containing nodeIdx to PQ (Dont add edge if the other node in edge was already visited)
    private void visitNode(int nodeIdx) {
        visited[nodeIdx] = true;
        List<Edge> edges = graph.get(nodeIdx); //List of all edges containing nodeIdx
        for (Edge edge : edges) 
            if (!visited[edge.to]) pq.add(edge);
    }
}
