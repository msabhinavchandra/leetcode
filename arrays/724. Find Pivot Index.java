//O(n)->TC
//O(1)->SC

class Solution {
    public int pivotIndex(int[] nums) {
        int lfsum=0;
        int total=0;
        for(int n:nums){
            total+=n;
        }
        for(int i=0;i<nums.length;i++){
            int rtsum=total-lfsum-nums[i];
            if(rtsum==lfsum){
                return i;
            }
            lfsum+=nums[i];
        }
        return -1;
    }
}