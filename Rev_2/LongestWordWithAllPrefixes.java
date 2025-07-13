package Rev_2;

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

public class LongestWordWithAllPrefixes {
    public static boolean isComplete(Trie trie, String word) {
        // check for every substring
        boolean flag = true;
        for (int i = 1; i <= word.length(); i++) {
            String temp = word.substring(0, i);
            if (!trie.searchWord(temp)) {
                flag = false;
            }
        }
        return flag;
    }

    public static String completeString(List<String> words) {
        Trie trie = new Trie();

        for (String str : words) {
            trie.insert(str);
        }
        String result = ""; 
        for (String str : words) {
            if (isComplete(trie, str) && result.length() < str.length()) {
                result = str;
            } else if (isComplete(trie, str) && result.length() == str.length()) {
                if (str.compareTo(result) < 0)
                    result = str;
            }
        }
        return result.isEmpty() ? "None" : result;
    }

    public static void main(String[] args) {
        List<String> testCase1 = Arrays.asList("n", "ni", "nin", "ninj", "ninja", "nil");
        String result = completeString(testCase1);
        System.out.println("Test Case 1: " + result); // Expected: "ninja"
    }
}
