//made it in-place
//TC->O(n) and SC->O(1)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1=m-1;
        int n2=n-1;
        int last=m+n-1;
        //inplace in nums1,so
        //i doesn't matter if n2 is exhausted
        //array will be sorted 
        //but if n2 is not exhausted,we need to make it 
        //exhausted
        while(n1>=0 && n2>=0){
            if(nums1[n1]>nums2[n2]){
                nums1[last]=nums1[n1];
                n1--;
            }
            else{
                nums1[last]=nums2[n2];
                n2--;
            }
            last--;
        }//end of while

        //to exhaust n2 in case if it isn't
        while(n2>=0 && last>=0){
            nums1[last]=nums2[n2];
            n2--;
            last--;
        }
    }
}