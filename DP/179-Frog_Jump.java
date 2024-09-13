//Recursion
class Solution {
    public int frogJump(int[] heights, int ind) {
        // Base case: if the frog is at the first step
        if (ind == 0) return 0;
        
        // Recursively calculate the energy required to 
        // jump to the current step from the previous step
        int jumpOne = frogJump(heights, ind - 1) + Math.abs(heights[ind] - heights[ind - 1]);
        
        // Initialize jumpTwo to a large value
        int jumpTwo = Integer.MAX_VALUE;
        
        // If possible, recursively calculate the energy required to 
        // jump to the current step from two steps back
        if (ind > 1) {
            jumpTwo = frogJump(heights, ind - 2) + Math.abs(heights[ind] - heights[ind - 2]);
        }
        
        // Return the minimum energy required to reach the current step
        return Math.min(jumpOne, jumpTwo);
    }

    public int frogJump(int[] heights) {
        int n = heights.length;
        return frogJump(heights, n - 1);
    }
}

//Memo
class Solution {
    private int solve(int ind, int[] heights, int[] dp) {
        // Base case
        if (ind == 0) return 0; 
        // Memoized result
        if (dp[ind] != -1) return dp[ind]; 

        int jumpOne = solve(ind - 1, heights, dp) + Math.abs(heights[ind] - heights[ind - 1]);
        int jumpTwo = Integer.MAX_VALUE;
        if (ind > 1)
            jumpTwo = solve(ind - 2, heights, dp) + Math.abs(heights[ind] - heights[ind - 2]);
        // Store and return result
        return dp[ind] = Math.min(jumpOne, jumpTwo); 
    }

    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // Start solving from the last stair
        return solve(n - 1, heights, dp); 
    }
}

//Tabulation
import java.util.Arrays;

class Solution {
    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // Base case
        dp[0] = 0; 

        // Iterative calculation
        for (int ind = 1; ind < n; ind++) {
            int jumpOne = dp[ind - 1] + Math.abs(heights[ind] - heights[ind - 1]);
            int jumpTwo = Integer.MAX_VALUE;
            if (ind > 1)
            // Store minimum energy for this stair
                jumpTwo = dp[ind - 2] + Math.abs(heights[ind] - heights[ind - 2]);
            dp[ind] = Math.min(jumpOne, jumpTwo); 
        }
        // Return the minimum energy required to reach the last stair
        return dp[n - 1]; 
    }

    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50};
        Solution sol = new Solution();
        // Output the result
        System.out.println(sol.frogJump(heights)); 
    }
}

//Space opt
class Solution {
    public int frogJump(int[] heights) {
        int n = heights.length;
        int prev = 0, prev2 = 0; // Initialize for base cases

        // Iterative calculation
        for (int i = 1; i < n; i++) {
            int jumpOne = prev + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;
            if (i > 1)
                jumpTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);
                
            // Minimum energy for current stair
            int cur_i = Math.min(jumpOne, jumpTwo); 
            // Update previous values
            prev2 = prev; 
            prev = cur_i;
        }
        // Return the minimum energy required to reach the last stair
        return prev; 
    }
}