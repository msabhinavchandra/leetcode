//brute
//TC->O(n) and SC->O(n)
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> d = new HashMap<>();
        
        // First loop to populate the HashMap
        for (int i = 0; i < nums.length; i++) {
            if (!d.containsKey(nums[i])) {
                d.put(nums[i], 1);
            } else {
                d.put(nums[i], d.get(nums[i]) + 1);
            }
        }

        // Second loop to find the single number
        for (int key : d.keySet()) {
            if (d.get(key) == 1) {
                return key;
            }
        }

        // In case no single number is found
        return -1;
    }
}

//optimal
//TC->O(n) and SC->O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        
        for (int i = 0; i < nums.length; i++) {
            ans = nums[i] ^ ans;
        }
        
        return ans;
    }
}
