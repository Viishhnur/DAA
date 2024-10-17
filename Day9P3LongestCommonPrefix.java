/*
Given an array of strings strs, find the longest common prefix among all strings.

If there is no common prefix, return an empty string "".

NOTE: Solve Using Binary Search

Input Format:
-------------
Line-1: An integer n, the number of strings in the array.
Line-2: The next n lines contain n space-separated strings representing the elements of the string array strs.

Output Format:
--------------
Line-1: Print a single string, which is the longest common prefix among all the strings. If no common prefix exists, print an empty string.

Constraints:
------------
1 ≤ n ≤ 200
0 ≤ strs[i].length ≤ 200
strs[i] consists of only lowercase English letters.


Sample Input-1:
---------------
3
flower flow flight

Sample Output-1:
----------------
fl

Explanation:
The longest common prefix of the strings flower, flow, and flight is "fl".

Sample Input-2:
---------------
3
dog racecar car

Sample Output-2:
----------------
""

Explanation:
There is no common prefix among the input strings.
 */
import java.util.Scanner;
import java.util.Arrays;
public class Day9P3LongestCommonPrefix {
    private static String longestCommonPrefix(String[] strs) {
        int i = 0;
        String startStr = strs[0];
        String endStr = strs[strs.length - 1];
        String ans = "";
        while(i < Math.min(startStr.length(), endStr.length()) && startStr.charAt(i) == endStr.charAt(i)){
            ans += startStr.charAt(i);
            i++;
        }
        return ans;  // return the longest common prefix as a string
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for(int i=0; i<n; i++){
            strs[i] = sc.next();
        }
        for (int i=0 ; i<n ; i++) {
            System.out.print(strs[i] + " ");
        }
        Arrays.sort(strs); // sort the strings
        System.out.println();
        for (int i=0 ; i<n ; i++) {
            System.out.print(strs[i] + " ");
        }
        String result = longestCommonPrefix(strs);
        System.out.println("\nResult is  : " + result);
        sc.close();
    
    }
}
