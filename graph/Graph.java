package graph;
import java.util.List;
import java.util.ArrayList;
public class Graph {
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
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public List<Integer> getAdjList(int u) {
        List<Integer> adjList = new ArrayList<>();
        for (int v = 0; v < vertices; v++) {
            if (adjMatrix[u][v] == 1) {
                adjList.add(v);
            }
        }
        return adjList;
    }

}