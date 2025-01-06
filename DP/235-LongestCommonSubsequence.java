import java.util.*;

//Recursion

class Solution {
    // Function to find the length of the longest common subsequence in two strings.
    static int getLCSLength(String s1, String s2) {
        // your code here

        return LCS(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    static int LCS(String s1, String s2, int ind1, int ind2) {

        if (ind1 < 0 || ind2 < 0)
            return 0;

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return 1 + LCS(s1, s2, ind1 - 1, ind2 - 1);
        }

        return 0 + Math.max(LCS(s1, s2, ind1, ind2 - 1), LCS(s1, s2, ind1 - 1, ind2));

    }

}

//Memoization

class Solution2 {
    // Function to find the length of the longest common subsequence in two strings.
    static int getLCSLength(String s1, String s2) {
        // your code here

        int[][] dp = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return LCS(s1, s2, s1.length() - 1, s2.length() - 1, dp);
    }

    static int LCS(String s1, String s2, int ind1, int ind2, int[][] dp) {

        if (ind1 < 0 || ind2 < 0)
            return 0;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + LCS(s1, s2, ind1 - 1, ind2 - 1, dp);
        }

        return dp[ind1][ind2] = 0 + Math.max(LCS(s1, s2, ind1, ind2 - 1, dp), LCS(s1, s2, ind1 - 1, ind2, dp));
    }
}

//changing index to handle -1s for the tabulation && Tabulation

class Solution3 {
    // Function to find the length of the longest common subsequence in two strings.
    static int getLCSLength(String s1, String s2) {
        // your code here

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return LCS(s1, s2, s1.length(), s2.length(), dp);
    }

    static int LCS(String s1, String s2, int ind1, int ind2, int[][] dp) {

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
