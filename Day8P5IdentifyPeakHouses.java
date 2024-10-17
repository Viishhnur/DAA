/*
In a city, a survey is being conducted to identify special houses known as "peaks." 
A peak house is defined as one whose height is greater than its immediate neighbors. 
For houses on the boundary (first and last in the array), a peak is a house that is greater than its single neighbor.

Your task is to assist the surveyor by writing a program that identifies and prints the heights of all peak houses in sorted order.

Input Format:
-------------
Line-1: An integer n (the number of houses).
Line-2: n distinct integers, representing the heights of the houses.

Output Format:
--------------
Line-1: Print a list of peak house heights in sorted order.

Constraints:
1 ≤ n ≤ 10^5 (i.e., up to 100,000 houses)
Heights of houses are distinct and can be any integer between -10^9 and 10^9.

Definitions:
A peak house is a house where its height is greater than both its neighboring houses.
For the first house, it is a peak if it is greater than the second house.
For the last house, it is a peak if it is greater than the second-to-last house.

Sample Input-1:
---------------
8
9 4 5 3 8 7 10 11

Sample Output-1:
-----------------
[5, 8, 9, 11]

Explanation:
House heights 5, 8, 9, and 11 are peaks as they are greater than their neighboring houses.

Sample Input-2:
---------------
10
1 2 3 4 5 6 7 8 9 10

Sample Output-2:
----------------
[10]

Explanation:
Only 10 is a peak because it is greater than its only neighbor, 9.


Sample Input-3:
---------------
10
10 9 8 7 6 5 4 3 2 1

Sample Output-3:
---------------
[10]

Explanation:
Only 10 is a peak because it is greater than 9, its only neighbor on the right.


Sample Input-4:
---------------
10
1 2 3 4 5 10 6 7 8 9

Sample Output-4:
---------------
[9, 10]

Explanation:
The houses 9 and 10 are peaks since they are greater than their immediate neighbors.



 */
import java.util.*;

public class Day8P5IdentifyPeakHouses {
    private static List<Integer> identifyPeakHouses(int[] houses) {
        List<Integer> peakHouses = new ArrayList<>();
        int n = houses.length;
        
        // Handle the first house separately
        if (n > 1 && houses[0] > houses[1]) {
            peakHouses.add(houses[0]);
        } else if (n == 1) { // If there is only one house, it's a peak
            peakHouses.add(houses[0]);
        }

        // Check the middle houses
        for (int i = 1; i < n - 1; i++) {
            if (houses[i] > houses[i - 1] && houses[i] > houses[i + 1]) {
                peakHouses.add(houses[i]);
            }
        }

        // Handle the last house separately
        if (n > 1 && houses[n - 1] > houses[n - 2]) {
            peakHouses.add(houses[n - 1]);
        }

        return peakHouses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = sc.nextInt();
        }

        List<Integer> peakHouses = identifyPeakHouses(houses);
        Collections.sort(peakHouses);
        System.out.println(peakHouses);
        sc.close();
    }
}

