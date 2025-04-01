// brute force
// tc-> O(n^2) and space complexity -> O(256)

class Solution {
  public int longestNonRepeatingSubstring(String s) {
    // your code goes here
    int maxLen = 0;
    int strLen = s.length();
    for (int i = 0; i < strLen; i++) {
      int[] vis = new int[256];
      for (int j = i; j < strLen; j++) {

        // if it is already visited. break the loop so that we can try for
        // other combinations of the substrings

        if (vis[s.charAt(j)] == 1) break;

        // if it is not visited then we can extend our substring

        int len = j - i + 1;

        maxLen = Math.max(maxLen, len);

        // and yes let's mark this visited
        vis[s.charAt(j)] = 1;
      }
    }
    return maxLen;
  }
}
// Optimized approach using sliding window technique

class Solution {
  public int longestNonRepeatingSubstring(String s) {
    // your code goes here
    // have a hash declare it O(256) space and O(1) tc to retrieve
    // this is the most optimal with TC->O(n) sliding window problem idk weather it is
    // fixed or variable
    int[] hash = new int[256];
    int left = 0;
    int right = 0;
    int len = 0;
    int maxLen = 0;
    int strLen = s.length();

    // i will initialize all the elements in the hashset to -1 to indicate myself
    // that initially all the alphas are unvisited.
    Arrays.fill(hash, -1);
    while (right < strLen) {

      // now my concerns with the left ptr
      // i will update it if my rt reaches a visited char
      // if my rt visits a visited char, and my lf is less than or equal to the index of that
      // visited char
      // then it is the time to concern about, that my lf becomes lf=repeatAlphaIndex+1
      // if my lf is greater than repeatIndex, then there is nothing to worry about,
      // the repeatedAlpha is anyhow not there in our window
      // but yet i will anyHow update my hash with the new Rep index because as right just crossed
      // it
      // it might be in the window for the next time lef to be aware of in that. for the future
      // concerns and
      // updations.
      if (hash[s.charAt(right)] != -1) { // the right element is alr visited.
        // update left
        left = Math.max(left, hash[s.charAt(right)] + 1);
      }
      len = right - left + 1; // new lenght of that window
      maxLen = Math.max(maxLen, len);
      // update the visited hashmap for the future check concerns for repeated chars
      hash[s.charAt(right)] = right; // with that current right index.
      // increment the right
      right++;
    }
    return maxLen;
  }
}
