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

//Myself logic to code successfull conversion
class Solution2 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0||nums.length==1) return nums.length;
        int lf=0;
        int rt=1;
        while(rt<nums.length){
            if(nums[lf]==nums[rt]){
                rt+=1;
            }else if(nums[lf]!=nums[rt]){
                lf+=1;
                nums[lf]=nums[rt];
                rt+=1;
            }
        }
        return lf+1;
    }
}