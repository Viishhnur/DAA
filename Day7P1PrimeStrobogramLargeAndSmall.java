/*
 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, print all prime strobogrammatic numbers that are of length n 
and print smallest and largest strobogrammatic numbers of length n.

Input Format:
-------------
Line-1: A single integer n, representing the length of the strobogrammatic numbers to generate.

Output Format:
--------------
Line-1: Return a list of all prime strobogrammatic numbers of length n.
Line-2: Space separated two values, smallest and largest strobogrammatic numbers of length n.

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
2

Sample Output-1: 
----------------
[11]
11 96


Sample Input-2:
---------------
5

Sample Output-2: 
----------------
[16091, 18181, 19861, 61819]
10001 99866

Sample Input-3:
---------------
4

Sample Output-3: 
----------------
[]
1001 9966

NOTE: Print the results in sorted order to pass the testcases
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Day7P1PrimeStrobogramLargeAndSmall{
    private static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i<Math.sqrt(n)+1;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    private static List<String> getStroboNums(int n,int length){
        List<String> res = new ArrayList<>();
        if(n == 0){
            res.add("");
            return res;
        }
        
        if(n == 1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        
        List<String> prev = getStroboNums(n-2,length);
        for(String str : prev){
            if(n!=length){
                res.add("0" + str + "0");
            }
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
        }
        
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String>lst = getStroboNums(n,n);
        Collections.sort(lst);
        for(int i = 0 ; i < lst.size() ; i++){
            String num = lst.get(i);
            if(isPrime(Integer.parseInt(num))){
                System.out.print(num + " ");
            }
        }
        System.out.println(lst.get(0) + " " + lst.get(lst.size()-1));
        sc.close();  // close the scanner
    }
}