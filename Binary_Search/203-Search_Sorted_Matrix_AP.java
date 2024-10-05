// You are given an m x n matrix of integers where:
// 	*Each row is sorted in non-decreasing order.
// 	*The first integer of each row is greater than the last integer of the previous row.

// Given an integer target, your task is to determine if the target exists in the matrix. If it does, return the row and column indices where it is found. If it does not exist in the matrix, return -1.

// You must implement the solution with a time complexity of O(log(m * n)) using a binary search approach.

// Input Format:
// -------------
// Line-1: Two integers m and n, representing the number of rows and columns in the matrix.
// Line-2 to m: The next m lines each contain n integers, representing the matrix elements.
// Line m+1: The last line contains the integer k, the target value to search for in the matrix.

// Output Format:
// ---------------
// If the target exists, print the row and column indices of the target in the matrix.
// If the target does not exist, print -1.

// Constraints:
// -------------
// 1 ≤ m, n ≤ 1000
// -10^4 ≤ matrix[i][j], k ≤ 10^4

// Sample Input-1:
// ---------------
// 3 4
// 1 3 5 7
// 10 11 16 20
// 23 30 34 60
// 3

// Sample Output-1:
// ----------------
// 0 1

// Explanation:
// The target 3 is found in row 0 and column 1.


// Sample Input-2:
// ---------------
// 3 4
// 1 3 5 7
// 10 11 16 20
// 23 30 34 60
// 13

// Sample Output-2:
// ----------------
// -1

// Explanation:
// The target 13 does not exist in the matrix, so the output is -1.

import java.util.*;

public class search_sorted_matrix_AP{
    public static int binarySearchEnd(int[][] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int rowSize = arr[0].length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid][rowSize] == target){
                return mid;
            }
            else if(arr[mid][rowSize] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        if(left<arr.length && arr[left][rowSize] >= target){
            return left;
        }
        else{
            return -1;
        }
    }
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int row = binarySearchEnd(matrix,k);
        if(row == -1){
            System.out.println(row);
        }
        else{
            int col = binarySearch(matrix[row],k);
            if(col == -1){
                System.out.println(col);
            }
            else{
                System.out.println(row + " " + binarySearch(matrix[row],k));
            }
        }
        sc.close();
    }
}

//Abhinav's brute force solution
//Time complexity: O(rows*cols) and space complexity: O(1) 
import java.util.*;

public class Solution{
    
    public static void searchInASortedMatrix(int[][] mat,int target){
         // Check if the matrix is empty
         //if no of rows=0, or no of cols=0
        if (mat.length == 0 || mat[0].length == 0) {
            System.out.println(-1);
            return;
        }
        
        int n = mat.length;  
        int m = mat[0].length; 
        
        // Traverse the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == target) {
                    // Return true if target is found
                    System.out.println(i+" "+j); 
                    return;
                }
            }
        }
        // Return false if target is not found
        System.out.println(-1);
        return; 
    }
}

//Abhinav's Better solution
// TC->O(rows+log(cols)) and SC->O(1)

public static void searchInASortedMatrix(int[][] mat,int target){
         // Check if the matrix is empty
         //if no of rows=0, or no of cols=0
        if (mat.length == 0 || mat[0].length == 0) {
            System.out.println(-1);
            return;
        }
        
        int n = mat.length;  
        int m = mat[0].length; 
        
        // Traverse the matrix
        for (int i = 0; i < n; i++) {
            
            if(mat[i][0]<=target && target<=mat[i][m-1]){
                int indC=BS(mat[i],target);
                if(indC!=-1){ 
                    System.out.println(i+" "+indC);
                    return;
                }
                else{
                    System.out.println(-1);
                    return;
                }
            }
            
        }
        // Return false if target is not found
        System.out.println(-1);
        return; 
    }

//Abhinav's Optimal tapadia sir
//Time complexity: O(log(rows)+log(cols)) and space complexity: O(1)
import java.util.*;

public class Solution{
    
    public static int BS(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target) return mid;//return the index
            else if(arr[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
    
    public static int BSEnd(int[][] mat,int target){//returns row of 
    //desired element.
        int lastIndex=mat[0].length-1;
        int low=0;int high=mat.length-1;//i am find for no of rows
        while(low<=high){
            int mid=(low+high)/2;
            if(mat[mid][lastIndex]==target) return mid;//if found that row.
            else if(mat[mid][lastIndex]>target) high=mid-1;
            else low=mid+1;
        }
        //if not found
        //low will settle in a place where that element is just greater than
        //target element.
        if(low<mat.length)
            return low;
            
        return -1;
    }
    
    public static void searchInASortedMatrix(int[][] mat,int target){
         // Check if the matrix is empty
         //if no of rows=0, or no of cols=0
        if (mat.length == 0 || mat[0].length == 0) {
            System.out.println(-1);
            return;
        }
        
        int row=BSEnd(mat,target);
        if(row!=-1) {
        int col=BS(mat[row],target);
        if(col!=-1){
            System.out.println(row+" "+col);
            return;
        }
        }
        System.out.println(-1);

    }
}

 //Abhinav's Optimal Striver 

//  Time complexity: O(log(rows*cols)) and space complexity: O(1)

import java.util.*;

public class Solution{    
    public static void searchInASortedMatrix(int[][] mat,int target){
         // Check if the matrix is empty
         //if no of rows=0, or no of cols=0
        if (mat.length == 0 || mat[0].length == 0) {
            System.out.println(-1);
            return;
        }
        int noOfRows=mat.length;
        int noOfCols=mat[0].length;
        
        int low=0;
        int high=noOfRows*noOfCols-1;
        
        while(low<=high){
            
            int mid=(low+high)/2;
            
            //converting into matrices co-ordinates.
            int row=mid/noOfCols;
            int col=mid%noOfCols;
            
            if(mat[row][col]==target){
                System.out.println(row+" "+col);
                return;
            }
            else if(mat[row][col]>target) high=mid-1;
            else low=mid+1;
            
        }//end of while
        
        System.out.println(-1);

    }
}