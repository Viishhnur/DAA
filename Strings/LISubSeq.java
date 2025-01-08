import java.util.*;

public class LISubSeq {
    private int solve(int curr, int prev, int[] nums, int[][] dp, int n) {
        if (curr == n)
            return 0;

        if (dp[curr][prev + 1] != -1)
            return dp[curr][prev + 1];

        int len = 0 + solve(curr + 1, prev, nums, dp, n); // this is when i am not taking the current element and moving
                                                          // forward
        if (prev == -1 || nums[curr] > nums[prev]) {
            // yes i take it
            len = Math.max(len, 1 + solve(curr + 1, curr, nums, dp, n));
        }

        return dp[curr][prev + 1] = len;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, -1, nums, dp, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.close();
    }
}