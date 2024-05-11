//tc->O(nlogn)+O(k)
//sc->O(1)

import java.util.*;
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int[] nums1=Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums1);
        int p=k;
        int result=0;
        while(p>0)
        {
            int temp=nums1[nums1.length-1];
            result+=temp;
            temp+=1;
            nums1[nums1.length-1]=temp;
            p--;
        }

        return result;
    }
}