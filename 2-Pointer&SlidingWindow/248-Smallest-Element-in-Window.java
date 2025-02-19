/* 
You are given an array consisting of N integers, and an integer, K. 
Your task is to determine the minimum element in subarrays of size K.

Sample Input1:
--------------
5
10 12 14 11 15

3

Sample Output1:
---------------
10 11 11

Sample Input2:
--------------
5
5 2 1 1 1
4

Sample Output2:
---------------
1 1

 */
/* ***U can do the same for finding the largest element also*** */
//brute force
// time complexity-> O(n*k) and space complexity-> O(1)
import java.util.*;

public class SmallestElement {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = sc.nextInt();
    }
    int wsize = sc.nextInt();
    findSmallestElements(size, arr, wsize);
  }

  public static void findSmallestElements(int size, int[] arr, int k) {
    List<Integer> temp = new ArrayList<>();
    // add the first element
    if (arr.length == 1) {
      System.out.println(arr[0]);
      return;
    }
    for (int i = 0; i < size - k + 1; i++) {
      int min = Integer.MAX_VALUE;
      // and now do it for all the elements starting from the first
      for (int j = i; j < i + k; j++) {
        min = Math.min(min, arr[j]);
      }
      System.out.println(min + " ");
    }
  }
}



// 2 approaches

// using the deque
// time complexity -> O(n) worst case O(n*k) 
// space complexity -> O(k) for using the deque

import java.util.*;

public class SmallestElement{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int wsize=sc.nextInt();
        findSmallestElements(size,arr,wsize);
        
    }
    
    public static void findSmallestElements(int size,int[] arr,int wsize){
        Deque<Integer> deque=new LinkedList<>();
        //add the first element
        deque.offerLast(0);
        if(arr.length==1){
            System.out.println(arr[0]);
            return;
        }
        
        //and now do it for all the elements starting from the first
        for(int i=1;i<size;i++){
         
         //remove all those elements from the deque which are out of bounds for a particular
         //window which we are checking
         if(!deque.isEmpty() && deque.peekFirst()<i-wsize+1){
             //remove all those elements from the queue which are out of bounds for that
             //particular window
             deque.pollFirst();
         }
         //remove all those elements from the deque from the back, which are 
         //greater than the current, and we will add the current as we need the smallest
         //element of all
         while(!deque.isEmpty() && arr[deque.peekLast()]>arr[i]){
             deque.pollLast();
         }
         //add that curr element which is the smallest element
         deque.offerLast(i);
         
         //results will start printing from k-1
         if(i>=wsize-1){
             System.out.print(arr[deque.peekFirst()]+" ");
         }
        
        }
    }
    
}

//using simple sliding window
// time complexity O(n*k) and space complexity is O(k)
import java.util.*;

public class SmallestElement{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int wsize=sc.nextInt();
        findSmallestElements(size,arr,wsize);
    }
    
    public static void findSmallestElements(int size,int[] arr,int k){
        List<Integer> temp=new ArrayList<>();
        //add the first element
        if(arr.length==1){
            System.out.println(arr[0]);
            return;
        }
        for(int i=0;i<k;i++) temp.add(arr[i]);
        
        System.out.print(Collections.min(temp)+" ");
        
        //and now do it for all the elements starting from the first
        for(int i=k;i<size;i++){
        
        temp.remove(Integer.valueOf(arr[i-k]));
        //Even putting temp.remove(0) works fine here.
        temp.add(arr[i]);
        
        System.out.print(Collections.min(temp)+" ");
         
        
        }
    }
    
}