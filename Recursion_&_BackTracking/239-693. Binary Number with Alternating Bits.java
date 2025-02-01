class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int prev=0;
        if(n%2==1) prev=1;

        return check(n>>1,prev);

    }

    public boolean check(int n,int prev){
        int curr=n%2;
        if(curr==prev) return false;
        if(n==0) return true;//if the curr is exhausted
        else return check(n>>1,curr);
    }
    /*i will solve it using the bit-manipulation:
    1-> will save my right-most bit
    2-> will shift my whole number by right by 1 bit
    3-> will ckeck the right-most of this and the previous one
    4-> if they are same i will return false
    5-> if not i will do the same try for other till my n becomes 0 
    after repeated right shifts
    */
    
}