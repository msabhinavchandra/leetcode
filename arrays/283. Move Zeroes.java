//O(n) tc
//O(1) sc

class Solution {
    public void moveZeroes(int[] nums) {
        int lf = 0;
        int rt = 1;
        int temp = 0;
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        while (rt < nums.length) {
            if (nums[lf] == 0 && nums[rt] != 0) {
                temp = nums[lf];
                nums[lf] = nums[rt];
                nums[rt] = temp;
                lf += 1;
            }
            if (nums[lf] != 0) {
                lf += 1;
            }
            rt += 1;
        }

    }
}