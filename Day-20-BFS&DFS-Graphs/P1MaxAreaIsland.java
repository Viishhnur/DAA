
/*
Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5

 */
import java.util.*;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class P1MaxAreaIsland {

    private static int bfs(int x, int y, boolean[][] visited, int[][] grid) {
        int area = 1;

        int n = grid.length;
        int m = grid[0].length;
        // 1) mark this cell as visited
        visited[x][y] = true; // (x,y) are start cell co-ordinates

        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(x, y)); // this is the starting node

        while (!qu.isEmpty()) {
            Pair pair = qu.poll();
            int row = pair.first;
            int col = pair.second;

            // now go to all 8 directions more clearly 9
            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int newRow = delrow + row;
                    int newCol = delcol + col;

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                            && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {

                        // mark it as visited
                        visited[newRow][newCol] = true;
                        // add to queue
                        qu.offer(new Pair(newRow, newCol));

                        area++;
                    }
                }
            }
        }

        return area;

    }

    private static void dfs(int x,int y,boolean[][] visited,int[][] grid,int[] area,int m,int n){
        // first mark this as visited
        visited[x][y] = true;
        
        // get adjacent nodes and mark them as visited
        for(int delrow = -1 ; delrow <= 1 ; delrow++){
            for(int delcol = -1 ; delcol <= 1 ; delcol++){
                int nx = x + delrow;
                int ny = y + delcol;

                if(nx>=0 && nx<m && ny>=0 && ny<n
                && !visited[nx][ny] && grid[nx][ny] == 1){
                    // call this function 
                    area[0]++;
                    dfs(nx, ny, visited, grid, area,m,n);
                }
            }
        }
    }

    private static int numOfIslands(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int maxArea = 1;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (!visited[i][j] && grid[i][j] == 1) { // do bfs only if it is a land

        //             maxArea = Math.max(bfs(i, j, visited, grid), maxArea);
        //         }
        //     }
        // }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) { // do bfs only if it is a land
                    int[] area = new int[1];
                    area[0] = 1; // initalize with min area
                    dfs(i, j, visited, grid, area,n,m);
                    maxArea = Math.max(area[0], maxArea);
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.print(numOfIslands(grid));

        sc.close();
    }
}
