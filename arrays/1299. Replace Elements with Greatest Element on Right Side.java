//brute force TC->O(n^2)
//SC->O(n)

class Solution {
    public int[] replaceElements(int[] arr) {
        int[] result=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int max=-1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>max){
                    max=arr[j];
                }
            }
            result[i]=max;
        }
        return result;
    }
}

//optimal TC->O(n) and SC->O(1) i am doing this in-place.

class Solution {
    public int[] replaceElements(int[] arr) {
        int rightMax=-1;
        for(int i=arr.length-1;i>=0;i--){
            int newMax=Math.max(rightMax,arr[i]);
            arr[i]=rightMax;
            rightMax=newMax;
        }
        return arr;
    }
}