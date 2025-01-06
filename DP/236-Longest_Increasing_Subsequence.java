//Recursive

class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int arr[]) {
        // code here
        return LIS(arr,0,-1);
    }
    
    static int LIS(int[] arr, int curr,int prev){
        if(curr==arr.length) return 0;
        //take or not that that len out of bounds is 0 only
        
        //not take is always possible and will be executed no matter
        //what
        
        int nottake=0+LIS(arr,curr+1,prev);
        
        int take=Integer.MIN_VALUE;
        
        if(prev==-1||arr[curr]>arr[prev])
            take=1+LIS(arr,curr+1,curr);
        
        return Math.max(nottake,take);
    }
}

//Memoization
class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int arr[]) {
        // code here
        int[][] dp=new int[arr.length][arr.length+1];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        } 
        return LIS(arr,0,-1,dp);
    }
    
    static int LIS(int[] arr, int curr,int prev,int[][] dp){
        if(curr==arr.length) return 0;
        //take or not that that len out of bounds is 0 only
        
        //not take is always possible and will be executed no matter
        //what
        
        if(dp[curr][prev+1]!=-1) return dp[curr][prev+1];
        
        int nottake=0+LIS(arr,curr+1,prev,dp);
        
        int take=Integer.MIN_VALUE;
        
        if(prev==-1||arr[curr]>arr[prev])
            take=1+LIS(arr,curr+1,curr,dp);
        
        return dp[curr][prev+1]=Math.max(nottake,take);
    }
    
}

//Tabulation

class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int arr[]) {
        // code here
        int[][] dp=new int[arr.length+1][arr.length+1];
        
        return LIS(arr,dp);
    }
    
    static int LIS(int[] arr,int[][] dp){
        int N=arr.length;
        for(int i=N-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                //above one are function calls
                //u need to mediate these function calls to
                //dp 
                //-1 in func will become 0 in the dp 2d array.
                //for every func call of prev, fo prev+1
                int nottake=0+dp[i+1][j+1];
                
                int take=Integer.MIN_VALUE;
                
                if(j==-1||arr[i]>arr[j])
                    take=1+dp[i+1][i+1];
                    
                dp[i][j+1]=Math.max(take,nottake);
            }
        }
        //Answer will be stored in 0 -1 in the sense curr=0 and prev-1 +1
        return dp[0][0];
    }
    
}