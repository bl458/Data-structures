package algorithm;

import java.util.*;

//Refer to GeeksForGeeks
public class DijkstraPQ {
    public class GraphNode implements Comparator<GraphNode> {
        int node; //Node representation. Often means the idx of the node
        int cost; //Cost of one edge going into this node 

        public GraphNode(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(GraphNode gNode1, GraphNode gNode2) {
            if (gNode1.cost < gNode2.cost) return -1;
            else if (gNode1.cost == gNode2.cost) return 0;
            else return 1;
        }
    }

    public int v; //# of vertices 
    private int[] dist; //array of min distances from src node 
    private Set<Integer> visited; //hashset of already visited nodes 
    private Queue<GraphNode> pq; //priority queue of nodes 

    public DijkstraPQ(int v) {
        this.v = v;

        dist = new int[v];
        visited = new HashSet<>();
        pq = new PriorityQueue<>();
    }

    public int[] dijkstra(int src, List<List<GraphNode>> adj) {
        pq.add(new GraphNode(src, 0));
        visited.clear();
        for (int i=0; i<v; i++) 
            dist[i] = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            GraphNode gNode = pq.poll();
            visited.add(gNode.node);
            List<GraphNode> neighbors = adj.get(gNode.node);

            for (GraphNode neighbor : neighbors) {
                if (!visited.contains(neighbor.node)) {
                    dist[neighbor.node] = Math.min(dist[neighbor.node], dist[gNode.node] + neighbor.cost);
                    pq.add(new GraphNode(neighbor.node, dist[neighbor.node]));
                }
            }
        }

        return dist;
    }
}
