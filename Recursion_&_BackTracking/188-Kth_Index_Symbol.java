/*
We build a table of n rows (1-indexed). The table is generated based on the following rules:
	The first row (for n = 1) contains a single symbol 0.
	For each subsequent row n, every 0 in the previous row is replaced with 01, and every 1 is replaced with 10.

The problem is to return the k-th symbol (1-indexed) in the n-th row of the table.

Input Format:
-------------
Line-1: An integer, represents n is the row number
Line-2: An integer, represents k is the position in the row

Output Format:
--------------
Line-1: Return either 0 or 1, representing the k-th symbol in the n-th row.

Sample Input-1:
---------------
1 //n
1 //k

Sample Output-1:
----------------
0

Sample Input-2:
---------------
2 //n
1 //k

Sample Output-2:
----------------
0

Explanation: 
row 1: 0
row 2: 01

Sample Input-3:
---------------
2 //n
2 //k

Sample Output-3:
----------------
1

Explanation: 
row 1: 0
row 2: 01


Constraints:
1 ≤ n ≤ 30
1 ≤ k ≤ 2^(n-1)

Explanation on approach:
The generation of the rows follows a pattern based on the previous row:
	For n = 1, the row is 0.
	For n = 2, replace 0 with 01: the row becomes 01.
	For n = 3, replace each 0 with 01 and each 1 with 10: the row becomes 0110.
	For n = 4, the row becomes 01101001.

To solve this problem recursively:
If k is less than or equal to half of the length of the previous row, the value is the same as in the previous row.
Otherwise, we apply a "NOT" operation to the value in the second half of the previous row.*/

//Brute exponential

public class KthSymbol {
    
    // Brute force method to generate the nth row and return the kth symbol
    public static int kthSymbolBruteForce(int n, int k) {
        // Start with the first row
        String currentRow = "0";
        
        // Generate each row up to n
        for (int i = 2; i <= n; i++) {
            StringBuilder nextRow = new StringBuilder();
            for (char c : currentRow.toCharArray()) {
                if (c == '0') {
                    nextRow.append("01");
                } else {
                    nextRow.append("10");
                }
            }
            currentRow = nextRow.toString();
        }
        
        // Return the k-th symbol (1-indexed, so k-1 for 0-indexed string)
        return currentRow.charAt(k - 1) - '0';
    }
    
    public static void main(String[] args) {
        int n = 4;
        int k = 5;
        System.out.println(kthSymbolBruteForce(n, k));  // Output: 1
    }
}



//One more check it in future... it is with pranav
//Optimal TC->O(NlogK) and SC->O(N)
class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;

        int parent = kthGrammar(N - 1, (int) Math.ceil((double) K / 2));
        boolean isKOdd = K % 2 == 1;

        if (parent == 1) { // Parent is 1
            return isKOdd ? 1 : 0;
        } else { // Parent is 0
            return isKOdd ? 0 : 1;
        }
    }
}

//Once check it in future
public class KthSymbol {
    
    // Recursive method to find the k-th symbol in the n-th row
    public static int kthSymbolRecursive(int n, int k) {
        // Base case: first row is always '0'
        if (n == 1) {
            return 0;
        }
        
        // Find the length of the previous row
        int length = (int) Math.pow(2, n - 1);
        
        // Determine if the kth element is in the first half or second half
        if (k <= length / 2) {
            // The first half is the same as the previous row
            return kthSymbolRecursive(n - 1, k);
        } else {
            // The second half is the "not" of the first half
            return 1 - kthSymbolRecursive(n - 1, k - length / 2);
        }
    }
    
    public static void main(String[] args) {
        int n = 4;
        int k = 5;
        System.out.println(kthSymbolRecursive(n, k));  // Output: 1
    }
}

//THis too even more optimized it seems... do a dry run everything will be

public class KthSymbol {
    
    // Optimized recursive method to find the k-th symbol in the n-th row
    public static int kthSymbolOptimized(int n, int k) {
        // Base case: first row is always '0'
        if (n == 1) {
            return 0;
        }
        
        // Find the middle of the current row
        int mid = (int) Math.pow(2, n - 1) / 2;
        
        // Determine if the kth element is in the first half or second half
        if (k <= mid) {
            // If k is in the first half, it's the same as in the previous row
            return kthSymbolOptimized(n - 1, k);
        } else {
            // If k is in the second half, it's the opposite of the corresponding element in the first half
            return 1 - kthSymbolOptimized(n - 1, k - mid);
        }
    }
    
    public static void main(String[] args) {
        int n = 4;
        int k = 5;
        System.out.println(kthSymbolOptimized(n, k));  // Output: 1
    }
}
