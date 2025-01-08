    package graph;

    import java.util.*;
    import java.util.stream.Collectors;

    class iPair implements Comparable<iPair> {
        int first, second;

        // Constructor to store (weight, node)
        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        // Implement the compareTo method to compare by the first value
        
        @Override
        public int compareTo(iPair other) {
            return this.first - other.first; // Sort by the 'first' value (distance)
        }
    }

    public class GraphDup {
        int vertices;
        int edges;

        int[][] adjMatrix;

        public GraphDup(int vertices, int edges) {
            this.vertices = vertices;
            this.edges = edges;
            adjMatrix = new int[vertices][vertices];    
        }

        // u,v are two nodes that are connected by an edge
        public void addEdge(int u, int v) {
            // Since this is a bi-directional graph, we need to add the edge from u to v and
            // v to u
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
        }

        public int[][] getAdjMatrix() {
            return adjMatrix;
        }

        public List<Integer> getAdjList(int node) {
            List<Integer> adjList = new ArrayList<>();
            for (int v = 0; v < vertices; v++) {
                if (adjMatrix[node][v] == 1) {
                    adjList.add(v);
                }
            }
            return adjList;
        }

        public void printAdjList() {
            for (int u = 0; u < vertices; u++) {
                System.out.print(u + ": ");
                List<Integer> adjList = getAdjList(u);
                adjList.forEach(v -> System.out.print(v + " "));
                System.out.println();
            }
        }


        public ArrayList<ArrayList<iPair>>  buildCustomAdjList(int[][] graph) {
            ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
            for (int i = 0; i < graph.length; i++) {
                adj.add(new ArrayList<>());
                for (int j = 0; j < graph[i].length; j++) {
                    if (graph[i][j] != 0) {
                        adj.get(i).add(new iPair(graph[i][j], j)); // (weight,adjNode)
                    }
                }
            }
            return adj;
        }
        public List<Integer> dijkstra(int V, ArrayList<ArrayList<iPair>> adj, int src) {

            // Create a min heap (PriorityQueue) where we store pairs of (distance, node)
            PriorityQueue<iPair> pq = new PriorityQueue<>(); // No need for custom comparator, uses compareTo

            // Distance array, initialized to a large value
            int[] distance = new int[V];
            Arrays.fill(distance, Integer.MAX_VALUE); // Fill with a large number

            // Distance to the source is 0
            distance[src] = 0;

            // Push the source into the priority queue
            pq.offer(new iPair(0, src)); // (distance, node)

            // Standard Dijkstra's Algorithm loop
            while (!pq.isEmpty()) {
                iPair current = pq.poll(); // Get the node with the smallest distance
                int dist = current.first; // Current distance
                int node = current.second; // Current node

                // Traverse all the adjacent nodes
                for (iPair neighbor : adj.get(node)) {
                    int edgeWt = neighbor.first; // Edge weight
                    int adjNode = neighbor.second; // Adjacent node

                    // If a shorter path is found
                    if (dist + edgeWt < distance[adjNode]) {
                        distance[adjNode] = dist + edgeWt; // Update the distance
                        pq.offer(new iPair(distance[adjNode], adjNode)); // Push the updated distance
                    }
                }
            }

            // Convert the distance array to ArrayList<Integer> to return
            List<Integer> res = Arrays.stream(distance).boxed().collect(Collectors.toList());

            return res;
        }

        
    }
