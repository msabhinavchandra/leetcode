/*
Two brothers are playing a game based on two sorted lists of numerical elements and a target sum.

The first brother provides:
-> Two sorted lists of integers.
-> A target sum.

The second brother's task is to find and return the closest pair of elements (one from each list) 
whose sum is closest to the given target.

Rules:
------
Each pair must consist of one element from each list.
If multiple pairs have the same closest sum, return any one valid pair.
The input lists are already sorted in ascending order.
The result must be printed as a comma-separated pair.

Input Format:
-------------
Line 1: An integer N1, representing the size of the first list.
Line 2: N1 space-separated integers, representing elements of the first sorted list.
Line 3: An integer N2, representing the size of the second list.
Line 4: N2 space-separated integers, representing elements of the second sorted list.
Line 5: An integer X, representing the target sum.

Output Format:
--------------
Line-1: Print a comma-separated pair (a, b), where a is from list_1 and b is from list_2, such that their sum is closest to the target sum.

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32

Sample Output-1:
----------------
1,30

Explanation:
------------
The closest pair to 32 is (1,30) → 1 + 30 = 31, which is the closest sum to 32.

Sample Input-2:
---------------
3
2 4 6
4
5 7 11 13
15

Sample Output-2:
----------------
2,13

Explanation:
------------
The closest pair to 15 is (2,13) → 2 + 13 = 15, which is an exact match.
 */

//brute force tc-> O(N1 * N2) (Iterating through both lists entirely) sc-> O(1) (Only a few extra variables are used)

import java.util.*;

public class ClosestPair{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int l1=sc.nextInt();
        int[] arr1=new int[l1];
        for(int i=0;i<l1;i++) arr1[i]=sc.nextInt();
        int l2=sc.nextInt();
        int[] arr2=new int[l2];
        for(int i=0;i<l2;i++) arr2[i]=sc.nextInt();
        int target=sc.nextInt();
        int[] result=new int[2];
        findPair(l1,arr1,l2,arr2,target,result);
        
    }
    
    public static void findPair(int l1,int[] arr1,int l2,int[] arr2,int target,int[] result){
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                int sum=arr1[i]+arr2[j];
                int diff=Math.abs(sum-target);
                if(diff<minDiff){
                    minDiff=diff;
                    result[0]=arr1[i];
                    result[1]=arr2[j];
                }
                if(sum==target){
                System.out.println(result[0]+","+result[1]);
                return;
                }
            }
        }
        System.out.println(result[0]+","+result[1]);
        
        
    }
}

//better approach tc->O(n1*logn2) sc->O(1);

import java.util.*;

public class ClosestPair{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int l1=sc.nextInt();
        int[] arr1=new int[l1];
        for(int i=0;i<l1;i++) arr1[i]=sc.nextInt();
        int l2=sc.nextInt();
        int[] arr2=new int[l2];
        for(int i=0;i<l2;i++) arr2[i]=sc.nextInt();
        int target=sc.nextInt();
        int[] result=new int[2];
        findPair(l1,arr1,l2,arr2,target,result);
        
    }
    
    public static void findPair(int l1,int[] arr1,int l2,int[] arr2,int target,int[] result){
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<l1;i++){
            
            int localTarget=target-arr1[i];
            
            int secondElement=findSecond(localTarget,arr2,l2);
            
            int sum=arr1[i]+secondElement;
            
            int diff=Math.abs(sum-target);
            
            if(diff<minDiff){
                minDiff=diff;
                result[0]=arr1[i];
                result[1]=secondElement;
            }if(sum==target){
                result[0]=arr1[i];
                result[1]=secondElement;
                System.out.println(result[0]+","+result[1]);
                return;
            }
            
            
        }
        System.out.println(result[0]+","+result[1]);
        
        
    }
    public static int findSecond(int target,int[] arr2,int l2){
        
        int minDiff=Integer.MAX_VALUE;
        int closest=arr2[0];
        int low=0;int high=l2-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            
            int diff=Math.abs(arr2[mid]-target);
            
            if(diff<minDiff){
                minDiff=diff;
                closest=arr2[mid];
            }
            
            if(arr2[mid]==target) return arr2[mid];
            
            else if(arr2[mid]>target) high=mid-1;
            
            else if(arr2[mid]<target) low=mid+1;
            
        }return closest;
        
    }
}

//optimal tc->O(n1+n2) and sc->O(1)

import java.util.*;

public class ClosestPair {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int l1 = sc.nextInt();
    int[] arr1 = new int[l1];
    for (int i = 0; i < l1; i++) arr1[i] = sc.nextInt();
    int l2 = sc.nextInt();
    int[] arr2 = new int[l2];
    for (int i = 0; i < l2; i++) arr2[i] = sc.nextInt();
    int target = sc.nextInt();

    int[] result = new int[2];

    findPair(l1, arr1, l2, arr2, target, result);

    System.out.println(result[0] + "," + result[1]);
  }
  public static void findPair(int l1, int[] arr1, int l2, int[] arr2, int target, int[] result) {
    int absdiff = Integer.MAX_VALUE; 
    int first = 0; // for l1 
    int last = l2 - 1; // for l2
    // System.out.println("Inside the function ");
    int diff = 0;
    while (first < l1 && last >= 0) {
      // do the sum
      int sum = arr1[first] + arr2[last];
      diff = Math.abs(sum - target);
      if (diff < absdiff) {
        absdiff = diff;
        result[0] = arr1[first];
        result[1] = arr2[last];
      }
      if (sum == target) {
        return; // best case scenario
      } else if (sum > target) {
        last--;

      } else if (sum < target) {
        first++;
      }
    }
  }
}