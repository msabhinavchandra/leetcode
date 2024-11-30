// Given a integer value N, indicates number of bits in a binary number.

// An n-bit gray code sequence is a sequence of 2n integers where:
//  -Every integer is in the inclusive range [0, 2n - 1],
//  -The first integer is 0,
//  -An integer appears no more than once in the sequence,
//  -The binary representation of every pair of adjacent integers differs by exactly one bit, and
//  -The binary representation of the first and last integers differs by exactly one bit.

// Given an integer n, return any valid n-bit gray code sequence.

// Input Format:
// -------------
// Line-1: A integer N

// Output Format:
// --------------
// Line-1: Print the list of integer values.

// Sample Input-1:
// ---------------
// 2

// Sample Output-1:
// ----------------
// [0, 1, 3, 2]

// Explanation:
// ------------
// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2

// Sample Input-2:
// ---------------
// 3

// Sample Output-2:
// ----------------
// [0, 1, 3, 2, 6, 7, 5, 4]

// Explanation:
// ------------
// 000 - 0
// 001 - 1
// 011 - 3
// 010 - 2
// 110 - 6
// 111 - 7
// 101 - 5
// 100 - 4

import java.util.*;

class GrayCodeBacktracking {
  int n;

  public List<Integer> grayCode() {
    List<Integer> result = new ArrayList<>();
    result.add(0);
    grayCodeHelper(result, 0);
    return result;
  }

  private boolean grayCodeHelper(List<Integer> result, int current) {
    if (result.size() == (int)Math.pow(2, n))
        return true; // Valid sequence found

    for (int i = 0; i < n; i++) { 
      int next = current ^ (int)Math.pow(2, i); // Flip the ith bit
      if (!result.contains(next)) { // Ensure no duplicates
        result.add(next);
        if (grayCodeHelper(result, next)) 
          return true; // If valid sequence, return immediately
        
        // Backtrack
        result.remove(result.size() - 1);
      }
    }
    return false;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    GrayCodeBacktracking gc = new GrayCodeBacktracking();
    gc.n = sc.nextInt();
    System.out.println(gc.grayCode());
  }
}

//Leetcode my Solution

class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        result.add(0);
        set.add(0);
        if (grayCodeHelper(0, n, result, set))
            return result;

        return result;

    }

    public boolean grayCodeHelper(int curr, int noOfBits, List<Integer> result, Set<Integer> visited) {

        // base condition
        if (result.size() == (int) Math.pow(2, noOfBits))
            return true;
        // check for all possible cases
        for (int i = 0; i < noOfBits; i++) {
            int next = curr ^ (int) Math.pow(2, i);
            if (!visited.contains(next)) {
                result.add(next);
                visited.add(next);
                if (grayCodeHelper(next, noOfBits, result, visited))
                    return true;
                // if this possibility doesn't end up giving the answer
                // backtrack
                result.remove(next);
                visited.remove(next);
            }
        }
        return false;

    }
}