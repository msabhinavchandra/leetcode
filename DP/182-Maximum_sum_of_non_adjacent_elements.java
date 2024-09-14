//Recursive TC->O(2^n) and SC->O(n) stack space

import java.util.*;

class Solution {
    // Function to solve the problem using recursion
    private int func(int ind, int[] arr) {
        // Base cases
        if (ind == 0)
            return arr[ind];
        if (ind < 0)
            return 0;

        // Choosing the current element
        int pick = arr[ind] + func(ind - 2, arr);

        // Skipping the current element
        int nonPick = 0 + func(ind - 1, arr);

        // Return the maximum
        return Math.max(pick, nonPick);
    }


}

//Memorzation

import java.util.*;

class Solution {
    // Function to solve the problem using memoization
    private int func(int ind, int[] arr, int[] dp) {
        // Base cases
        if (ind == 0)
            return arr[ind];
        if (ind < 0)
            return 0;

        /* Check if the result for 'ind'
        has already been computed*/
        if (dp[ind] != -1)
            return dp[ind];

        // Choosing the current element
        int pick = arr[ind] + func(ind - 2, arr, dp);

        // Skipping the current element
        int nonPick = func(ind - 1, arr, dp);

        /* Store the result in dp 
        array and return the maximum */
        dp[ind] = Math.max(pick, nonPick);

        return dp[ind];
    }

    /* Function to calculate the maximum
    sum of non-adjacent elements */
    public int nonAdjacent(int[] nums) {
        int ind = nums.length - 1;

        // Initialize the dp array with -1
        int[] dp = new int[ind + 1];
        Arrays.fill(dp, -1);

        // Return the maximum sum
        return func(ind, nums, dp);
    }

}

//Tabulation TC->O(n) where N is the given size of array. As each element of the array is 
//processed exactly once in a single pass.and SC->O(n) excluding stack space array space

class Solution {
    public int nonAdjacent(int[] nums) {
        return maxSumOfNonAdjElmts(nums.length, nums);
    }

    public static int maxSumOfNonAdjElmts(int index, int[] arr) { //will pass 1-based no
        if (arr.length == 1) return arr[0];
        int[] dp = new int[index + 1]; // Just for safety, ans will be stored at n-1
        Arrays.fill(dp, -1);
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], arr[1]); // npick, pick
        for (int i = 2; i < index; i++) {
            int pick = arr[i] + dp[i - 2];
            int npick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, npick);
        }
        return dp[index - 1];
    }
}

 // Line 12: Suggest adding a comment explaining the base case logic
// Line 13: Suggest adding a comment to clarify storing the answer in dp




//Space Optimization
//TC->O(n) and SC->O(1)
class Solution {
    public int nonAdjacent(int[] nums) {
        return MaxSumOfNonAdjElms(nums.length, nums);
    }

    public static int MaxSumOfNonAdjElms(int index, int[] arr) {
        if (arr.length == 1) return arr[0];
        int prev2 = arr[0];
        int prev1 = Math.max(prev2, arr[1]); //npick,pick
        for (int i = 2; i < index; i++) { //index->1based indexing
            int pick = arr[i] + prev2;
            int npick = 0 + prev1;
            int cur_i = Math.max(pick, npick);
            prev2 = prev1;
            prev1 = cur_i;
        }
        return prev1;
    }

}


// Line 5: Suggest renaming MaxSumOfNonAdjElms to follow Java naming conventions (e.g., maxSumOfNonAdjElms)
// Line 8: Consider adding a comment explaining the purpose of the linear scan (e.g., "Iterate through the array to find the maximum sum of non-adjacent elements")
// Line 9: Replace 'npick' with 'notPick' for clarity
// Line 9: Replace 'pick' with 'include' for clarity
// Line 10: Rename 'cur_i' to 'currentMax' for better readability
// Line 9-10: Suggest formatting adjustments for better readability by adding spaces around operators
