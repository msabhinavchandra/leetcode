//Brute Force
//TC->O(n^3) and SC->O(1)
class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int n=A.length;
        int len=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                long s=0;
                for(int k=i;k<=j;k++){
                    s+=A[k];
                }
                if(s==K){
                    len=Math.max(len,j-i+1);
                }
            }
        }
        return len;
        
    }
    
}

//Better
class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int n=A.length;
        int len=0;
        for(int i=0;i<n;i++){
            long s=0;
            for(int j=i;j<n;j++){ 
                s+=A[j];
                
                if(s==K){
                    len=Math.max(len,j-i+1);
                }
            }
        }
        return len;    
    }
    
}

//Hashing
