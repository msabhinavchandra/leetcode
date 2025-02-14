//brute force using arraylist and deleting the elements




class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // window size is actually k+1
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        k++;
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