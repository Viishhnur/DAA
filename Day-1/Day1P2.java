/*
You are part of a team working on a sophisticated communication system for an international spy network. 
The network uses encoded messages to ensure secure communication between agents. 
Each message is encoded as a string of digits, and each digit or 
combination of digits corresponds to a specific letter in the alphabet.

The encoding scheme is as follows:
'1' corresponds to 'A', 
'2' corresponds to 'B', 
..., 
'26' corresponds to 'Z'.

A single digit can represent a letter, or a pair of digits can represent a letter 
if the pair forms a valid number between 10 and 26.

However, decoding these messages is tricky because there may be multiple valid ways 
to interpret the sequence of digits. 

Your task is to determine the number of possible ways to decode a given encoded message.

NOTE:
The encoded message will not contain any characters other than digits, 
and no digit will be '0' unless it is part of a valid two-digit number (like '10' or '20').

Input Format:
-------------
Line1: A string of digits

Output Format:
--------------
Line1: A number, total number of distinct ways to decode the message.

Sample Input1:
-------------
226

Sample Output1: 
--------------
3

Explanation:
------------
The encoded message "226" can be decoded in the following ways:
"BZ" (where "2" = "B" and "26" = "Z")
"VF" (where "22" = "V" and "6" = "F")
"BBF" (where "2" = "B", "2" = "B", and "6" = "F")

Sample Input2:
-------------
06

Sample Output2: 
--------------
0

Explanation: No valid decodings
*/
import java.util.Scanner;
import java.util.Arrays;
class Day1P2 {
    private static int solve(String s, int i,int n,int[] memo){
        if(i == n){
            // I found a valid split
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0; // invalid split
        }
        
        // Pruning 
        if(memo[i] != -1) return memo[i]; // avoid overlaping sub problems

        int res = solve(s,i+1,n,memo);

        if(i+1<n){  
            // go for two sized string spliting
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')) 
                res += solve(s,i+2,n,memo);
        }

        return memo[i] = res;
    }
   

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        System.out.println(solve(s,0,n,memo));

        sc.close();
    
    }
}
