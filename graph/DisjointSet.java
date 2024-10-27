package graph;

public class DisjointSet{
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
        int pu = parent[u];
        int pv = parent[v];

        // now check if ultimate parents are same
        if(pu == pv) return;

        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }
        else if(rank[pv] < rank[pu]){
            parent[pv] = pu;
        }
        else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    public boolean belongsToSameComponent(int u,int v){
        return findParent(u) == findParent(v);
    }
}