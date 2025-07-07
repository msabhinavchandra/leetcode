import java.util.*;

// my code

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    boolean searchWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null)
                return false;

            node = node.children[index];
        }
        return node.isEndOfWord;
    }
}

class Solution {
    public boolean isComplete(Trie trie, String word) {
        // check for every substring
        boolean flag = true;
        for (int i = 1; i <= word.length(); i++) {
            // TrieNode node=trie.root;
            String temp = word.substring(0, i);
            if (!trie.searchWord(temp)) {
                flag = false;
            }
        }
        return flag;
    }

    public String completeString(List<String> words) {
        // code here
        Trie trie = new Trie();

        for (String str : words) {
            trie.insert(str);
        }
        // after inserting all the words check for every single
        // one of them
        String result = "";
        for (String str : words) {

            if (isComplete(trie, str) && result.length() < str.length()) {
                result = str;
            } else if (isComplete(trie, str) && result.length() == str.length()) {

                if (str.compareTo(result) < 0)
                    result = str;
            }
        }
        return result;
    }
}

// striver's code

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
class Trie2 {
    // Root node of the Trie
    Node root;

    // Initializes the Trie
    public Trie2() {
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
class Solution2 {
    public String completeString(List<String> nums) {
        Trie2 obj = new Trie2();

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

class Main {
    public static void main(String[] args) {
        // Hardcoded test cases
        List<String> testCase1 = Arrays.asList("n", "ni", "nin", "ninj", "ninja", "nil");

        // Creating a solution instance
        Solution sol = new Solution();

        // Running test cases
        System.out.println("Test Case 1: " + sol.completeString(testCase1)); // Expected: "ninja"

    }
}
