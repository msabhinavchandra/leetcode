
// 2sum java brute
// tc->O(n^2)
// sc->O(1)

//brute force
public class Solution {
    public static int[] twoSum(int arr[], int n,int target) {
        // Write your code here.
        // int[] result=new int[2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};

    }
}


// better approach
// using hashmap
// tc->O(n) for numbeer of elements in the array
// sc->O(n) for the elements which are stored in the hashmap.

import java.util.*;
public class Solution {
    public static String read(int n, int []book, int target){
        // Write your code here.
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=book[i];
            int moreNeeded=target-num;
            if(mpp.containsKey(moreNeeded)){
                return "YES";
            }
            mpp.put(num, i);
        }
        return "NO";
    }
}

//the optimal approach with tc->O(n)+O(n*log(n))
//and space complexity->O(1)

import java.util.*;
public class Solution {
    public static String read(int n, int []book, int target){
        // Write your code here.
        int[] nbook=Arrays.copyOf(book,book.length);
        Arrays.sort(nbook);
        int left=0;
        int right=book.length-1;
        int sum=0;
        while(left<right){
            sum=nbook[left]+nbook[right];
            if(sum==target){
                return "YES";
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
        return "NO";
    }
}


