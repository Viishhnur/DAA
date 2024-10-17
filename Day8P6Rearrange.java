/*
You are given an array of integers containing both positive and negative values. 
Your task is to rearrange the array such that all negative integers appear before the positive integers while preserving the relative order of the numbers. 
The order of positive and negative integers in the array should remain unchanged, but negatives must come before positives.

Input Format:
--------------
Line-1: An integer n, the number of integers in the array.
Line-2: n integers, which are a mix of positive and negative numbers.

Output Format:
---------------
Line-1: Print the rearranged list of integers where all negative numbers come before the positive numbers while preserving the relative order.

Constraints:
------------
* 1 ≤ n ≤ 10^5 (The size of the array can be up to 100,000 integers).
* The array contains both positive and negative integers. Zero is considered as a positive number.

Sample Input-1:
---------------
8
9 -3 5 -2 -8 -6 1 3

Sample Output-1:
[-3, -2, -8, -6, 9, 5, 1, 3]


Sample Input-2:
---------------
8
5 -4 3 -4 2 1 -5 -6

Sample Output-2:
-----------------
[-4, -4, -5, -6, 5, 3, 2, 1]
 */
import java.util.*;
public class Day8P6Rearrange {
    public static List<Integer> getCustomSortedArr(int[] arr, int n){
        List<Integer> negList = new ArrayList<>();
        List<Integer> posList = new ArrayList<>();
        for (int i=0 ; i<n ; i++) {
            if(arr[i] < 0){
                negList.add(arr[i]);
            }
            else{
                posList.add(arr[i]);
            }
        }
        negList.addAll(posList);
        return negList;
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void MovePositivesToEnd(int[] arr, int n){
        int j = 0; // it points to negative index
        int i = 0; // it points to positive index
        while(i < n){
            if(arr[i] < 0){
                if(i != j){
                    swap(arr,i,j);
                }
                j++; // move to the negative pointer
                
            }
            i++; 
        }

        
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        // List<Integer> lst = getCustomSortedArr(arr,n);
        // System.out.print(lst);
        MovePositivesToEnd(arr, n);
        List<Integer> res = new ArrayList<>();
        for (int i=0 ; i<n ; i++) {
            res.add(arr[i]);
        }
        System.out.print(res);
        sc.close();
    
    }
}
