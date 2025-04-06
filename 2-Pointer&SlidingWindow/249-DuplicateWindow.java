/*
Given an integer array of nums and an integer window size X, 
return true if there are duplicate values (nums[i]== nums[j])in that Window(X)
X size is always <= abs(i - j) where i and j are two distinct indices of array.

Input Format:
-------------
Line-1: An integer N, Array Size
Line-2: Space separated integers, array elements
Line-3: An integer X, window size

Output Format:
--------------
Line-1: Booelan value, true/false


Sample Input-1:
---------------
4
1 2 3 1  
3 

Sample Output-1: 
----------------
false

Sample Input-2:
---------------
6
1 2 3 3 2 3
2

Sample Output-2: 
----------------
true
 */

import java.util.HashSet;
import java.util.Scanner;
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < k; i++) {
            if (i < n && check(set, nums[i]))
                return true;
        }

        for (int i = k; i < n; i++) {
            set.remove(nums[i - k]);
            if (check(set, nums[i]))
                return true;
        }
        return false;
    }

    public boolean check(HashSet<Integer> set, int n) {
        if (!set.add(n))
            return true;
        return false;
    }
}