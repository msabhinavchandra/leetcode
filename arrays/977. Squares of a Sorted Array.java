// craziest approach
//awesome problem

//solved in O(n) tc
//sc->O(n) for storing the result
//i think need not be counted.

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result=new int[nums.length];
        int tpr=nums.length-1;
        int lf=0;
        int rt=nums.length-1;
        while(lf<=rt && tpr>=0){
            if(nums[lf]*nums[lf]>nums[rt]*nums[rt]){
                result[tpr]=nums[lf]*nums[lf];
                lf++;
                
            }else{
                result[tpr]=nums[rt]*nums[rt];
                rt--;
            }
            tpr--;
        }//end of while
        return result;
    }
}