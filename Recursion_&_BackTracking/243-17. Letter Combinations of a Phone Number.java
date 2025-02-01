class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        if (digits.equals(""))
            return new ArrayList<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        findCombinations(map, 0, "", digits, result);

        return result;

    }

    public void findCombinations(Map<String, String> map, int curr, String curstr, String digits, List<String> result) {
        if (curr == digits.length()) {
            result.add(curstr);
            return;
        }

        char[] alphas = map.get("" + digits.charAt(curr)).toCharArray();

        for (char c : alphas) {
            findCombinations(map, curr + 1, curstr + "" + c, digits, result);
        }

    }

    /*
     * Algorithm
     * 1-> i will have n numbers and for every num in that n which is a string of
     * digits
     * i will have an Array
     * of alphabets
     * 2-> i will to find all the possibilities of the combinations
     * 3-> i will run a for for every combination and checkout all the possibilities
     * if this was my decision at first and undo that move
     * 4-> undo that move to check the rest of all the possibilities
     * 
     */
}