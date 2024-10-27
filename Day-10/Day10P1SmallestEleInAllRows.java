/*
You are given an m x n matrix mat where each row is sorted in non-decreasing order.

Your task is to find the smallest common element in all rows. If there is no common element, return -1.

Input Format:
--------------
Line-1: Two integers m and n, representing the number of rows and columns, respectively.
Line-2: The next m lines contain n space-separated integers each, representing the elements of the matrix. Each row of the matrix is sorted in non-decreasing order.

Output Format:
---------------
Line-1: Print a single integer, the smallest common element in all rows. If no common element exists, print -1.

Constraints:
-------------
1 ≤ m, n ≤ 500
1 ≤ mat[i][j] ≤ 10^4
Each row is sorted in non-decreasing order.

Sample Input-1:
----------------
3 4
1 2 3 4
2 3 5 7
3 5 6 7

Sample Output-1:
-----------------
3

Explanation: The number 3 is the smallest common element in all rows.


Sample Input-2:
---------------
2 3
1 2 3
4 5 6

Sample Output-2:
----------------
-1

Explanation: There is no common element in all rows, so the output is -1.
 */

import java.util.Scanner;

class Day10P1SmallestEleInAllRows {

    private static boolean binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public static int smallestCommonElement(int[][] mat) {
        if (mat.length == 1)
            return mat[0][0];

        int lastEle = mat[0][mat[0].length - 1]; // Last element of the first row

        // Iterate over each element of the first row
        for (int ele : mat[0]) {
            int count = 1;
            boolean isCommon = true;

            for (int i = 1; i < mat.length; i++) {
                // If the last element of the first row is less than the first element of any other row, there’s no common element
                if (lastEle < mat[i][0]) {
                    isCommon = false;
                    break;
                }

                if (binarySearch(mat[i], 0, mat[i].length - 1, ele))
                    count++;
                else {
                    isCommon = false;
                    break;
                }
            }

            if (isCommon && count == mat.length)
                return ele;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        sc.close();
        System.out.println(smallestCommonElement(arr));
    }
}

