package graph;

import java.util.*;

public class PrimsAlgo {
    private int mstSum;
    private List<List<Integer>> mst;

    // Constructor to initialize mstSum and mst list
    public PrimsAlgo() {
        mstSum = 0;
        mst = new ArrayList<>();
    }


    // Method to build a custom adjacency list using EdgeInfo triplets
    public ArrayList<ArrayList<EdgeInfo>> buildCustomAdjListTriplet(int[][] graph) {
        ArrayList<ArrayList<EdgeInfo>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>()); // Initialize the adjacency list for each vertex
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    adj.get(i).add(new EdgeInfo(graph[i][j], j, i)); // (weight, adjNode, currentNode)
                }
            }
        }
        return adj;
    }

    // Prim's algorithm to find the MST
    public List<List<Integer>> getPrimsMST(int v, ArrayList<ArrayList<EdgeInfo>> adj) {
        // Create a min-heap (PriorityQueue) based on edge weights
        PriorityQueue<EdgeInfo> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight)); 

        boolean[] visited = new boolean[v]; // Mark visited vertices

        // Initially push the starting node (0 in this case)
        pq.offer(new EdgeInfo(0, 0, -1)); // (weight, current_node, parent)

        while (!pq.isEmpty()) {
            // Get the top element from the priority queue
            EdgeInfo edgeInfo = pq.poll(); 

            int wt = edgeInfo.weight;
            int node = edgeInfo.curr_node;
            int parent = edgeInfo.parent;

            // Check if the node is not already visited
            if (!visited[node]) {
                // 1. Mark the node as visited
                visited[node] = true;

                // 2. Add the weight to the total MST sum
                mstSum += wt;

                // 3. Add the edge (parent, node) to the MST (ignore the first -1 parent)
                if (parent != -1) {
                    mst.add(Arrays.asList(parent, node));
                }

                // 4. Traverse adjacent nodes of the current node
                for (EdgeInfo neighbor : adj.get(node)) {
                    int adjNode = neighbor.curr_node;
                    int edgeWeight = neighbor.weight;

                    // If the adjacent node is not visited, push it to the priority queue
                    if (!visited[adjNode]) {
                        pq.offer(new EdgeInfo(edgeWeight, adjNode, node));
                    }
                }
            }
        }
        return mst; // Return the list of MST edges
    }

    // Method to get the total sum of the MST
    public int getMstSum() {
        return mstSum;
    }

}
