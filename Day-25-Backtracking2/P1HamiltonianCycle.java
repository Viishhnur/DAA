
/*
N cities are connected through roads, the cities are numbered from 0 to N-1. 
The roadmaps are given as a grid of size N*N, roadmap[][], 
the grid contains 0 and 1 as values grid[i][j]=0, indicates no road 
between i to j cities, grid[i][j]=1, indicates a road between i and j cities.

You are given an integer N, and the roadmap[][]of size N*N.
Your task is to find that there exists a loop in the roadmap, such that 
there exists a route consists of all the cities eaxctly once and the 
last city in the route should be connected to first city of the same route directly.

If you found such route print the route, otherwise print "No Solution"

Input Format:
-------------
Line-1: An integer N, size of the chess board.
Next N lines: N space separated integers, 0 or 1.

Output Format:
--------------
Print any possible route or "No Solution".

Sample Input-1:
---------------
5
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 1
0 1 1 1 0

Sample Output-1:
----------------
0  1  2  4  3  0

Sample Input-2:
---------------
5
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 0
0 1 1 0 0

Sample Output-2:
----------------
No Solution

 */
import java.util.*;

public class P1HamiltonianCycle {

    private static boolean isSafe(int curr_vertex, int[][] graph, int[] path, int curr_pos, int vertices) {
        // this method checks if there is a edge between prevosuly added and current one
        // and checks if vertex is not included prior
        if (graph[path[curr_pos - 1]][curr_vertex] == 0)
            return false;

        for (int i = 0; i < curr_pos; i++) {
            if (path[i] == curr_vertex) {
                // it means this vertex was already included
                return false;
            }
        }

        return true;

    }

    private static boolean hamCycleUntil(int[][] graph, int[] path, int curr_pos, int vertices) {
        if (curr_pos == vertices) {
            // check if there is a edge between this and first node
            if (graph[path[curr_pos - 1]][path[0]] == 1) {
                return true;
            }
            return false;
        }

        // don't worry try for different vertices
        for (int v = 1; v < vertices; v++) {
            if (isSafe(v, graph, path, curr_pos, vertices)) {
                path[curr_pos] = v;

                if (hamCycleUntil(graph, path, curr_pos + 1, vertices))
                    return true;

                // now backtrack otherwise
                path[curr_pos] = -1;
            }
        }

        // if no vertex can be added return false
        return false;
    }

    private static void isHamCycleThere(int[][] graph, int n) {
        int path[] = new int[n];
        Arrays.fill(path, -1);

        // let's start from vertex 0
        path[0] = 0;

        if (!hamCycleUntil(graph, path, 1, n)) {
            System.out.println("No Solution");
            return;
        }

        // now there is a cycle print it
        for (int vertex : path) {
            System.out.print(vertex + " ");
        }

        // print the first vertex to show the complete cycle
        System.out.print(path[0]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        isHamCycleThere(graph, n);
        sc.close();
    }
}

// class HamiltonianCycle
// {
// 	static int V;
	
// 	void hamCycle(int graph[][]){
// 		//Write your code here
// 	}
    
//     //Your utility functions goes here
    
// 	public static void main(String args[]){
// 		Scanner sc=new Scanner(System.in);
// 		V = sc.nextInt();
// 		int graph[][]=new int[V][V];

// 		for(int i=0;i<V;i++)
// 			for(int j=0;j<V;j++)
// 				graph[i][j]=sc.nextInt();

// 		HamiltonianCycle obj = new HamiltonianCycle();
// 		obj.hamCycle(graph);
// 	}
// }