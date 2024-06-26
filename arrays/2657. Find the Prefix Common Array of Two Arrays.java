
// brute force.
// TC->O(n^2)
//SC->O(n)

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] c=new int[A.length];
        for(int i=0;i<A.length;i++){
            boolean found=false;
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]){
                    found=true;
                }
                if(found && j>=i){
                    c[j]++;
                }
            }
        }
        return c;
    }
}

//optimal 
//TC->O(n)
//SC->O(n)

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] c=new int[A.length];
        int[] freq=new int[A.length+1];
        int count=0;
        for(int i=0;i<A.length;i++){
            freq[A[i]]++;
            if(freq[A[i]]==2) count++;
            freq[B[i]]++;
            if(freq[B[i]]==2) count++;
            c[i]=count;
        }
        return c;
    }
}
