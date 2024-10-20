package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphImpl implements Graph {
    private int vertices;
    private int edges;
    private int[][] adjMatrix;

    public GraphImpl(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        adjMatrix = new int[vertices][vertices];
    }

    @Override
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    @Override
    public void buildGraphWithWt(int u,int v,int weight){
        adjMatrix[u][v] = weight;
        adjMatrix[v][u] = weight;
    }
    @Override
    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    @Override
    public List<Integer> getAdjList(int node) {
        List<Integer> adjList = new ArrayList<>();
        for (int v = 0; v < vertices; v++) {
            if (adjMatrix[node][v] != 0) {
                adjList.add(v);
            }
        }
        return adjList;
    }

    @Override
    public void printAdjList() {
        for (int u = 0; u < vertices; u++) {
            System.out.print(u + ": ");
            List<Integer> adjList = getAdjList(u);
            adjList.forEach(v -> System.out.print(v + " "));
            System.out.println();
        }
    }

    @Override
    public ArrayList<ArrayList<IPair>> buildCustomAdjList(int[][] graph) {
        ArrayList<ArrayList<IPair>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    adj.get(i).add(new IPair(graph[i][j], j)); // (weight, adjNode)
                }
            }
        }
        return adj;
    }
}
