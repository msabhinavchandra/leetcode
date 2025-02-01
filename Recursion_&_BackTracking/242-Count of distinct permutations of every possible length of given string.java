//will get a tle checkout the math in the future.
import java.util.*;

public class Solution {
    
    // This method counts all distinct words that can be formed from the cubes.
    public static int countDistinctWords(String s) {
        Set<String> distinctWords = new HashSet<>();
        int n = s.length();
        // Generate permutations for every possible length from 1 to n.
        for (int targetLength = 1; targetLength <= n; targetLength++) {
            boolean[] used = new boolean[n];
            generatePermutations(s, "", distinctWords, targetLength, used);
        }
        return distinctWords.size();
    }
    
    // Recursively generate all permutations of the given target length.
    private static void generatePermutations(String s, String current, Set<String> distinctWords, 
                                             int targetLength, boolean[] used) {
        if (current.length() == targetLength) {
            distinctWords.add(current);
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                generatePermutations(s, current + s.charAt(i), distinctWords, targetLength, used);
                used[i] = false; // backtrack
            }
        }
    }
    
    public static void main(String[] args) {
        // Test with the sample inputs
        String test1 = "EGG";
        System.out.println("Distinct words count for " + test1 + ": " + countDistinctWords(test1)); 
        // Expected output: 8

        String test2 = "MADAM";
        System.out.println("Distinct words count for " + test2 + ": " + countDistinctWords(test2)); 
        // Expected output: 89
    }
}
