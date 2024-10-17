/*Given a sorted array of integers, modify the array in place to remove the duplicates such that each element appears only once. 
You task is to return the new length of the array after duplicates are removed. 

You must do this with O(1) extra space (i.e., modify the array in place) and O(n) time complexity.

Input Format:
-------------
Line-1: An integer n, represents size of array.
Line-2 to n: A sorted integer array arr of length n.

Output Format:
--------------
Line-1: An integer, the new length of the array after removing the duplicates.

Constraints:
------------
You must modify the input array in place with O(1) extra memory.
The relative order of the elements should be preserved.
The function should run in O(n) time complexity.

Sample Input-1:
----------------
3
1 1 2

Sample Output-1:
-----------------
2

Explanation: The new length is 2, and the array becomes [1, 2].

Sample Input-2:
---------------
10
0 0 1 1 1 2 2 3 3 4

Sample Output-2:
-----------------
5

Explanation: The new length is 5, and the array becomes [0, 1, 2, 3, 4].
*/

import java.util.Scanner;
public class Day3P1 {
    private static void modifyArr(int[] arr,int n){
        
        int num = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i] == num){
                arr[i] = -1;
            }
            else{
                num = arr[i];
            }
        }
        
    }
    private static int countUnique(int[] arr,int n){
        
        // Now iterate again check for non - negative nums
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(arr[i] != -1){
                cnt++;
            }
        }
        return cnt;
    }
    
    // T.C:- O(2*N) ~ O(N)
    // S.C:- O(1)
   
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        // close the resource
        sc.close();
        
        modifyArr(arr,n);
        System.out.print(countUnique(arr,n));
        
        
    }
}
        
    
        

        
       
