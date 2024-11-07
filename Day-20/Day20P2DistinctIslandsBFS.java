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

public class Day20P2DistinctIslandsBFS {
    
}
