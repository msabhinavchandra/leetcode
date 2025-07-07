import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    // Performs DFS traversal on the Trie to collect all words into the priority
    // queue
    public static void collectWords(TrieNode currentNode, PriorityQueue<TrieNode> pq) {
        if (currentNode == null) 
            return;
        
        if (currentNode.isEndOfWord) 
            pq.add(currentNode);
        
        for (int i = 0; i < 26; i++) 
            collectWords(currentNode.children[i], pq);
        
    }

    public List<String> topKFrequent(String[] words, int k) {
        Trie trie = new Trie();
        // Insert all words into the Trie and track their frequencies
        for (String word : words) {
            trie.insertWord(word);
        }
        // Max-heap to store TrieNodes ordered by frequency descending and lex order
        // ascending
        PriorityQueue<TrieNode> pq = new PriorityQueue<>((node1, node2) -> {
            if (node1.frequency == node2.frequency) {
                return node1.word.compareTo(node2.word); // lex order if frequency equal
            }
            return node2.frequency - node1.frequency; // higher frequency first
        });
        TrieNode rootNode = trie.getRootNode();
        collectWords(rootNode, pq);
        List<String> result = new ArrayList<>();
        while (k > 0) {
            TrieNode node = pq.poll();
            result.add(node.word);
            k--;
        }
        return result;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    String word;
    int frequency;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
        this.word = "";
        this.frequency = 0;
    }
}

class Trie {
    TrieNode rootNode;

    Trie() {
        this.rootNode = new TrieNode();
    }

    TrieNode getRootNode() {
        return rootNode;
    }

    void insertWord(String word) {
        TrieNode currentNode = rootNode;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
        currentNode.frequency++;
        currentNode.word = word;
    }
}