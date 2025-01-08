/*
In a school, the 5th standard class is divided into two sections, Rose and Lotus. 
The teacher has recorded the scores of students from both sections in their Mathematics exam. 
The marks for both sections are provided in ascending order. 
The task is to compute the median of the combined marks of both sections.

You are given the number of students in each section and their respective marks. Your task is to find the median of the combined sorted marks from both sections.

The overall run-time complexity of your solution should be O(log(min(m + n))).

Input Format:
-------------
Line-1: An integer m, representing the number of students in section Rose.
Line-2: An integer n, representing the number of students in section Lotus.
Line-3: m space-separated integers, representing the scores of students in section Rose, sorted in ascending order.
Line-4: n space-separated integers, representing the scores of students in section Lotus, sorted in ascending order.

Output Format:
--------------
Line-1: Print a single float representing the median of the combined sorted marks from both sections.

Constraints:
------------
0 ≤ m, n ≤ 1000
The marks of students are in the range 0 ≤ marks ≤ 100.
Time complexity: O(log(min(m + n)))
Space complexity: O(1)

Sample Input-1:
---------------
4
6
32 45 70 95
40 50 59 67 73 84

Sample Output-1:
----------------
63.0

Explanation: The combined sorted marks are: [32, 40, 45, 50, 59, 67, 70, 73, 84, 95].
The median is 63.0.


Sample Input-2:
---------------
5
6
10 20 30 40 50
35 44 60 70 80 90

Sample Output-2:
----------------
44.0

Explanation: The combined sorted marks are: [10, 20, 30, 35, 40, 44, 50, 60, 70, 80, 90].
The median is 44.0.

Sample Input-3:
---------------
4
6
3 6 8 10
14 17 20 33 44 55

Sample Output-3:
-----------------
15.5

Explanation: The combined sorted marks are: [3, 6, 8, 10, 14, 17, 20, 33, 44, 55].
The median is (10 + 14) / 2 = 15.5.


Sample Input-4:
----------------
3
5
50 60 80
7 10 20 30 40

Sample Output-4:
----------------
35.0

Explanation: The combined sorted marks are: [7, 10, 20, 30, 40, 50, 60, 80].
The median is 35.0.
 */
import java.util.*;

public class Day10P2MedianOfSortedArr {
    private static double getMedianOf(int[] arr1,int[] arr2){
        int i = 0 , j = 0;
        int n = arr1.length + arr2.length;
        int el2 = n / 2;
        int el1 = n/2 - 1;

        int cnt = 0;
        
        int ind1Ele = -1 , ind2Ele = -1;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                if(cnt == el1) ind1Ele = arr1[i];
                if(cnt == el2) ind2Ele = arr1[i];
                i++;
                cnt++;
            } 
            else{
                if(cnt == el1) ind1Ele = arr2[j];
                if(cnt == el2) ind2Ele = arr2[j];
                j++;
                cnt++;
            }
           
        }

        while(i < arr1.length){
            if(cnt == el1) ind1Ele = arr1[i];
            if(cnt == el2) ind2Ele = arr1[i];
            i++;
            cnt++;
        } 

        while(j < arr2.length){
            if(cnt == el1) ind1Ele = arr2[j];
            if(cnt == el2) ind2Ele = arr2[j];
            j++;
            cnt++;
        } 

        if((n & 2) == 1){
            // if odd return element at second ind
            return ind2Ele;
        }

        return (double)(ind1Ele + ind2Ele) / 2;

                                                               
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt() , n = sc.nextInt();

        int[] arr1 = new int[m];
        int[] arr2 = new int[n];

        for(int i = 0 ; i < m ; i++) arr1[i] = sc.nextInt();
        for(int i = 0 ; i < n ; i++) arr2[i] = sc.nextInt();

        sc.close();
        System.out.print(getMedianOf(arr1,arr2));
    }
}
