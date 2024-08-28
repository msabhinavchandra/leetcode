//TC->O(m*n) and O(1) space
//Brute

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder(strs[0]);
        for (String s : strs) {
            int i = 0;
            while (i < result.length() && i < s.length()) {
                if (result.charAt(i) != s.charAt(i)) {
                    result.setLength(i);// i->no of chars
                    break;
                }
                i++;
            }
            if (i < result.length())
                result.setLength(i);
            if (result.length() == 0)
                return "";
        }

        return result.toString();

    }
}

//Optimal O(nlogn) and O(1) space

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        // Sort the array
        Arrays.sort(strs);

        // get the first and last strings
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        // start comparing
        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i])
                break;
            result.append(first[i]);
        }
        return result.toString();
    }
}