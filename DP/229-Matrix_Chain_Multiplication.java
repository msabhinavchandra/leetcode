//Recursive

import java.util.*;

class TUF{
static int f(int[] arr, int i, int j){
    
    // base condition
    if(i == j)
        return 0;
        
    int mini = Integer.MAX_VALUE;
    
    // partioning loop
    for(int k = i; k<= j-1; k++){
        
        int ans = f(arr,i,k) + f(arr, k+1,j) + arr[i-1]*arr[k]*arr[j];
        
        mini = Math.min(mini,ans);
        
    }
    
    return mini;
}


static int matrixMultiplication(int[] arr, int N){
    
    int i =1;
    int j = N-1;
    
    
    return f(arr,i,j);
    
    
}

}


//Tabulation

class Solution {
  static int matrixMultiplication(int arr[]) {
    // code here
    int[][] dp = new int[arr.length][arr.length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        dp[i][j] = -1;
      }
    }
    int result = helper(arr, 1, arr.length - 1, dp);

    return result;
  }

  static int helper(int[] arr, int i, int j, int[][] dp) {
    if (dp[i][j] != -1)
      return dp[i][j];

    if (i == j)
      return dp[i][j] = 0;

    int mini = Integer.MAX_VALUE;

    for (int k = i; k <= j - 1; k++) {
      int ans = helper(arr, i, k, dp) + helper(arr, k + 1, j, dp)
          + arr[i - 1] * arr[k] * arr[j];

      mini = Math.min(ans, mini);
    }
    return dp[i][j] = mini;
  }
}

//Tabulation did omo

import java.io.*;
import java.util.*;

// User function Template for Java

class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int[][] dp=new int[arr.length][arr.length];
        return bottomUp(arr,dp);
    }
    
    static int bottomUp(int[] arr,int[][] dp){
        int N=arr.length;
        for(int i=N-1;i>=1;i--){
            for(int j=i;j<=N-1;j++){
                
                if(i==j){
                    dp[i][j]=0;
                    continue;
                }
                
                int min=Integer.MAX_VALUE;
                
                for(int k=i;k<=j-1;k++){
                    
                    int ans=dp[i][k]+dp[k+1][j]+ arr[i-1]*arr[k]*arr[j];
                    
                    min=Math.min(ans,min);
                    
                }
                dp[i][j]=min;
                
            }
        }
        
        return dp[1][N-1];
        
    }
}