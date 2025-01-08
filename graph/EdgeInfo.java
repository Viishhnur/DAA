package graph;
public class EdgeInfo{
    public int weight;
    public int curr_node;
    public int parent;
    
    public EdgeInfo(int weight, int curr_node, int parent){
        this.weight = weight;
        this.curr_node = curr_node;
        this.parent = parent;
    }
}