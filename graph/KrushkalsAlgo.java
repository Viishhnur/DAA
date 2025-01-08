package graph;
import java.util.*;
// 
public class KrushkalsAlgo {
    private int minCost;
    int n;
    // first sort the edges based on wt in ascending order 
    public KrushkalsAlgo(int n){
        this.minCost = 0;
        this.n = n;
    }
    
    public int getMinCostSpanningTree(List<EdgeInfo> edgeInfos){
        // edgeInfos.sort(new Comparator<EdgeInfo>() {
        //     @Override
        //     public int compare(EdgeInfo e1,EdgeInfo e2){
        //         return e1.weight - e2.weight;
        //     }
        // });
        
        // sort in ascending order 
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
                System.out.println(minCost);
                djst.unionByRank(source,destination); // add a edge from source to destination
            }

        }

        return minCost;
    }
}
