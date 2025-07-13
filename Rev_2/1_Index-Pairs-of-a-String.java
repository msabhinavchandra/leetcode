package Rev_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
    TrieNode[] children; // declaring
    boolean isEnd; // declaring

    TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        // first Check
        TrieNode node = root; // root is unchanged.
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // check if this letter exists in the current trie
            int numericVal = charArray[i] - 'a';
            if (node.children[numericVal] == null) {
                node.children[numericVal] = new TrieNode();
            }
            node = node.children[numericVal];
        }
        node.isEnd = true;
    }
}

class Solution {
    public static List<int[]> indexPairs(String text, String[] words) {
        Trie trie = new Trie();
        // insert all the words into the trie
        for (String str : words)
            trie.insert(str);
        List<int[]> result = new ArrayList<>();
        char[] textArray = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            TrieNode node = trie.root;
            for (int j = i; j < text.length(); j++) {
                int intChar = textArray[j] - 'a';
                if (node.children[intChar] == null)
                    break;
                node = node.children[intChar];
                if (node.isEnd)
                    result.add(new int[] { i, j });
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "thestoryofleetcodeandme";
        String[] words = { "story", "fleet", "leetcode" };
        List<int[]> pairs = indexPairs(text, words);
        for (int[] pair : pairs)
            System.out.println(Arrays.toString(pair));
    }
}
