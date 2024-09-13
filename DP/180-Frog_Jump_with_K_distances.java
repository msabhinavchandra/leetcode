//Rec

import java.util.*;

class Solution {
    //Helper function for recursion
    private int func(int ind, int[] heights, int k) {
        //Base case
        if (ind == 0) {
            return 0;
        }
        //Initialize mmStep to INT_MAX
        int mmStep = Integer.MAX_VALUE;
        
        //Try all possible steps
        for (int j = 1; j <= k; j++) {
            
            //Check if ind-j is non negative
            if (ind - j >= 0) {
                int jump = func(ind - j, heights, k) + Math.abs(heights[ind] - heights[ind - j]);
                
                //Update the mimimum energy
                mmStep = Math.min(jump, mmStep);
            }
        }
        //Return the answer
        return mmStep;
    }
    /* Function to find the mimimum 
    energy to reach last stair*/
    public int frogJump(int[] heights, int k) {
        int ind = heights.length - 1;
        
        //Return the mimimum energy
        return func(ind, heights, k);
    }

}

//Memo

import java.util.*;

class Solution {
    // Helper function for recursion with memoization
    private int func(int ind, int[] heights, int k, int[] dp) {
        // Base case
        if (ind == 0) {
            return 0;
        }
        
        /* If the result for this index has been 
        previously calculated, return it*/
        if (dp[ind] != -1) {
            return dp[ind];
        }
        
        // Initialize mmStep to Integer.MAX_VALUE
        int mmStep = Integer.MAX_VALUE;
        
        // Try all possible jumps
        for (int j = 1; j <= k; j++) {
            
            // Check if ind - j is non-negative
            if (ind - j >= 0) {
                int jump = func(ind - j, heights, k, dp) + Math.abs(heights[ind] - heights[ind - j]);
                
                //Update the minimum energy
                mmStep = Math.min(jump, mmStep);
            }
        }
        
        // Store the result in dp array and return
        dp[ind] = mmStep;
        return dp[ind];
    }
    
    /* Function to find the minimum 
    energy to reach the last stair*/
    public int frogJump(int[] heights, int k) {
        int ind = heights.length - 1;
        
        /* Initialize a memoization array
        to store calculated results*/
        int[] dp = new int[ind + 1];
        Arrays.fill(dp, -1);
        
        // Return the minimum energy
        return func(ind, heights, k, dp);
    }
    
}

//Tabulation

class Solution {
    public int frogJump(int[] heights, int k) {
        return func(heights,k,heights.length);
    }

    public static int func(int[] a,int k,int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int ind=1;ind<n;ind++){
            int mmSteps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(ind-j>=0){
                    int jumpn=dp[ind-j]+Math.abs(a[ind-j]-a[ind]);
                    mmSteps=Math.min(mmSteps,jumpn);
                }
               
            }
            dp[ind]=mmSteps;
        }
        return dp[n-1];
    }
}


// Line 5: Consider renaming `func` to `calculateMinimumEnergy` for clarity
// Line 10: Suggest renaming `mmSteps` to `minimumSteps` for clarity
// Line 15-16: Suggest adding a comment to explain the logic of finding minimum steps