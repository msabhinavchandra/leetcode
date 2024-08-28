class Solution {
    public String reverseWords(String s) {
        Stack<String> St = new Stack<>();
        StringBuilder result = new StringBuilder();
        // String ns=s.trim();
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >= 1; i--) {
            result.append(words[i] + " ");
        }
        result.append(words[0]);

        return result.toString();

    }
}