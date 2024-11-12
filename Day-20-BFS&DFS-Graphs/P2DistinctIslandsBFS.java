/*
You are a wedding decorator responsible for decorating a wall of size M * N using two different colored balloons. 
The balloons can either be blue or white. 
The blue-colored balloons form distinct shapes, where each shape consists of blue balloons connected in one of the four cardinal directions (up, down, left, or right). 
White balloons serve as separators between blue balloon shapes.

Blue-colored balloons are represented by the digit 1, while white-colored balloons are represented by the digit 0 in a 2D matrix. 
Your task is to count the number of distinct shapes formed by the blue balloons on the wall.

Two shapes are considered distinct if one shape cannot be exactly transformed into the other by shifting (translation).

Input Format:
-------------
Line-1: Two space-separated integers M and N, representing the size of the wall (M rows and N columns).
Line-2 to M: The next M lines each contain N space-separated integers, either 0 or 1, where 1 represents a blue balloon and 0 represents a white balloon.

Output Format:
---------------
Line-1: An integer representing the number of distinct shapes formed by blue balloons.

Constraints:
------------
*1 ≤ M, N ≤ 50
*The matrix consists only of 0s and 1s.

Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1

Explanation:
------------
In the given input, two shapes are formed by blue balloons. However, both shapes are identical in form, so the output is 1.

Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

Explanation:
-------------
There are four distinct shapes formed by the blue balloons.

 */

import java.util.*;

public class P2DistinctIslandsBFS {
    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static void bfs(int x, int y, int[][] grid, boolean[][] visited, int m, int n, int row0, int col0,
            List<List<Integer>> vec) {
        Queue<List<Integer>> qu = new LinkedList<>();
        qu.offer(Arrays.asList(x, y));
        visited[x][y] = true;
        vec.add(Arrays.asList(x - row0, y - col0));
        while (!qu.isEmpty()) {
            List<Integer> curr = qu.poll();
            int curr_x = curr.get(0);
            int curr_y = curr.get(1);

            // traverse through it's nbrs
            for (int i = 0; i < 4; i++) {
                int nx = curr_x + dx[i];
                int ny = curr_y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    qu.offer(Arrays.asList(nx, ny));
                    vec.add(Arrays.asList(nx - row0, ny - col0)); // add co-ordinates relatively
                }
            }

        }

    }

    private static int countDistinctIslands(int[][] grid, boolean[][] visited, int m, int n) {

        HashSet<List<List<Integer>>> st = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    List<List<Integer>> lst = new ArrayList<>();
                    bfs(i, j, grid, visited, m, n, i, j, lst);
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
