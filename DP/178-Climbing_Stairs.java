//Recursion
import java.util.*;

class Solution{
    //Function to count total ways to reach nth stair
    public static int climbStairs(int n){
        //Base case
        if(n == 0) return 1;
        if(n == 1) return 1;
        
        //Taking 1 step at a time
        int oneStep = climbStairs(n-1);
        
        //Taking 2 steps at a time
        int twoSteps = climbStairs(n-2);
        
        //Return total ways
        return oneStep+twoSteps;
    }
}

//Memo

import java.util.*;

class Solution {
    //Helper function to apply memoization
   private int func(int n, int dp[]){
        //Base condition
        if (n <= 1) {
            return 1;
        }
        
        //Check if the subproblem is already solved
        if (dp[n] != -1) {
            return dp[n];
        }
        
        //Return the calculated value
        return dp[n] = func(n-1, dp) + func(n-2, dp);
    }
    // Function to count total ways to reach nth stair
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        
        // Initialize dp array with -1
        Arrays.fill(dp, -1);
        
        // Return the calculated value
        return dp[n] = func(n, dp);
    }
    
}

//Tabulation

import java.util.*;

class Solution {
    // Function to count total ways to reach nth stair
    public int climbStairs(int n) {
        // Declare dp array of size n+1
        int[] dp = new int[n + 1];

        // Insert the values of base conditions
        dp[0] = 1;
        dp[1] = 1;

        // Iterate and update every index of dp array
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the answer
        return dp[n];
    }

}

//Optimization of space

import java.util.*;

class Solution {
    // Function to count total ways to reach nth stair
    public int climbStairs(int n) {
        /*Initialize two variables to 
        store previous results*/
        int prev2 = 1;
        int prev = 1;
        
        //Iterate and update the variables
        for (int i = 2; i <= n; i++) {
            int cur_i = prev2 + prev;
            prev2 = prev;
            prev = cur_i;
        }
        //Return the answer as prev
        return prev;
    }
}
