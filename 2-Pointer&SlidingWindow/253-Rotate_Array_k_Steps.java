// Brute force

// time complexity Total: O(N * K) (very inefficient for large values of K)

// space complexity : O(1)

// manually rotating the array, every element one by one, one at a time.

import java.util.*;

public class RotateArray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        rotateArray(arr,size,k%size);
    }
    
    
    public static void rotateArray(int[] arr,int size,int k){
        // int len=arr.length-1;

        for(int i=0;i<k;i++){
            
            int temp=arr[size-1];
            
            // at every position from N-1 to 1 replace them with their immediate previous elements
            // like for i replace it with i-1
            for(int j=size-1;j>=1;j--){
                arr[j]=arr[j-1];
            }
            arr[0]=temp;
            
        }
        
        
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    
    }
}

// better
// time complexity O(n) one pass and space complexity O(n) array new array
import java.util.*;

public class RotateArray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        rotateArray(arr,size,k%size);
    }
    
    
    public static void rotateArray(int[] arr,int size,int k){
        
        int[] result=new int[size];
        // Create a new array with the help of circular increment add all the elements into the 
        // new array
        for(int i=0;i<size;i++){
            int modifiedPos=(i+k)%size;
            result[modifiedPos]=arr[i];
        }


        for(int i=0;i<size;i++){
            System.out.print(result[i]+" ");
        }
    
    }
}

//optimal approach
// time complexity O(n) one pass and space complexity O(1) no extra space.

import java.util.*;

public class RotateArray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        rotateArray(arr,size,k%size);
    }
    
    
    public static void rotateArray(int[] arr,int size,int k){
        int left=0;int right=arr.length-1;
        //rotate array
        while(left<=right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
        left++;right--;
        }
        //rotate the first k elements
        left=0;right=k-1;
        while(left<=right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
        left++;right--;
        }
        left=k;right=size-1;
        while(left<=right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
        left++;right--;
        }
        
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    
    }
}