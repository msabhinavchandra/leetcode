/*Given a non-empty string s and an abbreviation abbr, 
return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of the string "word". 
Any other string is not a valid abbreviation of "word".

Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Input Format:
-------------
Line-1: A string, S contains only lowercase letters
Line-2: A string, abbr contains lowercase letters and digits

Output Format:
--------------
Line-1: A boolean value.
Sample Input-1:
---------------
internationalization
i12iz4n

Sample Output-1:
---------------
true

Sample Input-2:
---------------
apple
a2e

Sample Output-2:
---------------
false

Time Complexity: O(n) where n=max(len(word),len(abbr))
Auxiliary Space:  O(1). */
import java.util.*;

class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int pw = 0;
        int pa = 0;
        while (pw < word.length() && pa < abbr.length()) {
            // characters should match 
            if (Character.isLetter(abbr.charAt(pa))) {
                if (word.charAt(pw) != abbr.charAt(pa))
                    return false; 
                pw++;
                pa++;
            } else {
                // If it is numeric, the word should get updated by that length
                int number = 0;
                while (pa < abbr.length() && Character.isDigit(abbr.charAt(pa))) {
                    number *= 10;
                    number += abbr.charAt(pa++) - '0';
                    System.out.println("number " + number);
                    if (number == 0)
                        return false;
                }
                pw += number;
                System.out.println("pw " + pw + " pa " + pa);
            }
        }
        System.out.println("Final pw " + pw + " pa " + pa);
        return pw == word.length() && pa == abbr.length();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(new ValidWordAbbreviation().validWordAbbreviation(s, t));
    }
}

//cp way

import java.util.*;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String abbr = sc.next();
        System.out.println(isValid(str, abbr));
    }
    public static boolean isValid(String str, String abbr) {
        int s = 0;
        int a = 0;

        while (s < str.length() && a < abbr.length()) {
            if (str.charAt(s) == abbr.charAt(a)) {
                s++;
                a++;
            }
            // if(str.charAt(s)!=abbr.charAt(a)){
            //     System.out.println("String "+str.charAt(s)+" abbr
            //     "+abbr.charAt(a)); return false;
            // }
            if (a < abbr.length() && Character.isDigit(abbr.charAt(a))) {
                int sum = 0;
                while (a < abbr.length() && Character.isDigit(abbr.charAt(a))) {
                    sum = sum * 10;
                    int digit = abbr.charAt(a) - '0';
                    if (digit == 0)
                        return false;
                    sum += digit;
                    a++;
                }
                s += sum;
                if (s > str.length())
                    return false;
            }
            if (s == str.length() && a == abbr.length())
                return true;
            if (s < str.length() && str.charAt(s) != abbr.charAt(a)) {
                // System.out.println("String "+str.charAt(s)+" abbr
                // "+abbr.charAt(a));
                return false;
            }
        }
        if (s == str.length() && a == abbr.length())
            return true;
        else
            return false;
    }
}
