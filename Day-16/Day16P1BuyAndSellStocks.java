/*

 */

import java.util.Scanner;

public class Day16P1BuyAndSellStocks {
    // T.C:- O(N)
    // S.C:- O(1)
    private static int maxProfit(int[] prices, int n) {

        // find left min and right max
        int leftMin = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            // this is a greedy approach check smaller value on left and calculate profit at every step based on this min cost price
            leftMin = Math.min(leftMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - leftMin);

        }

        return maxProfit;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        System.out.print(maxProfit(prices, n));

        sc.close();

    }

}
