/*
You are given an undirected graph represented by vertices and edges. 
Your task is to implement Breadth-First Search (BFS) traversal from a given starting vertex. 
The graph is represented using an adjacency list, and you need to traverse the graph starting from a specified vertex.

Input Format:
--------------
Line-1: An integer V, the number of vertices.
Line-2: An integer E, the number of edges.
Line-3 to E: The next E lines contain two integers source and destination, representing an edge between the two vertices in the graph.
Line-E+1: The starting vertex S from which BFS traversal should begin.

Output Format:
---------------
Line-1: Print the vertices visited in BFS order starting from the given vertex S.

Constraints:
------------
*1 ≤ V ≤ 100
*0 ≤ E ≤ V * (V - 1)
*0 ≤ source, destination, S < V

Sample Input-1:
---------------
5
8
0 1
0 4
1 0
1 2
1 3
1 4
2 3
3 4
0

Sample Output-1:
-----------------
0 1 4 2 3 

Sample Input-1:
---------------
4
4
0 1
0 2
1 3
2 3
2

Sample Output-2:
----------------
2 0 3 1 

 */
import graph.*;
import java.util.*;
public class Day18P2BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        GraphImpl g = new GraphImpl(vertices, edges);

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        int start = sc.nextInt();
        g.BFS(start);

        sc.close();
    }
}
