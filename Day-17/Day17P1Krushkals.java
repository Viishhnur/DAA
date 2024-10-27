/*
You are given a connected, undirected, and weighted graph with V vertices and E edges. 
Your task is to implement Kruskal's Algorithm to find the Minimum Spanning Tree (MST) of the given graph. 
The graph is represented using an edge list, where each edge connects two vertices with a specific weight.

Kruskal’s Algorithm is a greedy algorithm that sorts all the edges in non-decreasing order of their weight and picks the smallest edge, as long as it doesn’t form a cycle with the already included edges in the MST. The algorithm stops when exactly V-1 edges have been added to the MST.

Input Format:
--------------
Line-1: Two integers V and E, where V is the number of vertices and E is the number of edges.
Line-2 to E: Three integers each: u, v, and w, where u is the source vertex, v is the destination vertex, and w is the weight of the edge connecting u and v.

Output Format:
---------------
Line-1: An integer, the Minimum Cost of the spanning tree.

Constraints:
------------
*2 ≤ V ≤ 100
*1 ≤ E ≤ V(V-1)/2
*The graph is connected and undirected.
*Weights of the edges are positive integers.

Sample Input-1:
---------------
4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4

Sample Output-1:
----------------
19

Sample Input-2:
---------------
3 3
0 1 1
1 2 2
0 2 3

Sample Output-2:
----------------
3

 */
import graph.*;
import java.util.*;
public class Day17P1Krushkals{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        List<EdgeInfo> edgeInfos = new ArrayList<>();
        for(int i = 0 ; i < edges ; i++){
            // creating graph adj List as wt , source , destination
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int wt = sc.nextInt();
            edgeInfos.add(new EdgeInfo(wt, destination, source)); // (wt,currNode,parent)
        }

        sc.close();

        KrushkalsAlgo krush = new KrushkalsAlgo(vertices);

        System.out.println("The spanning tree minimum weight is : " + krush.getMinCostSpanningTree(edgeInfos));
    }

}

// Paste this in tesselator
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

class DisjointSet{
    //  We need two data structures for Disjoint set those are parent and node , since we are using 1 based indexing 
    int[] parent,rank;

    public DisjointSet(int noOfNodes){
        rank = new int[noOfNodes+1]; // default rank of all the nodes is zero
        parent = new int[noOfNodes+1];
        for(int i = 0 ; i <= noOfNodes ; i++){
            parent[i] = i;
        }
    }

    // now create a method called find Parent for a node
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findParent(parent[node]); // this is done for path compression
    }

    public void unionByRank(int u,int v){
        // 1) Find ultimate parent of u , v
        int pu = findParent(u);
        int pv = findParent(v);

        // now check if ultimate parents are same
        if(pu == pv) return;
        // connect smaller rank node to larger rank node
        if(rank[pu] < rank[pv]){
            // smaller ka parent larger ban jayega
            parent[pu] = pv;
        }
        else if(rank[pv] < rank[pu]){
            parent[pv] = pu;
        }
        else{
            parent[pv] = pu;
            rank[pu]++; // depth increase for that particular node
        }
    }

    public boolean belongsToSameComponent(int u,int v){
        return findParent(u) == findParent(v);
    }
}

class KrushkalsAlgo {
    private int minCost;
    int n;
    public KrushkalsAlgo(int n){
        this.minCost = 0;
        this.n = n;
    }
    
    public int getMinCostSpanningTree(List<EdgeInfo> edgeInfos){
        
        // first sort the edges based on wt in ascending order 
        edgeInfos.sort((e1,e2) -> e1.weight - e2.weight);
        // Now create a disjoint set data structure
        DisjointSet djst = new DisjointSet(n); // initialize with number of nodes
        // since the edges are now in sorted order , traverse through each edge and decide whether to include the edge or not
        for(EdgeInfo edges : edgeInfos){
            int wt = edges.weight;
            int destination = edges.curr_node;
            int source = edges.parent;

            // Now check if adding this edge into current config will form any loop or check if the source and destination are present in same componenet
            // if both are in different components then add the wt to ans
            if(!djst.belongsToSameComponent(source, destination)){
                minCost += wt;
                djst.unionByRank(source,destination); // add a edge from source to destination
            }

        }

        return minCost;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        List<EdgeInfo> edgeInfos = new ArrayList<>();
        for(int i = 0 ; i < edges ; i++){
            // creating graph adj List as wt , source , destination
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int wt = sc.nextInt();
            edgeInfos.add(new EdgeInfo(wt, destination, source)); // (wt,currNode,parent)
        }

        sc.close();

        KrushkalsAlgo krush = new KrushkalsAlgo(vertices);

        System.out.print(krush.getMinCostSpanningTree(edgeInfos));
    }

}

 */