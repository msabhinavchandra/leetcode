import java.util.*;

class CountSubstrings {
    public int countLetters(String s) {
        int sum = 1;  // Start with the first letter
        int count = 1;  // Consecutive count for the first letter

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // If current letter matches the previous, increment the count
                count++;
            } else {
                // Reset count when a new letter starts
                count = 1;
            }
            // Add the current count to the total sum
            sum += count;
        }
        return sum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();  // Input string
        System.out.println(new CountSubstrings().countLetters(s));
    }
}
