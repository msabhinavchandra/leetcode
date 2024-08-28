class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (Character c : s.toCharArray()) {
            temp.append(c);
            if (c.equals('('))
                st.push(c);
            else
                st.pop();
            if (st.empty()) {
                temp.deleteCharAt(0);
                temp.deleteCharAt(temp.length() - 1);
                result.append(temp);
                temp.setLength(0);
            }
        }
        return result.toString();

    }
}