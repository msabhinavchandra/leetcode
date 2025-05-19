public class TrieBasicOperations {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        System.out.println("Before Deletion:");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.search("banana"));  // true

        trie.delete("apple");
        trie.delete("banana");

        System.out.println("\nAfter Deletion:");
        System.out.println(trie.search("apple"));   // false
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.search("banana"));  // false

        System.out.println("\nPrefix Search:");
        System.out.println(trie.startsWith("app")); // true
        System.out.println(trie.startsWith("ban")); // false
        System.out.println(trie.startsWith("grape")); // false
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // a-z
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

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

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        return node.isEndOfWord;
    }

    // Check if there is any word starting with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        return true;
    }

    // Delete a word from the trie
    public void delete(String word) {
        root = deleteHelper(root, word, 0);
    }

    private TrieNode deleteHelper(TrieNode root, String word, int depth) {
        if (root == null) return null;

        if (depth == word.length()) {
            if (root.isEndOfWord) {
                root.isEndOfWord = false;
            }

            if (isEmpty(root)) {
                return null;
            }

            return root;
        }

        int index = word.charAt(depth) - 'a';
        root.children[index] = deleteHelper(root.children[index], word, depth + 1);

        if (isEmpty(root) && !root.isEndOfWord) {
            return null;
        }

        return root;
    }

    private boolean isEmpty(TrieNode node) {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null)
                return false;
        }
        return true;
    }
}

