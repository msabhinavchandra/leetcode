//Brute Force

//TC->O(n^2)
//SC->O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i : nums) {
            int checker = i;
            for (int j : nums) {
                if (checker == j) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                res = i;
                break;
            }
            count = 0;
        }
        return res;
    }
}

import java.util.HashMap;

//TC->O(n)
//SC->O(n)

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        for (int i : map.keySet()) {
            if (map.get(i) > nums.length / 2) {
                ans = i;
            }
        }
        return ans;
    }
}


//Optimal approach  Moore's Voting Algorithm

// TC->O(n) and SC->O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int el=0;

        //applying the alg
        for(int i:nums){
            if(cnt==0){
                el=i;
                cnt=1;
            }else if(el==i){
                cnt++;
            }else{
                cnt--;
            }
        }
        int checker=0;
        for(int i:nums){
            if(el==i){
                checker++;
            }
        }
        if(checker>n/2){
            return el;
        }
        return -1;
    }
}

