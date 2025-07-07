import java.util.ArrayList;
import java.util.List;

// index pairs of a string
// Given a string text and an array of strings words, return a list of index pairs of

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // a-z
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
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
}

class Solution {
    public List<int[]> indexPairs(String text, String[] words) {
        // Your code goes here
        // Initialize a Trie and insert all words from the array.
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // The length of the given text string.
        int textLength = text.length();
        // List to store the index pairs.
        List<int[]> matchingIndexPairs = new ArrayList<>();

        // Loop through the text to find all index pairs where words begin.
        for (int startIndex = 0; startIndex < textLength; startIndex++) {
            TrieNode node = trie.root;
            for (int endIndex = startIndex; endIndex < textLength; endIndex++) {
                // Calculate the index in the Trie children array that corresponds to the
                // current character.
                int idx = text.charAt(endIndex) - 'a';
                // If there's no child node at this index, stop this iteration.
                if (node.children[idx] == null) {
                    break;
                }
                // Move to the corresponding child node.
                node = node.children[idx];
                // If the current node marks the end of a word, add the start/end index pair to
                // the list.
                if (node.isEndOfWord) {
                    matchingIndexPairs.add(new int[] { startIndex, endIndex });
                }
            }
        }
        // Convert the list of index pairs to an int[][] array before returning.
        return matchingIndexPairs;
    }
}
