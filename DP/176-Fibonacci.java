import java.util.Arrays;
//Memo
public class FibonacciMemoization {
    
    // Function to calculate Fibonacci number using memoization
    public static int f(int n, int[] dp) {
        // Base case: return n if n is 0 or 1
        if (n <= 1) return n;

        // If the value is already calculated, return it
        if (dp[n] != -1) return dp[n];

        // Calculate the value and store it in dp array
        dp[n] = f(n - 1, dp) + f(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; // Fibonacci number to find
        int[] dp = new int[n + 1]; // Initialize dp array
        Arrays.fill(dp, -1); // Fill dp array with -1

        // Output the nth Fibonacci number
        System.out.println(f(n, dp));
    }
}

//Tab

import java.util.Arrays;

class TUF {
    public static void main(String[] args) {
        int n = 5; // Fibonacci number to find
        int dp[] = new int[n + 1]; // Initialize dp array

        dp[0] = 0; // Base case for Fibonacci sequence
        dp[1] = 1; // Base case for Fibonacci sequence

        // Fill the dp array using the tabulation method
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Output the nth Fibonacci number
        System.out.println(dp[n]);
    }
}

//Space opt

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5; // Fibonacci number to find

        // Edge case: if n is 0, the result is 0
        if (n == 0) {
            System.out.println(0);
            return;
        }

        // Edge case: if n is 1, the result is 1
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int prev2 = 0; // Fibonacci number for n-2
        int prev = 1;  // Fibonacci number for n-1

        // Iterate from 2 to n to find the nth Fibonacci number
        for (int i = 2; i <= n; i++) {
            int cur_i = prev2 + prev; // Current Fibonacci number
            prev2 = prev;             // Update prev2 to the previous Fibonacci number
            prev = cur_i;             // Update prev to the current Fibonacci number
        }

        // Print the nth Fibonacci number
        System.out.println(prev);
    }
}
