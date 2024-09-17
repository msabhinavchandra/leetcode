/* 
Given a string s, write a recursive function to reverse the string. 
You are not allowed to use any built-in string manipulation functions. 

Constraints:
------------
The input string s consists of printable ASCII characters (including spaces, punctuation, etc.).
The length of the string s is between 1 and 1000.
You must reverse the string recursively.

Input Format:
--------------
Line-1: A single string s, containing characters that need to be reversed.

Output Format:
--------------
Line-1: A single string, representing the reversed input string.


Sample Input-1: 
---------------
hello

Sample Output-1:
-----------------
olleh

Sample Input-2:
----------------
12345

Sample Output-2: 
----------------
54321
*/

//Pranay's

import java.util.*;
public class Solution{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr=s.split("");
        reverse(arr,0,s.length()-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
    
    public static void reverse(String[] s,int i,int j){
        if(i<=j){
            String t=s[j];
            s[j]=s[i];
            s[i]=t;
            reverse(s,i+1,j-1);
        }
    }
}

//Abhinav's

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        if(str.equals("")){ System.out.println("");return;}
        char[] tempCharArray=str.toCharArray();
        reverseString(tempCharArray,0,str.length()-1);
        System.out.println(new String(tempCharArray));
    }
    public static void reverseString(char[] str,int left,int right){
        if(left>=right) return;
        char tmp=str[right];
        str[right]=str[left];
        str[left]=tmp;
        // right--;
        // left++;
        reverseString(str,left+1,right-1);
    }
}