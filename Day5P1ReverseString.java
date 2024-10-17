/*
 Given a string s, write a recursive function to reverse the string. 
You are not allowed to use any built-in string manipulation functions. 

Constraints:
------------
The input string s consists of printable ASCII characters (including spaces, punctuation, etc.).
The length of the string s is between 1 and 1000.
You must reverse the string recursively.

Input Format:
--------------
Line-1: A single string s, containing characters that need to be reversed.

Output Format:
--------------
Line-1: A single string, representing the reversed input string.


Sample Input-1: 
---------------
hello

Sample Output-1:
-----------------
olleh

Sample Input-2:
----------------
12345

Sample Output-2: 
----------------
54321

 */
import java.util.Scanner;

public class Day5P1ReverseString {

    // Recursive function to reverse the string
    private static String Reverse(String s, int idx) {
        if (idx < 0) {
            return ""; 
        }
       
        return s.charAt(idx) + Reverse(s, idx - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String rev = Reverse(s, s.length() - 1); // Call the recursive function
        System.out.println(rev); // Print the reversed string
        sc.close();
    }
}

