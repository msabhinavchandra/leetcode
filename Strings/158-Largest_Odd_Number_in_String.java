class Solution {
    public String largestOddNumber(String num) {
        StringBuilder result = new StringBuilder(num);
        for (int i = num.length() - 1; i >= 0; i--) {
            int t = result.charAt(i) - '0';
            if (t % 2 == 1) {
                result.delete(i + 1, num.length());
                return result.toString();
            }
        }
        return "";
    }
}

// Alternate
class Solution {
    public String largestOddNumber(String num) {
        // Loop through the string from the end to the beginning
        for (int i = num.length() - 1; i >= 0; i--) {
            // Check if the current character is an odd number
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        // Return an empty string if no odd number is found
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test the method
        String num1 = "4206";
        String num2 = "35427";
        System.out.println(solution.largestOddNumber(num1)); // Output: ""
        System.out.println(solution.largestOddNumber(num2)); // Output: "35427"
    }
}
