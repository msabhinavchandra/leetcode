// import Character;
// overall time complexity O(3n)->O(n)
//overall space complexity due to the string builder->O(n)

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();//O(n) SC
        for(char c:s.toCharArray()){//O(n) TC due to for-loop
        //where n is the number of characters of the string.
            if(Character.isLetterOrDigit(c)){//this takes O(1)
                sb.append(Character.toLowerCase(c));//this takes O(1)
            }//sc->O(1)
        }
        //SC->O(n) in worst case.
        String str=sb.toString();//O(1) TC
        //reversing a string takes O(n) TC where n is the length of 
        //the string.   
        //checking wheather the string is equal to another or not will
        //take O(n) time complexity.
        //O(n)+O(n)+O(n)
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}