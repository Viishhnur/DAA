/*
You are given n items, each with a specific value and weight. 
You are also given a knapsack that can hold a maximum weight W. 
The goal is to maximize the total value in the knapsack by selecting items to add.

NOTE: You can take fractions of items instead of having to take the whole item. 
You need to calculate the maximum possible value that can be achieved.

Input Format:
-------------
Line-1: Two integers n and W representing the number of items and the maximum weight capacity of the knapsack, respectively.
Line-2 to n: Each line contains two integers value and weight for each item.

Output Format:
--------------
Line-1: Printing the maximum total value that can be obtained in the knapsack, rounded to two decimal places.

Constraints:
-------------
1 <= n <= 10^5
0 <= W <= 10^9
1 <= value, weight <= 10^9

Sample Input-1:
---------------
3 50
60 10
100 20
120 30

Sample Output-1:
----------------
240.00

Explanation:
------------
The first item can be added in full (value = 60, weight = 10).
The second item can be added in full (value = 100, weight = 20).
The third item can be added partially, using only 20 out of 30 weight capacity, which gives a value of (120/30) * 20 = 80.
Thus, the total value is 60 + 100 + 80 = 240.

Sample Input-2:
---------------
2 50
60 20
100 50

Sample Output-2:
----------------
120.00

Explanation:
------------
The first item can be added in full (value = 60, weight = 20).
From the second item, only 30 weight units can be used, so the value will be (100/50) * 30 = 60.
Thus, the total value is 60 + 60 = 120.

Sample Input-3:
---------------
1 10
500 30

Sample Output-3:
----------------
166.67

Explanation:
------------
The item has a value of 500 and a weight of 30. Since the knapsack can only hold 10 units of weight, we take a fraction of the item.
The value of 10 units from the first item is (500/30) * 10 = 166.67.
Thus, the total value is 166.67
 */

import java.util.Scanner;
import java.util.Arrays;

class Item {
    int value;
    int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

}

public class Day14P1Knapsack {

    private static double fractionalKnapsack(int w, Item[] arr, int n) {
        // first sort the item array based on value to weight ratio

        // Arrays.sort(arr,new Comparator<Item>() {
        // @Override
        // public int compare(Item a , Item b){
        // double r1 = (double) a.value / a.weight;
        // double r2 = (double) b.value / b.weight;

        // return Double.compare(r2,r1); // sorts in descending order
        // }
        // });

        // use lambda expression
        Arrays.sort(arr, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1); // Sorts in descending order
        });

        double maxVal = 0.0;

        for (Item item : arr) {
            if (w == 0)
                break;

            else if (item.weight <= w) {
                // place in the knapsack
                maxVal += item.value;
                w -= item.weight;
            } else {
                // if not place a fractional part only
                maxVal += ((double) item.value / item.weight) * w;
                w = 0; // knapsack is full
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int wt = sc.nextInt();

        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            int w = sc.nextInt();
            arr[i] = new Item(val, w);
        }

        System.out.printf("%.2f", fractionalKnapsack(wt, arr, n));

        sc.close();
    }
}
