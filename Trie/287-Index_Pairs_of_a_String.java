import java.util.ArrayList;
import java.util.List;

class Trie {
    // Trie array to hold references to child nodes.
    Trie[] children = new Trie[26];
    // Flag to denote the end of a word.
    boolean isEndOfWord = false;

    // Method to insert a word into the Trie.
    public void insert(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Normalize the character to an index 0-25.
            // If the child node at that index doesn't exist, create a new Trie node.
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            // Move to the child node.
            node = node.children[index];
        }
        // Mark the end of the word.
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
        for (int startIndex = 0; startIndex < textLength; ++startIndex) {
            Trie node = trie;
            for (int endIndex = startIndex; endIndex < textLength; ++endIndex) {
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
