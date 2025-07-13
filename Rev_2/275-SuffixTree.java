package Rev_2;

import java.util.*;

class SuffixTrie {
    static final int NUM_CHARS = 26; // For lowercase 'a' to 'z'

    // Node class representing each character node in the trie
    static class SuffixTrieNode {
        SuffixTrieNode[] children = new SuffixTrieNode[NUM_CHARS];
        boolean isEndOfWord; // True if this node represents the end of a word

        SuffixTrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < NUM_CHARS; i++)
                children[i] = null;
        }
    }

    static SuffixTrieNode root = new SuffixTrieNode();

    // Function to insert all suffixes of a string into the suffix trie
    static void buildSuffixTrie(String text) {
        for (int i = 0; i < text.length(); i++) {
            insert(text.substring(i));
        }
    }

    // Insert a single word into the trie
    static void insert(String word) {
        SuffixTrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new SuffixTrieNode();
            }

            node = node.children[index];
        }

        node.isEndOfWord = true;
    }

    // Recursive function to print all suffixes from the trie in lexicographical
    // order
    static void printAllSuffixes(SuffixTrieNode node, char[] buffer, int depth) { 
        if (node == null)
            return;
        // If current node marks end of a word, print the buffer up to current depth
        if (node.isEndOfWord) {
            System.out.println(new String(buffer, 0, depth)); // Print the current suffix
        }
        // Traverse all possible children from 'a' to 'z'
        for (int i = 0; i < NUM_CHARS; i++) {
            if (node.children[i] != null) {
                buffer[depth] = (char) (i + 'a'); // Save character to buffer
                printAllSuffixes(node.children[i], buffer, depth + 1); // Recurse deeper
            }
        } 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a lowercase string: ");
        String input = sc.nextLine();

        buildSuffixTrie(input);

        System.out.println("All suffixes in lexicographical order:");
        char[] buffer = new char[input.length()];
        printAllSuffixes(root, buffer, 0);
    }
}
