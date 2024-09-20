/*
In your English exam, there is a question that asks you to check whether a given string is a palindrome. Using your programming skills, you need to write a program that prints True if the string is the same when reversed, and False otherwise.

A palindrome is a word, phrase, or sequence that reads the same backward as forward.

Input Format:
--------------
Line-1: A single string str, which may contain lowercase letters.

Output Format:
---------------
Line-1: Print True if the string is a palindrome, otherwise print False.

Constraints:
------------
The string can contain up to 1000 characters.


Sample Input-1: 
---------------
liril

Sample Output-1: 
----------------
True

Sample Input-2: 
---------------
genesis

Sample Output-2: 
----------------
False */

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        if(palindromeOrNot(str,0,str.length()-1)){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
    public static boolean palindromeOrNot(String str,int left,int right){
        if(left>=right) return true;
        if(str.charAt(left)!=str.charAt(right)) return false;
        return palindromeOrNot(str,left+1,right-1);
    }
}