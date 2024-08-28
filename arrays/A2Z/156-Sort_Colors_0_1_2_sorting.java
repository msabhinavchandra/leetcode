//brute merge sort or quick or insertion sort Time Complexity: O(N*logN) Space Complexity: O(1)

//Better TC->O(2N) and SC->O(1)

   public static void sortArray(ArrayList<Integer> arr, int n) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) cnt0++;
            else if (arr.get(i) == 1) cnt1++;
            else cnt2++;
        }

        //Replace the places in the original array:
        for (int i = 0; i < cnt0; i++) arr.set(i, 0); // replacing 0's

        for (int i = cnt0; i < cnt0 + cnt1; i++) arr.set(i, 1); // replacing 1's

        for (int i = cnt0 + cnt1; i < n; i++) arr.set(i, 2); // replacing 2's
    }

//Optimal tc->O(n) and SC->O(1)
class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;//0 to low-1--->0
        while(mid<=high){//low to mid-1--->1
            if(nums[mid]==0){//mid to high--->random
            //high-1 to n-1--->2
                //swap between mid and low and increment
                int temp=nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                low++;mid++;
            }else if(nums[mid]==1)
                mid++;
            else if(nums[mid]==2){
                //Swap high and mid
                int temp=nums[high];
                nums[high]=nums[mid];
                nums[mid]=temp;
                high--;
            }
        }
        
    }
}