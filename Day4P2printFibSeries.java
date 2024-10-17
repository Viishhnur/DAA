/*
Given a non-negative integer n, generate the Fibonacci series up to the nth number using a recursive approach. 
The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones, starting from 0 and 1.

The Fibonacci sequence is defined as:
F(0) = 0
F(1) = 1
F(n) = F(n-1) + F(n-2) for n ≥ 2

Constraints:
-------------
You are required to compute the Fibonacci series recursively as demonstrated in the Sample input and output.
The recursive approach may cause time complexity issues for large values of n due to overlapping subproblems.
0 ≤ n ≤ 30 is a reasonable upper bound for testing the recursive approach due to its exponential time complexity.

Input Format:
--------------
Line-1: A single integer n, representing the number of Fibonacci numbers to generate.

Output Format:
---------------
Line-1: A sequence of n Fibonacci numbers.

Sample Input-1:
---------------
5

Sample Output-1:
-----------------
0 1 1 2 3

Sample Input-2:
---------------
10

Sample Output-2: 
----------------
0 1 1 2 3 5 8 13 21 34
*/
import java.util.Scanner;

public class Day4P2printFibSeries {

    // Recursive function to calculate Fibonacci number at index n
    private static int fibonacci(int n) {
        if (n == 0) {
            return 0; // Base case for F(0)
        }
        if (n == 1) {
            return 1; // Base case for F(1)
        }
        // Recursive case: F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read the number of Fibonacci numbers to generate
        sc.close();

        // Print Fibonacci series from 0 to n-1
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i));
            if (i < n - 1) {
                System.out.print(" "); // Add space between numbers, but not after the last number
            }
        }
    }
}