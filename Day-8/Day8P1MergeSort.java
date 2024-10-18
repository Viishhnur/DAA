/*
 You are given an unsorted array of integers. 
Your task is to implement the MergeSort algorithm to sort the array in ascending order.

MergeSort is a divide-and-conquer algorithm that:
	-Divides the array into two halves.
	-Recursively sorts the two halves.
	-Merges the two sorted halves to produce the final sorted array.
	-Your task is to write a function that sorts the given array using MergeSort.

Input Format:
--------------
Line-1: An integer n (the size of the array).
Line-2: n space-separated integers representing the elements of the array.

Output Format:
---------------
Line-1: Output the sorted array in a single line, with each element separated by a space.

Constraints:
------------
1 ≤ n ≤ 10^5
-10^9 ≤ arr[i] ≤ 10^9


Sample Input-1:
---------------
6
12 11 13 5 6 7

Sample Output-1:
----------------
5 6 7 11 12 13


Sample Input-2:
---------------
5
10 1 2 8 5

Sample Output-2:
----------------
1 2 5 8 10

 */

import java.util.Scanner;
class Day8P1MergeSort
{
    static void merge(int arr[], int low, int mid, int high){
        // low to mid is one array , 
        // mid + 1 to  high is another array
        // create a temp array
        int[] temp = new int[high - low + 1];
        int idx = 0;
        int ptr1 = low;
        int ptr2 = mid + 1;
        
        while(ptr1 <= mid && ptr2 <= high){
            if(arr[ptr1] == arr[ptr2]){
                temp[idx++] = arr[ptr1++];
                temp[idx++] = arr[ptr2++];
            }
            else if(arr[ptr1] < arr[ptr2]){
                temp[idx++] = arr[ptr1++];
            }
            else{
                temp[idx++] = arr[ptr2++];
            }
            
        }
        
        // after this still some elements may be remaining
        while(ptr1<=mid){
            temp[idx++] = arr[ptr1++];
        }
        
        while(ptr2<=high){
            temp[idx++] = arr[ptr2++];
        }
        
        
        
        // Now copy back these elements into arr from low to high
        for(int i=low;i<=high;i++){
            arr[i] = temp[i-low];
        }
        
        return ;
    }
    static void mergeSort(int arr[], int low, int high){
        if(low >= high) return;
        
        int mid = (low + high) / 2;
        
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        
        // once you sorted the individual arrays comback and merge sorted sub arrays
        merge(arr,low,mid,high);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr,0,n-1);
        
        for(int num : arr){
            System.out.print(num + " ");
        }
        sc.close();
    }
}