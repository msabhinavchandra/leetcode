/*
You are given an unsorted array of integers. 
Your task is to implement the QuickSort algorithm to sort the array in ascending order.

QuickSort is a divide-and-conquer algorithm that:
	-Picks an element as a pivot and partitions the given array around the pivot.
	-Recursively applies the same process to the subarrays on the left and right of the pivot.
	-You need to implement QuickSort using the Lomuto partition scheme (where the pivot is chosen as the last element of the array).

Input Format:
-------------
Line-1: An integer n (the size of the array).
Line-2: n space-separated integers representing the elements of the array.

Output Format:
---------------
Line-1: Output the sorted array in a single line, with each element separated by a space.

Constraints:
------------
1 ≤ n ≤ 10^5
-10^9 ≤ arr[i] ≤ 10^9


Sample Input-1:
---------------
6
10 7 8 9 1 5

Sample Output-1:
----------------
1 5 7 8 9 10


Sample Input-2:
---------------
5
3 2 1 5 4

Sample Output-2:
----------------
1 2 3 4 5
*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
}
        
        public static void quickSort(int[] arr,int low,int high){
            if(low>=high) return;
            int pivot=partitionLow(arr,low,high);
            //quickSort(arr,low,pivot);
            //Because pivot itself is correctly positioned
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
        public static int partitionLow(int[] arr,int low,int high){
            int assumedPivot=arr[low];
            //int assumedPivot=low;
            int k=high;
            for(int i=high;i>low;i--){
                if(arr[i]>assumedPivot){
                    swap(arr,i,k);
                    k--;
                }
            }
            swap(arr,low,k);
            int newPivot=k;
            return newPivot;
        }
        public static void swap(int[] arr, int ptr1,int ptr2){
            int temp=arr[ptr2];
            arr[ptr2]=arr[ptr1];
            arr[ptr1]=temp;
        }
    }
