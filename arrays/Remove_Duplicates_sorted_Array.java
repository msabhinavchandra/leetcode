//Tc->O(n) and SC->O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        //the first element is always unique
        //so let's start from 1
        int lf=1;
        int rt=1;
        while(rt<nums.length){
            if(nums[rt-1]==nums[rt]){
                rt++;
            }else{
                nums[lf]=nums[rt];
                rt++;
                lf++;
            }
        }//end of loop
        return lf;

    }
}