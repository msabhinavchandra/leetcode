// brute force
class Solution {
  public int longestOnes(int[] nums, int k) {
    // your code goes here
    /* it is important you handle every single case carefully and separately
    handle every single case,
    this is the brute force solution
    TC->O(N^2) and SC->O(1) no extra space i am making use of existing space
    */
    // i am exploring all kind of possibilities 
    int len = nums.length;
    int currZeroes = 0;
    int maxLen = 0;
    for (int i = 0; i < len; i++) {
      currZeroes = 0;
      int currLen = 0;
      for (int j = i; j < len; j++) {
        // will check if it is a zero
        if (nums[j] == 0) {
          // increment the count of zeroes
          currZeroes++;
        }
        // if k==0
        if (currZeroes == 0) {
          currLen = j - i + 1;
        }
        // if every element in the nums is 0 and k=nums.length
        else if (currZeroes == k) {
          currLen = j - i + 1;
        }
        // if no of zeroes < k
        else if (currZeroes < k) { //
          currLen = j - i + 1;
        }
        maxLen = Math.max(currLen, maxLen);
      }
    }
    return maxLen;
  }
}

// better
class Solution {
  public int longestOnes(int[] nums, int k) {
    // your code goes here
    // time complexity O(k*N) and the space complexity O(1)
    int left = 0;
    int right = 0;
    int maxLen = 0;
    int currLen = 0;
    int currZeroes = 0;
    int size = nums.length;
    while (right < size) {
      // check for zeroes
      if (nums[right] == 0) {
        currZeroes++;
      }
      // modify the window according to our constraints
      while (currZeroes > k) { // i want to make currZeroes<=k
        if (nums[left] == 0) currZeroes--;
        left++;
      }
      currLen = right - left + 1;
      maxLen = Math.max(maxLen, currLen);
      right++;
    }
    return maxLen;
  }
}

// optimal solution
class Solution {
  public int longestOnes(int[] nums, int k) {
    // your code goes here
    // optimal approach
    // time complexity O(N)
    // space complexity O(1)

    int left = 0;
    int right = 0;
    int len = nums.length;
    int currZeroes = 0;
    int maxLen = 0;

    while (right < len) {
      // check for zeroes
      if (nums[right] == 0) currZeroes++;

      // for improper windows, just retain the size(which is maxSize)
      if (currZeroes > k) {
        if (nums[left] == 0) currZeroes--;
        left++;
      }
      if (currZeroes <= k) {
        // then it became a proper window
        // you can calculate the length
        int currlen = right - left + 1;
        maxLen = Math.max(maxLen, currlen);
      }
      right++;
    }
    return maxLen;
  }
}
