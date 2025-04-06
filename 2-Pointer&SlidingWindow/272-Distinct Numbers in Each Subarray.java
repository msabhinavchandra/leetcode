/*
Given an integer array nums and an integer k, you are asked to construct the array ans of 
size n-k+1 where ans[i] is the number of distinct numbers in the subarray nums[i:i+k-1] = 
[nums[i], nums[i+1], ..., nums[i+k-1]]. 
Return the array ans. 
 
Example 1: 
Input: nums = [1,2,3,2,2,1,3], k = 3 
Output: [3,2,2,2,3] 
Explanation: The number of distinct elements in each subarray goes as follows: - nums[0:2] = [1,2,3] so ans[0] = 3 - nums[1:3] = [2,3,2] so ans[1] = 2 - nums[2:4] = [3,2,2] so ans[2] = 2 - nums[3:5] = [2,2,1] so ans[3] = 2 - nums[4:6] = [2,1,3] so ans[4] = 3 
 
Example 2: 
Input: nums = [1,1,1,1,2,3,4], k = 4 
Output: [1,2,3,4] 
Explanation: The number of distinct elements in each subarray goes as follows: - nums[0:3] = [1,1,1,1] so ans[0] = 1 - nums[1:4] = [1,1,1,2] so ans[1] = 2 - nums[2:5] = [1,1,2,3] so ans[2] = 3 - nums[3:6] = [1,2,3,4] so ans[3] = 4 
 Constraints: 
1 <= k <= nums.length <= 105 
1 <= nums[i] <= 105 

The time complexity to O(n) by using the sliding window technique 
The idea is to store the frequency of elements in the current window in a map and keep track 
of the distinct elements count in the current window (of size k). The code can be optimized 
to derive the count of elements in any window using the count of elements in the previous 
window by inserting the new element to the previous window from its right and removing an 
element from its left.  */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DistinctCount {
    // Function to find the count of distinct elements in every subarray of size `k` in the array
    public static void findDistinctCount(int[] A, int k) {
        // Map to store the frequency of elements in the current window of size `k`
        Map<Integer, Integer> freq = new HashMap<>();

        // Maintains the count of distinct elements in every subarray of size `k`
        int distinct = 0;

        // Loop through the array
        for (int i = 0; i < A.length; i++) {
            // Ignore the first `k` elements
            if (i >= k) {
                /* Remove the first element from the subarray by reducing its
                   frequency in the map */
                freq.put(A[i - k], freq.getOrDefault(A[i - k], 0) - 1);

                // Reduce the distinct count if we are left with 0
                if (freq.get(A[i - k]) == 0) {
                    distinct--;
                }
            }

            // Add the current element to the subarray by incrementing its count in the map
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);

            /* Increment distinct count by 1 if element occurs for the first time in
               the current window */
            if (freq.get(A[i]) == 1) {
                distinct++;
            }

            // Print count of distinct elements in the current subarray 
            if (i >= k - 1) {
                System.out.println(distinct);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        findDistinctCount(array, k);
    }
}
