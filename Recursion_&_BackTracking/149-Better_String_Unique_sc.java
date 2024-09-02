// TC and SC same as normal Subsequence the only diff is i am using a set to store all the subsequences so that i store only unique 
//elements.

class Solution {
        
    //helper method to generate all distinct subsequences using recursion
    public static void generateSubsequences(int index,String inputString,String currentSubsequence,Set<String> subsequences){
        //Base case:if we have considered all characters
        if(index==inputString.length()){
            subsequences.add(currentSubsequence);//for a set of integers you will add an integer
            return;//for a set of strings you will add a string.
        }
        //option 1:Include the current character.
        String includeCharacter=currentSubsequence+inputString.charAt(index);
        generateSubsequences(index+1,inputString,includeCharacter,subsequences);
        //option 2:Exclude the current character.
        generateSubsequences(index+1,inputString,currentSubsequence,subsequences);
    }
    
    public static String betterString(String str1, String str2) {
        // Code here
        Set<String> subsequence1=new HashSet<>();
        Set<String> subsequence2=new HashSet<>();
        //Generate subsequences for str1
        String initialSubsequence="";//initial subsequence is empty
        generateSubsequences(0,str1,initialSubsequence,subsequence1);
        //Generate subsequences for str2
        generateSubsequences(0,str2,initialSubsequence,subsequence2);
        
        //compare the sizes of the sets (number of distinct subsequences)
        if(subsequence1.size()>subsequence2.size())
            return str1;
        else if(subsequence1.size()<subsequence2.size())
            return str2;
        else
            return str1;
    }
}