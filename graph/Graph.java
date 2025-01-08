package graph;

import java.util.ArrayList;
import java.util.List;

public interface Graph {

    void addEdge(int u, int v);

    void buildGraphWithWt(int u,int v,int weight);

    void printAdjList();

    List<Integer> getAdjList(int node);

    int[][] getAdjMatrix();

    ArrayList<ArrayList<IPair>> buildCustomAdjList(int[][] graph);

    // void BFS(int start);

    // void DFS(int start);
}
