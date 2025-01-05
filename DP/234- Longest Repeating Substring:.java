
class Solution {
    public int longestRepeatingSubstring(String s) {
        int length = s.length(); 
        int longestLength = 0; 
        int[][] dp = new int[length][length]; 

        for (int i = 0; i < length; ++i) {
            
            for (int j = i + 1; j < length; ++j) {

                if (s.charAt(i) == s.charAt(j)) {

                    dp[i][j] = i > 0 ? dp[i - 1][j - 1] + 1 : 1;

                    longestLength = Math.max(longestLength, dp[i][j]);

                }
            }
        }
        return longestLength; 
    }
}