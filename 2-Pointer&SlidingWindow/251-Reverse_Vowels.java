// brute force
/*Time Complexity: 
O(N) (for extracting vowels) + O(N) (for reversing) + O(N) (for replacing) = O(N)
Space Complexity: O(N) (since we store vowels separately) */
import java.util.*;

public class ReverseVowels{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        reverseVowels(s);
    }
    public static void reverseVowels(String s){
        StringBuilder sb=new StringBuilder(s);
        int left=0;int right=s.length()-1;
        List<Character> ls=new ArrayList<>();
        //added all the vowels into a list
        
        for(char c:s.toCharArray()){
            if(isVowel(c)){
                ls.add(c);
            }
        }// 1 pass O(n) for tc
        
        //reverse the vowels
        Collections.reverse(ls);
        int j=0;
        for(int i=0;i<s.length();i++){
            if(isVowel(sb.charAt(i))){
                sb.setCharAt(i,ls.get(j++));
            }
        }
    
        System.out.println(sb.toString());
        
    }
    
    public static boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
        // !=1 vowel and ==1 not a vowel
        //  true         false
    }
    
}

//Better using stack
// Time Complexity: O(N) (two passes)
// Space Complexity: O(V) (where V is the number of vowels, worst-case O(N))

import java.util.*;

public class ReverseVowels{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        reverseVowels(s);
    }
    public static void reverseVowels(String s){
        StringBuilder sb=new StringBuilder(s);
        int left=0;int right=s.length()-1;
        Stack<Character> stk=new Stack<>();
        
        for(char c:s.toCharArray()){
            if(isVowel(c)){
                stk.push(c);
            }
        }// 1 pass O(n) for tc
        
        //reverse the vowels
        for(int i=0;i<s.length();i++){
            if(isVowel(sb.charAt(i))){
                char c=stk.pop();
                sb.setCharAt(i,c);
            }
        }// one pass to replace the elements
    
        System.out.println(sb.toString());
        
    }
    
    public static boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
        // !=1 vowel and ==1 not a vowel
        //  true         false
    }
    
}



// optimal 
// space O(n) because java Strings are immutable
// time O(n) while loop 1 pass.
import java.util.*;

public class ReverseVowels{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Set<Character> set=new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        reverseVowels(s,set);
    }
    public static void reverseVowels(String s,Set<Character> set){
        StringBuilder sb=new StringBuilder(s);
        int left=0;int right=s.length()-1;
        while(left<=right){
            while(!set.contains(Character.toLowerCase(s.charAt(left)))){
                left++;
            }
            while(!set.contains(Character.toLowerCase(s.charAt(right)))){
                right--;
            }
            if(left>right) break;
            char temp=sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,temp);
            left++;right--;
        }
        
        System.out.println(sb.toString());
        
    }
}