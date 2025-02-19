/*You are given three sorted integer arrays A[], B[], and C[], and an integer target.

Your task is to find one element from each array (A[i], B[j], and C[k]) such that the sum of these three elements is equal to target.

If there is no exact match, return the triplet with the minimum absolute difference to the target.

Input Format:
-------------
Line 1: An integer N, the size of the first array.
Line 2: N space-separated integers representing elements of array A.
Line 3: An integer M, the size of the second array.
Line 4: M space-separated integers representing elements of array B.
Line 5: An integer P, the size of the third array.
Line 6: P space-separated integers representing elements of array C.
Line 7: An integer target, the required sum.

Output Format:
--------------
Line-1: Print the triplet (A[i], B[j], C[k]) that either matches the target or has the closest sum to the target.

Constraints:
------------
Time Complexity: O(N + M + P)
Space Complexity: O(1)

Sample Input-1:
---------------
4
5 10 20 30
4
1 3 7 10
4
2 5 8 12
25

Sample Output-1:
----------------
10 3 12

Explanation:
-------------
The sum 10 + 7 + 8 = 25, which exactly matches target.


Sample Input-2:
---------------
3
1 5 10
3
3 6 9
3
4 7 8
30

Sample Output-2:
----------------
10 9 8

Explanation:
------------
The sum 10 + 9 + 8 = 27, which is the closest sum to 30 (minimum absolute difference |30 - 27| = 3). */

import java.util.*;

public class ClosestTripletSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        int[] arr1 = new int[s1];
        for (int i = 0; i < s1; i++) {
            arr1[i] = sc.nextInt();
        }
        int s2 = sc.nextInt();
        int[] arr2 = new int[s2];
        for (int i = 0; i < s2; i++) {
            arr2[i] = sc.nextInt();
        }
        int s3 = sc.nextInt();
        int[] arr3 = new int[s3];
        for (int i = 0; i < s3; i++) {
            arr3[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        getTriplet(arr1, arr2, arr3, s1, s2, s3, target);
    }
    public static void getTriplet(int[] arr1, int[] arr2, int[] arr3, int s1,
        int s2, int s3, int target) {
        int[] result = new int[3];
        int[] temp = new int[2];
        int absDiff = Integer.MAX_VALUE;
        for (int i = 0; i < s1; i++) {
            int newT = target - arr1[i];
            int sum = findPair(s2, arr2, s3, arr3, newT, temp);
            int totalsum = sum + arr1[i];
            int diff = Math.abs(totalsum - target);
            if (diff < absDiff) {
                absDiff = diff;
                result[0] = arr1[i];
                result[1] = temp[0];
                result[2] = temp[1];
            }
        }
        for (int j = 0; j < 3; j++) {
            System.out.print(result[j] + " ");
        }
    }
    public static int findPair(
        int l1, int[] arr1, int l2, int[] arr2, int target, int[] result) {
        int totalsum = 0;
        int absdiff = Integer.MAX_VALUE;
        int first = 0; // for l1
        int last = l2 - 1; // for l2
        // System.out.println("Inside the function ");
        int diff = 0;
        while (first < l1 && last >= 0)

        {
            // do the sum
            int sum = arr1[first] + arr2[last];
            diff = Math.abs(sum - target);
            if (diff < absdiff)

            {
                absdiff = diff;
                result[0] = arr1[first];
                result[1] = arr2[last];
                totalsum = arr1[first] + arr2[last];
            }
            if (sum == target)

            {
                return sum; // best case scenario

            } else if (sum > target)

            {
                last--;

            } else if (sum < target)

            {
                first++;
            }
        }

        return totalsum;
    }
}