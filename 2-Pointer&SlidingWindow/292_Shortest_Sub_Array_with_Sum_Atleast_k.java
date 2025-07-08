import java.util.Deque;
import java.util.LinkedList;

// LeetCode 862 - Shortest Subarray with Sum at Least K
// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
// Time Complexity: O(N)
// Space Complexity: O(N)
// This solution uses a sliding window approach with a deque to maintain the indices of 
// potential starting points for subarrays. 
// The goal is to find the shortest subarray such that the sum of its elements is at least K.
// The prefix sum array is used to efficiently calculate the sum of any subarray.
// The deque is used to keep track of the indices of the prefix sums in a way that allows us 
// to quickly find the smallest subarray length.
// The algorithm iterates through the prefix sums, maintaining the deque such that it always contains 
//indices
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N + 1];
        for (int i = 0; i < N; i++) 
            P[i + 1] = P[i] + (long) A[i];
        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N + 1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList<>(); // opt(y) candidates, as indices of P
        for (int y = 0; y < P.length; y++) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());
            monoq.addLast(y);
        }
        return ans < N + 1 ? ans : -1;
    }
}