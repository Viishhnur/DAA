
/*
Pranav has a puzzle board filled with square boxes in the form of a grid.
Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

The puzzle board has some patterns formed with boxes in it, 
the patterns may be repeated. The patterns are formed with boxes (1's) only, 
that are connected horizontally and vertically but not diagonally.

Pranav wants to find out the number of unique patterns in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of unique patterns in the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated characters ['0','1'].

Output Format:
--------------
Print an integer, the number of unique patterns in the puzzle board.


Sample Input-1:
---------------
5 5
0 1 0 1 1
1 1 1 0 1
0 1 0 1 0
1 0 1 1 1
1 1 0 1 0

Sample Output-1:
----------------
3

Explanation-1:
------------
The unique patterns are as follows:
  1			 1 1		1 
1 1 1		   1  	,	1 1
  1		,	
   
   
Sample Input-2:
---------------
6 6
1 1 0 0 1 1
1 0 1 1 0 1
0 1 0 1 0 0
1 1 0 0 0 1
0 0 1 0 1 1
1 1 0 1 0 0

Sample Output-2:
----------------
5

Explanation-2:
------------
The unique patterns are as follows:
1 1		1 1		    1			1 1 	1
1   	  1         1 1 			

 */
/*
The intution is to identify the pattern and store them in a set , and return the set size 
 */
import java.util.*;

public class P3DistinctIsnlandsDFS {

  private static void dfs(int row, int col, int[][] grid, boolean[][] visited, int m, int n, List<List<Integer>> vec,
      int row0, int col0) {
    visited[row][col] = true;
    vec.add(Arrays.asList(row - row0, col - col0)); // subtract from base pair

    int delrow[] = { -1, 0, 1, 0 };
    int delcol[] = { 0, -1, 0, 1 };

    for (int i = 0; i < 4; i++) {
      int nrow = row + delrow[i];
      int ncol = col + delcol[i];

      if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !visited[nrow][ncol] && grid[nrow][ncol] == 1) {
        dfs(nrow, ncol, grid, visited, m, n, vec, row0, col0);
      }
    }
  }

  private static int countDistinctIslands(int[][] grid, boolean[][] visited, int m, int n) {

    HashSet<List<List<Integer>>> st = new HashSet<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          List<List<Integer>> lst = new ArrayList<>();
          dfs(i, j, grid, visited, m, n, lst, i, j);
          st.add(lst);
        }
      }
    }

    return st.size();
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

    boolean[][] visited = new boolean[m][n];

    System.out.println(countDistinctIslands(grid, visited, m, n));

    sc.close();
  }
}
