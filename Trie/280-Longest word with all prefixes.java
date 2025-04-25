import java.util.*;

class Node {
    // To store references to child nodes
    Node[] links = new Node[26];
    // Flag to indicate end of a word
    boolean flag = false;

    // Checks if the current character link exists
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Returns the next node corresponding to the character
    Node get(char ch) {
        return links[ch - 'a'];
    }

    // Creates a link to the next node for the current character
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    // Marks the end of a word
    void setEnd() {
        flag = true;
    }

    // Checks if the current node is the end of a word
    boolean isEnd() {
        return flag;
    }
}

// Class representing the Trie (Prefix Tree) structure
class Trie {
    // Root node of the Trie
    Node root;

    // Initializes the Trie
    public Trie() {
        root = new Node();
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        // Marks the end of the inserted word
        node.setEnd();
    }

    // Checks if all prefixes of the given word exist in the Trie
    public boolean checkIfAllPrefixExists(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                if (!node.isEnd()) {
                    // Prefix is incomplete, return false
                    return false;
                }
            } else {
                // Return false if a character link is missing
                return false;
            }
        }
        // All prefixes exist
        return true;
    }
}

// Solution class to find the longest word with all its prefixes present
class Solution {
    public String completeString(List<String> nums) {
        Trie obj = new Trie();

        // Insert all words into the Trie
        for (String num : nums) {
            obj.insert(num);
        }

        String longest = ""; // Stores the longest valid word

        // Check each word to find the longest one where all prefixes exist
        for (String num : nums) {
            if (obj.checkIfAllPrefixExists(num)) {
                if (num.length() > longest.length()) {
                    longest = num;
                } else if (num.length() == longest.length() && num.compareTo(longest) < 0) {
                    longest = num; // Lexicographically smaller word
                }
            }
        }
        return longest.isEmpty() ? "None" : longest; // Return result or "None"
    }
}

public class Main {
    public static void main(String[] args) {
        // Hardcoded test cases
        List<String> testCase1 = Arrays.asList("n", "ni", "nin", "ninj" , "ninja" , "nil");
       

        // Creating a solution instance
        Solution sol = new Solution();

        // Running test cases
        System.out.println("Test Case 1: " + sol.completeString(testCase1)); // Expected: "ninja"
       
    }
}
