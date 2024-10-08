/*
Imagine you are working on a string manipulation project, and you need to find all possible ways to split a given string into non-overlapping substrings. 
These substrings should be enclosed in curly braces {}, and you want to list all possible combinations of how the string can be divided.

Write a program that takes a string as input and returns all possible ways to group non-overlapping substrings within curly braces.

Input Format:
---------------
Line-1: A single string s consisting of lowercase or uppercase letters, numbers, or punctuation.

Output Format:
---------------
Line-1 to n: Print all possible combinations of non-overlapping substrings, each combination enclosed in curly braces {}.

Sample Input-1: 
---------------
abcd

Sample Output-1:
----------------
{abcd}
{abc}{d}
{ab}{cd}
{ab}{c}{d}
{a}{bcd}
{a}{bc}{d}
{a}{b}{cd}
{a}{b}{c}{d}

Sample Input-2: 
----------------
kmit

Sample Output-2:
-----------------
{kmit}
{kmi}{t}
{km}{it}
{km}{i}{t}
{k}{mit}
{k}{mi}{t}
{k}{m}{it}
{k}{m}{i}{t}

 */

//Recursive
//non overlapping substring
public class StringCombinations {

    // Recursive function to find all substring combinations
    public static void findSubstringCombinations(String s, String currentCombination) {
        // Base case: If the string is empty, print the current combination
        if (s.length() == 0) {
            System.out.println(currentCombination);
            return;
        }

        // Recursive case: Try splitting the string at different positions
        for (int i = 1; i <= s.length(); i++) {
            // Enclose the current substring (from the start to i) in curly braces
            String newCombination = currentCombination + "{" + s.substring(0, i) + "}";

            // Recursively find combinations for the remaining string
            findSubstringCombinations(s.substring(i), newCombination);
        }
    }

    // Main function to start the process
    public static void allCombinations(String s) {
        // Start with an empty combination
        findSubstringCombinations(s, "");
    }

    public static void main(String[] args) {
        // Sample input string
        String s = "abcd";
        
        // Generate and print all combinations
        allCombinations(s);
    }
}


//BackTracking

import java.util.ArrayList;
import java.util.List;

public class StringCombinationsBacktracking {

    // Function to generate all combinations using backtracking
    public static void backtrack(List<String> result, StringBuilder current, String s, int start) {
        // Base case: If we have traversed the entire string, add the result
        if (start == s.length()) {
            result.add(current.toString());
            return;
        }

        // Try every possible partition starting from current index
        for (int i = start + 1; i <= s.length(); i++) {
            // Capture the current partition and enclose it in curly braces
            String part = s.substring(start, i);
            int lenBefore = current.length(); // Save length before appending

            // Append the partition enclosed in curly braces
            current.append("{").append(part).append("}");

            // Recursively explore the next partitions
            backtrack(result, current, s, i);

            // Backtrack: undo the decision by resetting to previous state
            current.setLength(lenBefore);
        }
    }

    // Main function to generate all substring combinations
    public static List<String> allCombinations(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), s, 0);
        return result;
    }

    public static void main(String[] args) {
        // Sample input string
        String s = "abcd";
        
        // Generate all combinations
        List<String> combinations = allCombinations(s);
        
        // Print the results
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}

//For tessellator

import java.util.*;

class HelloWorld{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        List<String> result=new ArrayList<>();
        Substring(result,new StringBuilder(),str,0);
        Collections.reverse(result);
        for(String s:result){
            System.out.println(s);
        }
        
    }
    public static void Substring(List<String> result,StringBuilder curr,String s,int start){
        
        //if we traversed the entire string, add the result
        if(start==s.length()){
            result.add(curr.toString());
            return;
        }
        
        for(int i=start+1;i<=s.length();i++){
            String part=s.substring(start,i);
            int lenBefore=curr.length();
            
            curr.append("{").append(part).append("}");
            
            Substring(result,curr,s,i);
            
            curr.setLength(lenBefore);
        }
    }
}