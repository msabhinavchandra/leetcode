//My way.
class Solution {
    public List<String> generateParenthesis(int n) {
        // Initialize the result list to store all combinations
        List<String> result = new ArrayList<>();
        
        // Start the recursive helper with an empty StringBuilder and n open/close brackets
        helper(new StringBuilder(), n, n, result);
        
        return result;
    }

    public static void helper(StringBuilder sb, int open, int close, List<String> result) {
        // If no more brackets to add, add the current combination to the result list
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }
        
        // If we can still add an open bracket
        if (open > 0) {
            sb.append('(');
            helper(sb, open - 1, close, result);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
        
        // If we can add a close bracket (only if there are more close than open brackets)
        if (close > open) {
            sb.append(')');
            helper(sb, open, close - 1, result);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
}

//Striver way
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        /**
         * Generates all combinations of n pairs of balanced parentheses.
         *
         * @param n The number of pairs of parentheses.
         * @return A list containing all valid combinations of parentheses.
         */
        List<String> result = new ArrayList<>();
        // Start the recursive generation with initial values
        generate(0, 0, n, "", result);
        return result;
    }

    private void generate(int open, int close, int n, String current, List<String> result) {
        /**
         * A recursive helper function to generate all combinations
         * of balanced parentheses.
         *
         * @param open The number of open parentheses used so far.
         * @param close The number of close parentheses used so far.
         * @param n The total number of pairs of parentheses.
         * @param current The current string being built.
         * @param result The list storing all valid combinations.
         */
        // Base case: if the number of open and close parentheses used
        // is equal to the total number of pairs, add the string to the result.
        if (open == close && open + close == 2 * n) {
            result.add(current);
            return;
        }

        // If the number of open parentheses used is less than the total
        // number of pairs, add an open parenthesis and call the function recursively.
        if (open < n) {
            generate(open + 1, close, n, current + '(', result);
        }

        // If the number of close parentheses used is less than the number
        // of open parentheses, add a close parenthesis and call the function recursively.
        if (close < open) {
            generate(open, close + 1, n, current + ')', result);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3; // Example input
        List<String> result = sol.generateParenthesis(n);

        System.out.println("All combinations of balanced parentheses for n = " + n + " are:");
        for (String combination : result) {
            System.out.println(combination);
        }
    }
}
 
