/*
You are given an undirected, connected graph with N vertices and M edges, represented as an adjacency matrix. 
Your task is to construct the Minimum Spanning Tree (MST) of this graph using Prim's algorithm. 
The MST is a subgraph that connects all the vertices together, without any cycles, and with the minimum possible total edge weight.

The adjacency matrix of the graph is a 2D array, where graph[i][j] represents the weight of the edge between vertex i and vertex j. 
If there is no edge between vertex i and vertex j, the value will be 0.

Your goal is to write a program that reads the adjacency matrix from input and outputs the edges in the MST along with their respective weights.

Input Format:
-------------
Line-1: Line-1 contains an integer N, the number of vertices in the graph.
Line-2 to N: Each line contain N integers representing the adjacency matrix of the graph.

Output Format:
--------------
Print the edges of the MST and their corresponding weights in the format: Vertex1 - Vertex2 Weight.

Sample Input-1:
---------------
5
0 2 0 6 0
2 0 3 8 5
0 3 0 0 7
6 8 0 0 9
0 5 7 9 0

Sample Output-1:
----------------
Edge 	Weight
0 - 1	2
1 - 2	3
0 - 3	6
1 - 4	5

Explanation:
The graph has 5 vertices, and the minimum spanning tree is constructed by connecting the vertices with the least total weight.
The algorithm starts from the vertex with the smallest weight and continues to add edges with the least cost that connect the remaining unvisited vertices.

Constraints:
-------------
*1 <= N <= 1000
*0 <= weight of edge <= 10^4
*The graph is connected and undirected.

 */
import java.util.*;
import graph.*;
public class Day16P2PrimsMST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        PrimsAlgo prims = new PrimsAlgo();
        List<List<Integer>> mst = prims.getPrimsMST(n,prims.buildCustomAdjListTriplet(graph));
        mst.sort(Comparator.comparingInt(edge -> edge.get(1)));

        System.out.println("Edge\tWeight");
        for(List<Integer> edge: mst) {
            System.out.println(edge.get(0) + " - " + edge.get(1) + "\t" + graph[edge.get(0)][edge.get(1)]);
        }
        sc.close();
    }    
}

// Tessslator codes
/*

import java.util.*;

class EdgeInfo{
    public int weight;
    public int curr_node;
    public int parent;
    
    public EdgeInfo(int weight, int curr_node, int parent){
        this.weight = weight;
        this.curr_node = curr_node;
        this.parent = parent;
    }
}

class PrimsAlgo {
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

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        PrimsAlgo prims = new PrimsAlgo();
        List<List<Integer>> mst = prims.getPrimsMST(n,prims.buildCustomAdjListTriplet(graph));
        mst.sort(Comparator.comparingInt(edge -> edge.get(1)));
        
        System.out.println("Edge\tWeight");
        for(List<Integer> edge: mst) {
            System.out.println(edge.get(0) + " - " + edge.get(1) + "\t" + graph[edge.get(0)][edge.get(1)]);
        }
        sc.close();
    }    
}
 */ 