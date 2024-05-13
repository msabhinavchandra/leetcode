//T->O(n)
//S->O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> Mark=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(Mark.contains(nums[i])){
                return true;
            }
            Mark.add(nums[i]);
        }
        return false;
    }
}