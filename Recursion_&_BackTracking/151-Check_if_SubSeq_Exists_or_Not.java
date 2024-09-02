// TC->O(2^n) and space O(n) stack space will fail for larger test cases...need DP to optimize

public class Solution {
    public static boolean isSubsetPresent(int n, int k,int []a) {
        // Write your code here
        int index=0;
        int currentSum=0;
        int targetSum=k;
        return Helper(a, n, index, currentSum, targetSum);
    }
    public static boolean Helper(int[] arr, int n,int index, int currentSum,int targetSum){
        if(index==n){
            if(currentSum==targetSum){
                return true;
            }
            return false;
        }
        int newSum=currentSum+arr[index];
        if(Helper(arr, n, index+1, newSum, targetSum))
            return true;
        if(Helper(arr, n, index+1, currentSum, targetSum))
            return true;
            
        return false;
    }
}