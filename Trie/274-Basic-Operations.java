class TrieNode {
    TrieNode[] children;  // Array to store child nodes (26 for each alphabet letter)
    boolean isEndOfWord;  // True if the node marks the end of a word

    public TrieNode() {
        children = new TrieNode[26];  // 26 letters in the English alphabet
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();  // Create the root node
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';  // Calculate the index (0-25) for the character

            // If the character is not present, create a new TrieNode
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            // Move to the next node
            node = node.children[index];
        }

        // Mark the end of the word
        node.isEndOfWord = true;
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';  // Calculate the index for the character

            // If the character is not present, the word does not exist
            if (node.children[index] == null) {
                return false;
            }

            // Move to the next node
            node = node.children[index];
        }

        // Return true if we have reached the end of the word
        return node.isEndOfWord;
    }

    // Check if there is any word starting with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';  // Calculate the index for the character

            // If the character is not present, there is no word with this prefix
            if (node.children[index] == null) {
                return false;
            }

            // Move to the next node
            node = node.children[index];
        }

        // If we have successfully traversed the prefix, return true
        return true;
    }
}

public class TrieExample {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words into the trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        // Search for words in the trie
        System.out.println(trie.search("apple"));  // true
        System.out.println(trie.search("app"));    // true
        System.out.println(trie.search("banana")); // true
        System.out.println(trie.search("ban"));    // false

        // Check if there is any word starting with the prefix
        System.out.println(trie.startsWith("ban")); // true
        System.out.println(trie.startsWith("grape")); // false
    }
}
