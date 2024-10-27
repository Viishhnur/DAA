/*
You are given an array of integers that can include both positive and negative numbers. 
Your task is to find the minimum possible product of a non-empty subset of the given array.

Rules:
-The subset must contain at least one element.
-The product is the result of multiplying all the numbers in the subset.
-If the array contains only one element, that element is the result.
-You can ignore zeros in the subset product calculation.

Input Format:
-------------
Line-1: An integer N, the number of elements in the array.
Line-2: N space-separated integers representing the elements of the array.

Output Format:
--------------
Line-1: Print a single integer representing the minimum product possible from a subset of the given array.

Constraints:
------------
1 ≤ N ≤ 100
-1000 ≤ array[i] ≤ 1000

Sample Input-1:
---------------
5
-1 -1 -2 4 3

Sample Output-1:
----------------
-24

Explanation: The minimum product can be achieved by choosing the subset {-1, -1, -2, 4} which results in the product -24.

Sample Input-2:
---------------
3
-1 0 -2

Sample Output-2
----------------
-2

Explanation: Since zeroes can be ignored, the minimum product is -2, achieved by the subset {-2}.

Sample Input-3:
---------------
6
2 3 4 5 -1 -2

Sample Output-3:
----------------
-240
Explanation: By choosing the subset {2, 3, 4, 5, -1, -2}, the minimum product is -240.
 */