
/*
You are given V vertices representing a graph with V nodes. 
The graph is undirected, and your task is to represent this graph using an adjacency matrix.

Adjacency Matrix: An adjacency matrix is a 2D array of size V x V where:
	matrix[i][j] = 1 indicates that there is an edge between vertex i and vertex j.
	matrix[i][j] = 0 indicates that there is no direct edge between vertex i and vertex j.

Add Edge: Implement a function to add edges between two vertices i and j. 
Since the graph is undirected, an edge from i to j implies an edge from j to i.

Display Matrix: Implement a function to display the adjacency matrix.

Input Format:
-------------
Line-1: An integer V, the number of vertices.
Line-2: An integer E, the number of edges.
Next E lines: Two integers i and j for each line, representing an edge between vertices i and j.

Output Format:
---------------
Print the adjacency matrix of the graph after adding all edges.

Constraints:
------------
*1 <= V <= 20 (Maximum of 20 vertices)
*0 <= i, j < V (Valid vertex indices)
*0 <= E <= V*(V-1)/2 (Maximum number of edges for an undirected graph)

Sample Input-1:
---------------
4
4
0 1
0 2
1 2
2 3

Sample Output-1:
----------------
0 1 1 0 
1 0 1 0 
1 1 0 1 
0 0 1 0 

Sample Input-2:
---------------
5
5
0 1
0 4
1 3
1 2
3 4

Sample Output-2:
----------------
0 1 0 0 1 
1 0 1 1 0 
0 1 0 0 0 
0 1 0 0 1 
1 0 0 1 0 

 */

import graph.*;
import java.util.*;

public class Day15P1AdjMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        sc.nextLine();
        GraphImpl g = new GraphImpl(vertices, edges);

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }
        int[][] adjMatrix = g.getAdjMatrix();

        Arrays.stream(adjMatrix)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(cell -> System.out.print(cell + " "));
                    System.out.println();
                });

        sc.close();
    }
}

// Paste this code in telescope to get 100/100 score
/*
import java.util.*;

class Graph {
    int vertices;
    int edges;

    int[][] adjMatrix;

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        adjMatrix = new int[vertices][vertices];
    }

    // u,v are two nodes that are connected by an edge
    public void addEdge(int u, int v) {
        // Since this is a bi-directional graph, we need to add the edge from u to v and
        // v to u
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public List<Integer> getAdjList(int node) {
        List<Integer> adjList = new ArrayList<>();
        for (int v = 0; v < vertices; v++) {
            if (adjMatrix[node][v] == 1) {
                adjList.add(v);
            }
        }
        return adjList;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        sc.nextLine();
        Graph g = new Graph(vertices, edges);

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }
        int[][] adjMatrix = g.getAdjMatrix();

        Arrays.stream(adjMatrix)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(cell -> System.out.print(cell + " "));
                    System.out.println();
                });

        sc.close();
    }
}
 */