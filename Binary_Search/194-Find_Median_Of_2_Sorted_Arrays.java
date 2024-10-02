/*
In a school, the 5th standard class is divided into two sections, Rose and Lotus. 
The teacher has recorded the scores of students from both sections in their Mathematics exam. 
The marks for both sections are provided in ascending order. 
The task is to compute the median of the combined marks of both sections.

You are given the number of students in each section and their respective marks. Your task is to find the median of the combined sorted marks from both sections.

The overall run-time complexity of your solution should be O(log(min(m + n))).

Input Format:
-------------
Line-1: An integer m, representing the number of students in section Rose.
Line-2: An integer n, representing the number of students in section Lotus.
Line-3: m space-separated integers, representing the scores of students in section Rose, sorted in ascending order.
Line-4: n space-separated integers, representing the scores of students in section Lotus, sorted in ascending order.

Output Format:
--------------
Line-1: Print a single float representing the median of the combined sorted marks from both sections.

Constraints:
------------
0 ≤ m, n ≤ 1000
The marks of students are in the range 0 ≤ marks ≤ 100.
Time complexity: O(log(min(m + n)))
Space complexity: O(1)

Sample Input-1:
---------------
4
6
32 45 70 95
40 50 59 67 73 84

Sample Output-1:
----------------
63.0

Explanation: The combined sorted marks are: [32, 40, 45, 50, 59, 67, 70, 73, 84, 95].
The median is 63.0.


Sample Input-2:
---------------
5
6
10 20 30 40 50
35 44 60 70 80 90

Sample Output-2:
----------------
44.0

Explanation: The combined sorted marks are: [10, 20, 30, 35, 40, 44, 50, 60, 70, 80, 90].
The median is 44.0.

Sample Input-3:
---------------
4
6
3 6 8 10
14 17 20 33 44 55

Sample Output-3:
-----------------
15.5

Explanation: The combined sorted marks are: [3, 6, 8, 10, 14, 17, 20, 33, 44, 55].
The median is (10 + 14) / 2 = 15.5.


Sample Input-4:
----------------
3
5
50 60 80
7 10 20 30 40

Sample Output-4:
----------------
35.0

Explanation: The combined sorted marks are: [7, 10, 20, 30, 40, 50, 60, 80].
The median is 35.0. */

//Striver 100/100.

import java.util.*;

public class SchoolMedian {
    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        // If n1 is bigger, swap the arrays
        if (n1 > n2) return median(b, a);

        int n = n1 + n2; // Total length
        int left = (n1 + n2 + 1) / 2; // Length of left half
        // Apply binary search
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            // Calculate l1, l2, r1 and r2
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                // Found the correct partition
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0; // Dummy statement
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of students in each section
        int m = sc.nextInt(); // Number of students in section Rose
        int n = sc.nextInt(); // Number of students in section Lotus
        
        // Input scores for each section
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        
        // Calculate and print the median
        System.out.printf("%.1f\n", median(a, b));
    }
}
