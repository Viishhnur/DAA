/*
Given a directed graph represented by an adjacency matrix, where each entry graph[i][j] represents the weight of the edge from vertex i to vertex j. If graph[i][j] is 0, it means there is no direct edge between i and j.

Your task is to determine the shortest paths from a given source vertex to all other vertices using Dijkstra’s algorithm.

Input Format:
-------------
Line-1: An integer N, representing the number of vertices in the graph.
Next-N lines: Each line contains N space-separated integers representing the adjacency matrix graph.
Last-line: An integer src, representing the source vertex.

Output Format:
--------------
A line that says: "Vertex 		Distance from Source".
Followed by N lines, each containing the vertex number and its shortest distance from the source.

Constraints:
------------
*1 <= N <= 100
*0 <= graph[i][j] <= 1000
*0 <= src < N
*All weights are non-negative integers.

Sample Input-1:
---------------
5
0 6 5 0 13
6 0 12 9 5
5 12 0 0 0
0 9 0 0 7
13 5 0 7 0
2

Sample Output-1:
----------------
Vertex           Distance from Source
0                5
1                11
2                0
3                20
4                16

Sample Input-2:
---------------
9
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0
5

Sample Output-2:
----------------
Vertex           Distance from Source
0                11
1                12
2                4
3                11
4                10
5                0
6                2
7                3
8                6
 */

import graph.*;
import java.util.*;

public class Day15P3ShortestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of vertices in the graph

        // Step 1: Read the adjacency matrix
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int src = sc.nextInt(); // Source vertex
        sc.close();

        // Step 2: Use your GraphImpl to represent the graph
        GraphImpl g = new GraphImpl(N, N);

        // Step 3: Build the custom adjacency list using the adjacency matrix
        ArrayList<ArrayList<IPair>> adj = g.buildCustomAdjList(graph);

        // Step 4: Use Dijkstra's algorithm to compute the shortest paths
        DijkstraAlgorithm dij = new DijkstraAlgorithm();
        
        List<Integer> result = dij.dijkstraUsingSet(N, adj, src);  // using set is little more efficient than using Priority queue
        // List<Integer> result = dij.dijkstraUsingPQ(N, adj, src); // this is using Priority queue


        // Step 5: Print the results
        System.out.println("Vertex           Distance from Source");
        for (int i = 0; i < N; i++) {
            System.out.println(i + "                " + result.get(i));
        }
    }
}

// Tesselator code 
/*
import java.util.*;
import java.util.stream.Collectors;

class iPair implements Comparable<iPair> {
    int first, second;

    // Constructor to store (weight, node)
    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    // Implement the compareTo method to compare by the first value
    
    @Override
    public int compareTo(iPair other) {
        return this.first - other.first; // Sort by the 'first' value (distance)
    }
}

class Graph {
    int vertices;
    int edges;


    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public ArrayList<ArrayList<iPair>>  buildCustomAdjList(int[][] graph) {
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    adj.get(i).add(new iPair(graph[i][j], j)); // (weight,adjNode)
                }
            }
        }
        return adj;
    }
    public List<Integer> dijkstra(int V, ArrayList<ArrayList<iPair>> adj, int src) {

        // Create a min heap (PriorityQueue) where we store pairs of (distance, node)
        PriorityQueue<iPair> pq = new PriorityQueue<>(); 

        // Distance array, initialized to a large value
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE); // Fill with a large number

        // Distance to the source is 0
        distance[src] = 0;

        // Push the source into the priority queue
        pq.offer(new iPair(0, src)); // (distance, node)

        
        while (!pq.isEmpty()) {
            iPair current = pq.poll(); // Get the node with the smallest distance
            int dist = current.first; // Current distance
            int node = current.second; // Current node

            // Traverse all the adjacent nodes
            for (iPair neighbor : adj.get(node)) {
                int edgeWt = neighbor.first; // Edge weight
                int adjNode = neighbor.second; // Adjacent node

                // If a shorter path is found
                if (dist + edgeWt < distance[adjNode]) {
                    distance[adjNode] = dist + edgeWt; // Update the distance
                    pq.offer(new iPair(distance[adjNode], adjNode)); // Push the updated distance
                }
            }
        }

        // Convert the distance array to ArrayList<Integer> to return
        List<Integer> res = Arrays.stream(distance).boxed().collect(Collectors.toList());

        return res;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int src = sc.nextInt();
        sc.close();
        
        Graph g = new Graph(N, N);

        // Now build the custom adjacency list from the graph ArrayList<ArrayList<iPair>> adj and pass it to func
        List<Integer> result = g.dijkstra(N, g.buildCustomAdjList(graph), src);
        System.out.println("Vertex           Distance from Source");
        for (int i = 0; i < N; i++) {
            System.out.println(i + "                " + result.get(i));
        }
    }
}


 */