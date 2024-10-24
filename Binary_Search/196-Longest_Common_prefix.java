/*
Given an array of strings strs, find the longest common prefix among all strings.

If there is no common prefix, return an empty string "".

NOTE: Solve Using Binary Search

Input Format:
-------------
Line-1: An integer n, the number of strings in the array.
Line-2: The next n lines contain n space-separated strings representing the elements of the string array strs.

Output Format:
--------------
Line-1: Print a single string, which is the longest common prefix among all the strings. If no common prefix exists, print an empty string.

Constraints:
------------
1 ≤ n ≤ 200
0 ≤ strs[i].length ≤ 200
strs[i] consists of only lowercase English letters.


Sample Input-1:
---------------
3
flower flow flight

Sample Output-1:
----------------
fl

Explanation:
The longest common prefix of the strings flower, flow, and flight is "fl".

Sample Input-2:
---------------
3
dog racecar car

Sample Output-2:
----------------
""

Explanation:
There is no common prefix among the input strings.
*/

import java.util.Scanner;

public class Solution {
    public String longestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        
        // Find the minimum length of the strings in the array
        for (String str : arr) {
            minLen = Math.min(minLen, str.length());
        }
        
        int low = 1;
        int high = minLen;
        
        // Binary search for the longest common prefix
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(arr, mid)) {
                low = mid + 1; // Look for a longer prefix
            } else {
                high = mid - 1; // Look for a shorter prefix
            }
        }

        // The longest common prefix length
        int commonPrefixLength = (low + high) / 2;
        return commonPrefixLength == 0 ? "" : arr[0].substring(0, commonPrefixLength);
    }

    private static boolean isCommonPrefix(String[] arr, int length) {
        String prefix = arr[0].substring(0, length);
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].startsWith(prefix)) return false; // Check if current string starts with the prefix
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of strings
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        
        String[] strs = new String[n];
        
        // Input the strings
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        
        // Create Solution object and find the longest common prefix
        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(strs);
        
        // Print the result
        System.out.println(result);
    }
}


//Abhinav's

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        StringBuilder sb=new StringBuilder();
        // Find the minimum length of the strings in the array
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 0;
        int high = minLen-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid+1)) {
                sb.append(strs[0].substring(low,mid+1));
                low = mid + 1; // Look for a longer prefix
            } else {
                high = mid - 1; // Look for a shorter prefix
            }
        }

        return sb.toString().length()==0?"":sb.toString();

    }

    private static boolean isCommonPrefix(String[] arr, int length) {
        String prefix = arr[0].substring(0, length);
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].startsWith(prefix)) return false;
             // Check if current string starts with the prefix
        }
        return true;
    }

}

//Small followup

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        StringBuilder sb=new StringBuilder();
        String small="";
        // Find the minimum length of the strings in the array
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
            if(minLen==str.length())  small=str;
        }
        int low = 0;
        int high = minLen-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid+1)) {
                sb.append(small.substring(low,mid+1));
                low = mid + 1; // Look for a longer prefix
            } else {
                high = mid - 1; // Look for a shorter prefix
            }
        }

        return sb.toString().length()==0?"":sb.toString();

    }

    private static boolean isCommonPrefix(String[] arr, int length) {
        String prefix = arr[0].substring(0, length);
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].startsWith(prefix)) return false;
             // Check if current string starts with the prefix
        }
        return true;
    }

}