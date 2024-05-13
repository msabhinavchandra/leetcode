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

//made it in-place with O(n) tc and O(1) sc as we are doing it in in-place.

class Solution {

    private boolean isAlphanumeric(char ch){
        return ((ch>='A' && ch<='Z')||(ch>='a' && ch<='z')||(ch>='0' && ch<='9'));
    }

    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right)
        {
            while(left<right && !isAlphanumeric(s.charAt(left))){
                left++;
            }
            while(left<right && !isAlphanumeric(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}