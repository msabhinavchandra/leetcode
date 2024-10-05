// You are given a positive integer n, and your task is to determine whether it is a perfect square. 
// A number is considered a perfect square if there exists an integer x such that x * x = n.

// You must solve this problem in O(log(n)) time complexity using the binary search algorithm. 

// NOTE:You are not allowed to use any built-in library functions to check if the number is a perfect square.

// Input Format:
// -------------
// Line-1: A single integer n.

// Output Format:
// ---------------
// Line-1: Print true if the number n is a perfect square, otherwise print false.


// Constraints:
// -------------
// The integer n will always be a positive integer (1 ≤ n ≤ 10^9).
// The solution must have a time complexity of O(log(n)).


// Sample Input-1:
// ---------------
// 25

// Sample Output-1:
// ----------------
// true

// Explanation:
// 5 * 5 = 25, so 25 is a perfect square.


// Sample Input-2:
// ---------------
// 9

// Sample Output-2:
// ----------------
// true

// Explanation:
// 3 * 3 = 9, so 9 is a perfect square.


// Sample Input-3:
// ---------------
// 8

// Sample Output-3:
// ----------------
// false

// Explanation:
// There is no integer x such that x * x = 8.


// Sample Input-4:
// ---------------
// 125

// Sample Output-4:
// ----------------
// false

// Explanation:
// There is no integer x such that x * x = 125.

import java.util.*;

public class perfect_square_AP{
    public static boolean binarySearch(long n){
        long left = 0;
        long right = n;
        while(left<=right){
            long mid = (left+right)/2;
            long square = mid*mid;
            if(square == n){
                return true;
            }
            else if(square<n){
                left = mid + 1;
            }
            else{
                right = mid - 1 ;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(binarySearch(n));
        sc.close();
    }
}

// Abhinav's brute

/*
Time complexity->O(n)
and Space complexity->O(1)
*/
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(isPerfectSquare(n));
    }
    public static boolean isPerfectSquare(int n){
        if(n==0) return true;
        for(int i=0;i<=n;i++){
            if(i*i==n) return true;
            else if(i*i>n) return false;
        }
        return false;
    }
}

// Abhinav's optimized

/*
Time complexity->O(n)
and Space complexity->O(1)
*/
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextInt();
        System.out.println(isPerfectSquare(n));
    }
    public static boolean isPerfectSquare(long n){
        if(n==0) return true;
        long low=1;long high=n;
        while(low<=high){
            long mid=(low+high)/2;
            if(mid*mid==n) return true;
            else if(mid*mid>n) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}