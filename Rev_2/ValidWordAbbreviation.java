package Rev_2;

import java.util.*;

public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
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
                    number += abbr.charAt(pa) - '0';
                    System.out.println("number " + number);
                    if (number == 0)
                        return false;
                    pa++;
                }// end of while-loop
                pw += number;
                System.out.println("pw " + pw + " pa " + pa);
            }// end of else-block
        }// end of while-loop
        System.out.println("Final pw " + pw + " pa " + pa);
        return pw == word.length() && pa == abbr.length();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(validWordAbbreviation(s, t));
    }
}
