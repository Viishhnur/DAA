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

//  THis method works for both 0-based and 1-based indexing
import java.util.*;
class Graph{
    private int vertices;
    private int edges;
    private List<List<Integer>> adjList;

    public Graph(int vertices,int edges){
        this.vertices = vertices;
        this.edges = edges;
        adjList = new ArrayList<>();
        for(int i = 0 ; i <= vertices  ; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u,int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void BFS(int start){
        boolean[] visited = new boolean[vertices+1];
        
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);
        visited[start] = true;

        while(!qu.isEmpty()){
            int first = qu.poll();
            // print it
            System.out.print(first + " ");
            for(int nbr : adjList.get(first)){
                if(!visited[nbr]){
                    qu.add(nbr);
                    visited[nbr] = true;
                }
            }
        }

        System.out.println();

        
    }
}
public class Day18P2BFS {
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

        g.BFS(start);

        sc.close();
    }
}
