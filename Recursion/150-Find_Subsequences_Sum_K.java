//TC and SC same as any Subseq prob O(n*2^n) and O(n)
import java.util.*;

public class PerfectSumProblem{
    //Modulo constant...in a few problems you need to consider such things
    private static final int MOD=1000000007;
    //Function to get all subsets with sum equal to the given sum
    public static List<List<Integer>> getSubsetsWithSum(int[] arr,int n,int targetSum){
        List<List<Integer>> result=new ArrayList<>();//to store the final result 
        //all the subsequences
        List<Integer> currenSubset=new ArrayList<>();//to store the current subset being
        //explored.

        //call the recursive function with the current subset and result list.
        findsubsets(arr,n,0,0,targetSum,currentSubset,result);

        return result;

    }

    public static void findsubsets(int[] arr,int n,int index,int currentSum,int targetSum,List<Integer> currentSubset,List<List<Integer>> result){
        //Base case:if we have considered all elements
        if(index==n){
            //check if the sum of the current subset is equal to the target sum.
            if(currentSum==targetSum)
                result.add(new ArrayList<>(currentSubset));
        }
        return;//return whether or not the subset matched the sum.
    }

    //option 1:include the current element in the subset
    currentSubset.add(arr[index]);//include the element in the current subset.
    int newSum=currentSum+arr[index];//newCurrSum...
    findsubsets(arr,n,index+1,newSum,targetSum,currentSubset,result);
    //BackTrack to remove the element.
    currentSubset.remove(currentSubset.size()-1);//element will be removed in an indexed way
    //option 2:Exclude the current element in the subset
    findsubsets(arr,n,index+1,currentSum,targetSum,currentSubset,result);
}

//Count the no of subsequences whoose sum==k

class Solution{
    
    private static final int MOD=1000000007;
    
    public static int countSubsetsHelper(int[] arr,int n,int index,int currentSum,int targetSum){
        //Base case:if we have considered the subsets with a sum equal to targetSum
        if(index==n){
            //check if the sum of the current subset is equal to the target sum.
            if(currentSum==targetSum)
                return 1;//Count this subset
                
            return 0;//Do not count this subset.
        }
        
        //option 1:include the current element in the subset
        int updatedSum=currentSum+arr[index];
        int include=countSubsetsHelper(arr,n,index+1,updatedSum,targetSum);
        
        //option 2:Exclude the current element in the subset.
        int exclude=countSubsetsHelper(arr,n,index+1,currentSum,targetSum);
        
        //return the total count of subsets by includeing and excluding the current element...further
        //exploring all the possibilities
        return (include+exclude)%MOD;
        
        
    }

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    return countSubsetsHelper(arr,n,0,0,sum);
	} 
}