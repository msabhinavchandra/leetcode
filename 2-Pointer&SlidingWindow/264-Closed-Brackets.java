import java.util.*;

public class WellFormedBrackets {
    public static int minInsertions(String B) {
        int openCount = 0;  // Track open brackets '['
        int insertions = 0; // Minimum insertions needed
        int i = 0;

        while (i < B.length()) {
            char ch = B.charAt(i);

            if (ch == '[') {
                openCount++; // Increase open brackets count
            } else { // ch == ']'
                if (i + 1 < B.length() && B.charAt(i + 1) == ']') {
                    // Found a pair ']]', we can use it
                    if (openCount > 0) {
                        openCount--; // Use one open bracket
                    } else {
                        insertions++; // Need an extra '[' before ']]'
                    }
                    i++; // Skip the next ']'
                } else {
                    // Found a single ']', we need another ']' to complete the group
                    insertions++; // Insert an extra ']'
                    if (openCount > 0) {
                        openCount--; // Use one open bracket
                    } else {
                        insertions++; // Need an extra '[' before ']]'
                    }
                }
            }
            i++;
        }

        // If there are any remaining unpaired '[' brackets, each needs ']]'
        insertions += 2 * openCount;
        return insertions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String B = sc.next();
        System.out.println(minInsertions(B));
        sc.close();
    }
}

import java.util.*;

public class ClosedBrackets{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String br
    }
}