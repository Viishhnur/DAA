/*
Akbar used to play chess with Birbal almost every evening.
Once Akbar has challanged Birbal to place the queens in each row of the board,
such that no queen should attack another queen on the board.

You are given an integer N, indicates the size of the board as N*N.
Your task is to help Birbal to find and win in this challange, 
if there is a solution, print the answer as shown in the samples
Otherwise, print "No Solution"

Input Format:
-------------
An integer N, size of the chess board.

Output Format:
--------------
Print any possible solution.


Sample Input-1:
---------------
4

Sample Output-1:
----------------
0010
1000
0001
0100

Sample Input-2:
---------------
3

Sample Output-2:
----------------
No Solution
 */
import java.util.*;
public class P1NQueens {
    private static List<List<String>> ans;
    private static List<StringBuilder> board;  // Use StringBuilder to allow modification

    private static boolean isSafe(int row, int col, List<StringBuilder> board, int n) {
        int duprow = row;
        int dupcol = col;

        // we have to check in left directions only

        // 1) check left upper diagonal row-1, col-1 till u reach 0, 0
        while (row >= 0 && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }

        // 2) Check left in the same row col--
        col = dupcol;
        row = duprow;

        while (col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            col--;
        }

        // 3) Check in the left lower diagonal, row+1, col-1 
        col = dupcol;
        while (row < n && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    private static void backtrack(int col, List<StringBuilder> board, int n) {
        if (col == n) {
            // We got 1 successful combination , convert string builder to string 
            List<String> solution = new ArrayList<>();
            for (StringBuilder sb : board) {
                solution.add(sb.toString());
            }
            ans.add(solution);
            return;
        }

        // Go through all the rows
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board.get(row).setCharAt(col, 'Q');  // Modify using setCharAt
                backtrack(col + 1, board, n);
                board.get(row).setCharAt(col, '.');  // Reset using setCharAt
            }
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        board = new ArrayList<>();

        StringBuilder s;
        for (int i = 0; i < n; i++) {
            s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(".");
            }
            board.add(s);
        }

        backtrack(0, board, n); // (col, board, ans, n)
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        
        sc.close();
    }
}
