//Recursion
class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int answer=helper(val.length-1,capacity,val,wt);
        return answer;
    }
    
    static int helper(int index,int cap,int val[],int wt[]){
        
        if(index==0){//if you reach the starting index
            
            if(wt[index]<=cap) return val[index];
            
            return 0;
        }
        
        int notpick=0+helper(index-1,cap,val,wt);
        
        int pick=Integer.MIN_VALUE;
        
        if(wt[index]<=cap){
            
            pick=val[index]+helper(index-1,cap-wt[index],val,wt);
            
        }
        
        return Math.max(pick,notpick);
        
        
    }
    
}

//Memoization

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int[][] dp=new int[val.length][capacity+1];
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        
        
        int answer=helper(val.length-1,capacity,val,wt,dp);
        return answer;
    }
    
    static int helper(int index,int cap,int val[],int wt[],int[][] dp){
        
        if(index==0){//if you reach the starting index
            
            if(wt[index]<=cap) return val[index];
            
            return 0;
        }
        
        if(dp[index][cap]!=-1){
            return dp[index][cap];
        }
        
        int notpick=0+helper(index-1,cap,val,wt,dp);
        
        int pick=Integer.MIN_VALUE;
        
        if(wt[index]<=cap){
            
            pick=val[index]+helper(index-1,cap-wt[index],val,wt,dp);
            
        }
        
        dp[index][cap]=Math.max(pick,notpick);
        
        return dp[index][cap];
        
        
    }
    
}

//Tabulation

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int[][] dp=new int[val.length][capacity+1];
        
        
        
        
        int answer=helper(val.length-1,capacity,val,wt,dp);
        return answer;
    }
    
    static int helper(int index,int cap,int val[],int wt[],int[][] dp){
        //base condition for index=0
        
        for(int i=wt[0];i<=cap;i++){
            dp[0][i]=val[0];
        }
        
        //loop of the changing parameters
        
        for(int i=1;i<val.length;i++){
            for(int j=0;j<=cap;j++){
        
        int notpick=0+dp[i-1][j];
        
        int pick=Integer.MIN_VALUE;
        
        if(wt[i]<=j){
            
            pick=val[i]+dp[i-1][j-wt[i]];
            
        }
        
        dp[i][j]=Math.max(pick,notpick);
            
                
            }
        }
        
        
        return dp[index][cap];
        
        
    }
    
}