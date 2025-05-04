//recursive
//[10,15,20] output:15
import java.util.Arrays;
class Sol{
    static int minCostClimbingStairsRecursive(int[] cost) {

        if (cost.length == 1) return cost[0];

        return Math.min(Cost(cost,cost.length-1),Cost(cost,cost.length-2));

    }
    public static int Cost(int[] arr,int i){

        if(i==1||i==0) return arr[i];

        return arr[i]+ Math.min(Cost(arr,i-1),Cost(arr,i-2));
    }

    //Memoization
    static int minCostClimbingStairsMemoization(int[] cost) {
        // Write your code here
        if (cost.length == 1) return cost[0];
        int[] dp=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(Cost(cost,cost.length-1,dp),Cost(cost,cost.length-2,dp));
        
    }
    public static int Cost(int[] arr,int i,int[] dp){

        //recursive function

        //base condition if i==0 or i==1

        if(i==1||i==0) return arr[i];
        
        if(dp[i]!=-1) return dp[i];

        return dp[i] = arr[i]+ Math.min(Cost(arr,i-1,dp),Cost(arr,i-2,dp));

    }

    //Tabulation
        static int minCostClimbingStairsTabulation(int[] cost) {

        if (cost.length == 1) return cost[0];
        
        return Cost(cost);
        
    }
    public static int Cost(int[] arr){

        int n=arr.length; 
        
        int[] dp=new int[n];
        
        dp[0]=arr[0];dp[1]=arr[1];
        
        for(int i=2;i<n;i++){
        
        dp[i] = arr[i] + Math.min(dp[i-1],dp[i-2]);
        
        }
        
        return Math.min(dp[n-1],dp[n-2]);

    }

    

}