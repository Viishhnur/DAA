/*
Mr Abdul planned to visit all the tourist paths in a city.
There are P number of tourist places connected using some routes 
in a city, the routes are one-directional.

Your task is to help Mr Abdul, to find the shortest routes between every pair 
of tourist-places in the city.

Input Format:
------------------
Line-1: An integer P, number of places.
Next P lines: P space separated integers, the routes[][].

Value 99 represents infinity (Large value)

Output Format:
--------------------
Print the shortest distance routes[][].

Sample Input-1:
--------------------
4
0 5 99 10
99 0 3 99
99 99 0 1
99 99 99 0

Sample Output-1:
----------------------
0 5 8 9
INF 0 3 4
INF INF 0 1
INF INF INF 0


Sample Input-2:
--------------------
5
0 4 5 6 99
99 0 5 99 10
1 99 0 3 99
2 99 99 0 1
1 99 99 99 0

Sample Output-2:
----------------------
0 4 5 6 7
6 0 5 8 9
1 5 0 3 4
2 6 7 0 1
1 5 6 7 0
 */

 import java.util.*;
 class AllPairShortestPath {
     private static void shortestDistance(int[][] mat) {
         // Code here
         int n = mat.length;
         
         for(int k = 0 ; k < n ; k++){
             for(int i = 0 ; i < n ; i++){
                 for(int j = 0 ; j < n ; j++){
                     // treat k as intermediate node and check if we can reach j from i via k 
                     // if yes update the minimum distance
                     if(mat[i][k] != 99 && mat[k][j] != 99){
                         if(mat[i][j] == 99){
                             // if i to j is not directly reachable update it with i to k + k to j 
                             mat[i][j] = mat[i][k] + mat[k][j];
                         }
                         else mat[i][j] = Math.min(mat[i][j],mat[i][k] + mat[k][j]);
                         
                         
                     }
                     // if(mat[i][k] == -1 || mat[k][j] == -1){
                     
                     //     continue;
                     // }
                     // else if(mat[i][j] == -1){
                     //     mat[i][j] = mat[i][k] + mat[k][j];
                     // }
                     // else{
                     //     mat[i][j] = Math.min(mat[i][j],mat[i][k] + mat[k][j]);
                     // }
                         
                 }
             }
         }
     }
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int p = sc.nextInt();
         sc.nextLine();
         int[][] routes = new int[p][p];
         for(int i = 0 ; i < p ; i++){
             for(int j = 0 ; j < p ; j++){
                 routes[i][j] = sc.nextInt();
             }
         }
         shortestDistance(routes);
         for(int i = 0 ; i < p ; i++){
             for(int j = 0 ; j < p ; j++){
                 System.out.print((routes[i][j] == 99 ? "INF" : routes[i][j]) + " ");
             }
             System.out.println();
         }
         
         
         
         sc.close();
     }
 }