/* You are given an integer array nums of length n and an integer target. 
Your task is to find three integers in nums such that their sum is closest to the given target.

Return the sum of these three integers.

You may assume that each input would have exactly one solution.

Input Format:
-------------
Line-1: An integer n, the size of the array.
Line-2: n space-separated integers representing the elements of the array nums.
Line-3: A single integer target.

Output Format:
--------------
Line-1: Print a single integer, representing the sum of three integers closest to the target.

Sample Input-1:
---------------
4
-1 2 1 -4
1

Sample Output-1:
----------------
2

Sample Input-2:
---------------
3
0 0 0
1

Sample Output-2:
----------------
0

*/

import java.util.*;
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target){
        int absDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            int take = nums[i];
            int newTarget = (target - take);
            int internal = twoSum(i, nums, newTarget);
            int sum = take + internal;
            if (sum == target)
                return sum;
            int diff = Math.abs(sum - target);
            if (diff < absDiff){
                absDiff = diff;
                result = sum;
            }
        }
        return result;
    }

    public int twoSum(int ignore, int[] nums, int target){
        // need to return the sum of two numbers in nums[] which is closest to target
        // ignore the number at index ignore
        int result = 0;
        int left = 0;
        int right = nums.length - 1;
        int absDiff = Integer.MAX_VALUE;
        while (left < right){
            if (left == ignore)
                left++;
            if (right == ignore)
                right--;
            if (left >= right)
                break;
            int sum = nums[left] + nums[right];
            int diff = Math.abs(sum - target);
            if (diff < absDiff){
                absDiff = diff;
                result = sum;
            }
            if (sum == target)
                return result;
            if (sum > target){
                right--;
            }
            if (sum < target){
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ThreeSumClosest ts = new ThreeSumClosest();
        int size = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(ts.threeSumClosest(nums, target));
    }
}
