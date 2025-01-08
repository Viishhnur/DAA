/*
You are given a directed graph represented by vertices and edges. 
Your task is to implement Depth-First Search (DFS) traversal from a given starting vertex. 
The graph is represented using an adjacency list, and you need to traverse the graph starting from a specified vertex using an iterative approach (using a stack).

Input Format:
-------------
Line-1: An integer V, the number of vertices in the graph.
Line-2: An integer E, the number of edges in the graph.
Line3 to E: The next E lines each contain two integers source and destination, representing an edge from the source vertex to the destination vertex.
Line-E+1: The starting vertex S from which DFS traversal should begin.

Output Format:
--------------
Line-1" Print the vertices visited in DFS order starting from the given vertex S.

Constraints:
------------
*1 ≤ V ≤ 100
*0 ≤ E ≤ V * (V - 1)
*0 ≤ source, destination, S < V

Sample Input-1:
----------------
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
----------------
0 1 2 3 4 


Sample Input-2:
----------------
7
9
0 1
0 2
1 3
2 3
3 4
3 5
4 6
5 6
6 1
2

Sample Output-2:
----------------
2 3 4 6 1 5 
 */

import java.util.*;

class Graph {
    private int vertices;
    private int edges;
    private List<List<Integer>> adjList;

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        adjList = new ArrayList<>();
        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[vertices + 1];

        Stack<Integer> st = new Stack<>();
        st.add(start);
        visited[start] = true;

        while (!st.isEmpty()) {
            int first = st.pop();
            // print it
            System.out.print(first + " ");
            for (int nbr : adjList.get(first)) {
                if (!visited[nbr]) {
                    st.add(nbr);
                    visited[nbr] = true;
                }
            }
        }

        System.out.println();

    }

    public void dfs2(int node,boolean[] visited){
        visited[node] = true;
        System.out.print(node + " ");

        for(int nbr : adjList.get(node)){
            if(!visited[nbr]){
                dfs2(nbr,visited);
            }
        }

    }

}

public class Day18P3DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        Graph g = new Graph(vertices, edges);

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        int start = sc.nextInt();

        g.DFS(start);
        
        boolean[] visited = new boolean[vertices+1];
        System.out.print("New dfs is : ");
        g.dfs2(start, visited);
        sc.close();
    }
}
