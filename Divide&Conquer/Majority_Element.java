/*
Given an array nums of size n, return the majority element. 
The majority element is the element that appears more than ⌊n / 2⌋ times.

You may assume that the majority element always exists in the array.

Input Format:
--------------
Line-1: An integer n (the size of the array).
Line-2: n space-separated integers representing the elements of the array.

Output Format:
--------------
Line-1: Output a single integer, the majority element.

Constraints:
-------------
1 ≤ n ≤ 5 * 10^4
-10^9 ≤ nums[i] ≤ 10^9


Sample Input-1:
---------------
3
3 2 3

Sample Output-1:
----------------
3

Explanation:
The number 3 appears more than n/2 times, so it is the majority element.

Sample Input-2:
---------------
7
2 2 1 1 1 2 2

Sample Output-2:
----------------
2

Explanation:
The number 2 appears 4 times, which is more than n/2 = 3.5, so it is the majority element.
 */

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(majorityElement(arr,0,arr.length-1));
        sc.close();
    }
    private static int count(int arr[],int low,int high, int target){
        int count  = 0;
        for(int i  = low ; i <= high ; i++){
            count += (arr[i]==target)? 1 : 0;
        }
        return count;
    }
    private static int majorityElement(int arr[] , int low , int high){
        if(low==high){
            return arr[low];
        }
        int mid = (low+high)/2;
        int left = majorityElement(arr, low, mid);
        int right  =  majorityElement(arr, mid+1, high);
        if(left == right ){
            return left;
        }
        int leftCount = count(arr,low,high,left);
        int rightCount = count(arr, low, high, right);
        return (leftCount > rightCount) ? left : right;
    }
}