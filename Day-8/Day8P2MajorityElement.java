/*
 Given an array nums of size n, return the majority element. 
The majority element is the element that appears more than ⌊n / 2⌋ times.

You may assume that the majority element always exists in the array.

Input Format:
--------------
Line-1: An integer n (the size of the array).
Line-2: n space-separated integers representing the elements of the array.

Output Format:
--------------
Line-1: Output a single integer, the majority element.

Constraints:
-------------
1 ≤ n ≤ 5 * 10^4
-10^9 ≤ nums[i] ≤ 10^9


Sample Input-1:
---------------
3
3 2 3

Sample Output-1:
----------------
3

Explanation:
The number 3 appears more than n/2 times, so it is the majority element.

Sample Input-2:
---------------
7
2 2 1 1 1 2 2

Sample Output-2:
----------------
2

Explanation:
The number 2 appears 4 times, which is more than n/2 = 3.5, so it is the majority element.

 */

//  Since constraints are more use sorting better than hashmap 
import java.util.*;
public class Day8P2MajorityElement {
    private static int findMajorityElement(int[] arr,int n){
        // first sort the array 
        Arrays.sort(arr); 
        // initialize previous element as the first element of the array, and count as 1.
        int count = 1;
        int prev = arr[0];
        for (int i = 1 ; i < n ; i++) {
            if(arr[i] == prev){
                count++;
            }
            else{
                count = 0;
                prev = arr[i];
            }
            if(count > n/2){
                return prev;
            }  // if the count is more than half of the array, return that element as it is the majority element.

        }

        return prev;
    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i=0 ; i<n ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findMajorityElement(arr,n));
        sc.close();
    }
}
