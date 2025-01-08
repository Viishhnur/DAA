
// } Driver Code Ends

import java.util.Arrays;

public class Knapsack {
    // Function to return max value that can be put in knapsack of capacity.
   private static int f(int ind, int W, int[] val, int[] wt, int[][] dp) {
    // Base case
    if (ind == 0) {
        return wt[0] <= W ? val[0] : 0;
    }
    
    // Check if already computed
    if (dp[ind][W] != -1) return dp[ind][W];
    
    // Option 1: Do not take the item
    int notTake = f(ind - 1, W, val, wt, dp);
    
    // Option 2: Take the item (if it fits)
    int take = Integer.MIN_VALUE;
    if (wt[ind] <= W) {
        take = val[ind] + f(ind - 1, W - wt[ind], val, wt, dp);
    }

    // Store the result
    return dp[ind][W] = Math.max(notTake, take);
}

static int knapSack(int capacity, int[] val, int[] wt) {
    int n = val.length;
    int[][] dp = new int[n][capacity + 1];
    for (int[] row : dp) {
        Arrays.fill(row, -1);
    }
    return f(n - 1, capacity, val, wt, dp);
}

}
