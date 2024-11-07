/*
You are given a directed graph represented by vertices and edges. 
Your task is to implement Depth-First Search (DFS) traversal from a given starting vertex. 
The graph is represented using an adjacency list, and you need to traverse the graph starting from a specified vertex using an iterative approach (using a stack).

Input Format:
-------------
Line-1: An integer V, the number of vertices in the graph.
Line-2: An integer E, the number of edges in the graph.
Line3 to E: The next E lines each contain two integers source and destination, representing an edge from the source vertex to the destination vertex.
Line-E+1: The starting vertex S from which DFS traversal should begin.

Output Format:
--------------
Line-1" Print the vertices visited in DFS order starting from the given vertex S.

Constraints:
------------
*1 ≤ V ≤ 100
*0 ≤ E ≤ V * (V - 1)
*0 ≤ source, destination, S < V

Sample Input-1:
----------------
5
8
0 1
0 4
1 0
1 2
1 3
1 4
2 3
3 4
0

Sample Output-1:
----------------
0 1 2 3 4 


Sample Input-2:
----------------
7
9
0 1
0 2
1 3
2 3
3 4
3 5
4 6
5 6
6 1
2

Sample Output-2:
----------------
2 3 4 6 1 5 
 */