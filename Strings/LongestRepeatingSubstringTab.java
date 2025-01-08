package Strings;

public class LongestRepeatingSubstringTab {
    public static String longestRepeatingSubstring(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        int maxLength = 0; // Length of the longest repeating substring
        int endIndex = 0; // End index of the substring in the original string

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // If characters match and indices are not overlapping
                if (str.charAt(i - 1) == str.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // Update maximum length and end index
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = j;
                    }
                }
            }
        }

        // Return the longest repeating substring
        return maxLength > 0 ? str.substring(endIndex - maxLength, endIndex) : "";
    }

    public static void main(String[] args) {
        String input = "banana";
        String result = longestRepeatingSubstring(input);
        System.out.println("Longest Repeating Substring: " + result);
    }
}
