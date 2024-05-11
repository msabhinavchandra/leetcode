//TC->O(n)
//SC->O(1)

class Solution {
    public int lengthOfLastWord(String s) {
        int rev=s.length()-1;
        int length=0;
        while(rev>=0 && s.charAt(rev) == ' '){
            rev-=1;
        }
        while(rev>=0 && s.charAt(rev)!= ' '){
            length+=1;
            rev-=1;
        }
        return length;
    }
}