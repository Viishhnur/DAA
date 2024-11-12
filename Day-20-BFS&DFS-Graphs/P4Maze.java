/*
You are given an N×N grid that represents a maze. 
In this maze: Each cell contains either a 0 or 1.
 --1 indicates an open path where you can walk.
 --0 indicates a dead-end where you cannot pass.

You start at the top-left corner of the maze, i.e., position (0, 0).
Your target is to reach the bottom-right corner of the maze, i.e., position (N-1, N-1).
In the maze, you can move only right or down from each cell.

Objective: Determine if there exists a path from the start (0, 0) to the end (N-1, N-1) that passes only through cells marked 1. 
If such a path exists, return true; otherwise, return false.

Input Format:
-------------
Line-1: The first line contains an integer N, the size of the square grid.
Line 2 to N: The next N lines each contain N space-separated integers (either 0 or 1), representing the maze.

Output Format:
--------------
Line-1: Print true if a path exists from (0, 0) to (N-1, N-1), otherwise print false.

Constraints:
------------
* 1 ≤ N ≤ 100
* Each cell in the grid is either 0 or 1.

Sample Input-1:
---------------
4
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

Sample Output-1:
----------------
true

Explanation: There exists a path from (0, 0) to (3, 3).

Sample Input-2:
---------------
4
1 1 0 0
1 0 0 1
0 1 1 0
1 0 0 1

Sample Output-2:
----------------
false

Explanation: There is no valid path from (0, 0) to (3, 3).
 */
import java.util.*;

class Pair{
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    
}
public class P4Maze {
    private static final int[] dx = {0,1}; // since we can move only right and down
    private static final int[] dy = {1,0};

    private static void bfs(int x,int y,int[][] grid,boolean[][] visited,int n){
        Queue<Pair> qu = new LinkedList<>();
        visited[x][y] = true;
        qu.offer(new Pair(x, y));

        
        while(!qu.isEmpty()){
            Pair p = qu.poll();
            int curr_x = p.first;
            int curr_y = p.second;

            // traverse throguh the nbrs
            for(int i = 0 ; i < 2 ; i++){
                int nx = curr_x + dx[i];
                int ny = curr_y + dy[i];

                if(nx < n && ny < n && !visited[nx][ny] && grid[nx][ny] == 1){
                    visited[nx][ny] = true;
                    qu.offer(new Pair(nx, ny));
                }
            }
        }
    }
    private static void dfs(int x,int y,int[][] grid,boolean[][] visited,int n){
        visited[x][y] = true;

        // traverse through the nbrs
        for(int i = 0 ; i < 2 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<n && ny<n && !visited[nx][ny] && grid[nx][ny] == 1){
                dfs(nx, ny, grid, visited, n);
            }
        }
    }
    private static boolean canReach(int[][] grid,boolean[][] visited,int n){
        // dfs(0,0,grid,visited,n);
        bfs(0, 0, grid, visited, n);
        return visited[n-1][n-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = sc.nextInt();
            }   
        }

        boolean[][] visited = new boolean[n][n];
        System.out.println(canReach(grid, visited, n) ? "true" : "false");


        
        sc.close();
    }

   
}
