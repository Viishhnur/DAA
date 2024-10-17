/*
 You are climbing a staircase. It takes n steps to reach the top. 
Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?

Constraints:
------------
1 ≤ n ≤ 45
Each time you can take either 1 step or 2 steps.
You need to compute the total number of distinct ways to climb the staircase.

Input Format:
--------------
Line-1: A single integer n, representing the number of steps required to reach the top.

Output Format:
---------------
Line-1: A single integer representing the number of distinct ways to climb to the top.

Sample Input-1: 
----------------
2

Sample Output-1: 
----------------
2

Explanation: There are two ways to climb to the top:
1 step + 1 step
2 steps

Sample Input-2: 
---------------
3

Sample Output-2: 
----------------
3

Explanation: There are three ways to climb to the top:
1 step + 1 step + 1 step
1 step + 2 steps
2 steps + 1 step

 */
import java.util.Scanner;
import java.util.Arrays;

public class Day4P3ClimbingStairs {
    private static int getNoOfSteps(int n,int[] memo){
        if(n == 0 || n == 1){
            return 1;
        }
        if(memo[n]!= -1){
            return memo[n];
        }
        memo[n] = getNoOfSteps(n-1,memo) + getNoOfSteps(n-2,memo);
        return memo[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        System.out.println(getNoOfSteps(n, memo));
        sc.close();
    
    }
}
