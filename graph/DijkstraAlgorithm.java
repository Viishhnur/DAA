package graph;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstraAlgorithm {

    public List<Integer> dijkstraUsingPQ(int V, ArrayList<ArrayList<IPair>> adj, int src) {
        PriorityQueue<IPair> pq = new PriorityQueue<>();
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;
        pq.offer(new IPair(0, src));

        while (!pq.isEmpty()) {
            IPair current = pq.poll();
            int dist = current.first;
            int node = current.second;

            for (IPair neighbor : adj.get(node)) {
                int edgeWt = neighbor.first;
                int adjNode = neighbor.second;

                if (dist + edgeWt < distance[adjNode]) {
                    distance[adjNode] = dist + edgeWt;
                    pq.offer(new IPair(distance[adjNode], adjNode));
                }
            }
        }

        return Arrays.stream(distance).boxed().collect(Collectors.toList());
    }


    public List<Integer> dijkstraUsingSet(int V, ArrayList<ArrayList<IPair>> adj, int src) {

        // Create a TreeSet (similar to set in C++) for storing the nodes
        // as a pair {dist, node} where dist is the distance from the source to the node.
        // TreeSet automatically sorts based on the first element (dist).
        TreeSet<IPair> st = new TreeSet<>(Comparator.comparingInt(a -> a.first));

        // / Initialising dist array with a large value to indicate that
        // the nodes are unvisited initially. This array will hold the
        // distance from the source to the nodes.
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

       // Insert the source with distance 0 into the set.
       st.add(new IPair(0,src));
       distance[src] = 0;

        while (!st.isEmpty()) {
            IPair current = st.pollFirst();
            int dist = current.first;
            int node = current.second;

            for (IPair neighbor : adj.get(node)) {
                int edgeWt = neighbor.first;
                int adjNode = neighbor.second;

                if (dist + edgeWt < distance[adjNode]) {
                    // Remove the current distance if it was visited previously at a greater cost.
                    if(distance[adjNode]!=Integer.MAX_VALUE){
                        st.remove(new IPair(distance[adjNode],adjNode));
                    }
                    distance[adjNode] = dist + edgeWt;
                    st.add(new IPair(distance[adjNode], adjNode));
                }
            }
        }

        return Arrays.stream(distance).boxed().collect(Collectors.toList());
    }


}
