/*Write an algorithm to determine if a number n is a happy number.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will remain), or it loops endlessly in a cycle that does not include 1.
If the number eventually reaches 1, then the number is happy. Otherwise, it is not.

Constraints:
-------------
1 ≤ n ≤ 2³¹ - 1
You must handle the case of both happy and non-happy numbers.

Input Format:
-------------
Line-1: A single integer n, representing the number to be checked.

Output Format:
---------------
Line-1: Return true if the input number is a happy number, otherwise return false.


Sample Input-1: 
----------------
19

Sample Output-1: 
-----------------
true

Explanation:
Process to determine if 19 is a happy number:
1² + 9² = 1 + 81 = 82
8² + 2² = 64 + 4 = 68
6² + 8² = 36 + 64 = 100
1² + 0² + 0² = 1 (since the number reached 1, 19 is a happy number)


Sample Input-2: 
----------------
2

Sample Output-2: 
-----------------
false

Explanation:
The process does not reach 1 and starts repeating numbers. Hence, 2 is not a happy number.
*/
import java.util.HashSet;
import java.util.Scanner;

public class Day5P2HappyNumber {
    
    private static boolean isHappyRecursive(int n, HashSet<Integer> seenNumbers) {
        if (n == 1) {
            return true;  // Base case: if n reaches 1, it's a happy number
        }
        if (seenNumbers.contains(n)) {
            return false;  // If n is already in the set, a cycle is detected
        }
        
        seenNumbers.add(n);  // Mark the current number as seen
        
        // Recur with the sum of squares of digits
        int sumOfSquares = getSumOfSquares(n);
        return isHappyRecursive(sumOfSquares, seenNumbers);
    }

    // Function to get the sum of squares of digits of n
    private static int getSumOfSquares(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Input the number
        HashSet<Integer> seenNumbers = new HashSet<>();  // Set to store seen numbers
        System.out.println(isHappyRecursive(n, seenNumbers));  // Check if it's a happy number
        sc.close();
    }
}
