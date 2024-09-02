import java.util.*;

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    List<String> res = new ArrayList<>();
    Helper(n, new StringBuilder(), 0, res, false);
    return res;
  }

  public static void Helper(int size, StringBuilder s, int ind, List<String> result, boolean lastCharIsOne) {
      // Base case: If the current index equals the size, add the string to the result
      if (ind == size) {
          result.add(s.toString());
          return;
      }

      // Add '0' at the current index
      s.append('0');
      Helper(size, s, ind + 1, result, false);
      s.deleteCharAt(s.length() - 1); // Backtrack to remove '0'

      // Add '1' at the current index only if the last character was not '1'
      if (!lastCharIsOne) {
          s.append('1');
          Helper(size, s, ind + 1, result, true);
          s.deleteCharAt(s.length() - 1); // Backtrack to remove '1'
      }
  }

  public static void main(String[] args) {
      int n = 3;
      List<String> result = generateBinaryStrings(n);
      for (String binaryString : result) {
          System.out.print(binaryString + " ");
      }
  }
}

//Find the number of binary strings

/*Coming soon*/

//Another way

/*K : size of string 
First We Generate All string starts with '0'
initialize n = 1 . 
GenerateALLString ( K  , Str , n )
  a. IF n == K 
     PRINT str.
  b. IF previous character is '1' :: str[n-1] == '1'
     put str[n] = '0'
     GenerateAllString ( K , str , n+1 )
  c. IF previous character is '0' :: str[n-1] == '0'
     First We Put zero at end and call function 
      PUT  str[n] = '0'
           GenerateAllString ( K , str , n+1 )  
      PUT  str[n] = '1'
           GenerateAllString ( K , str , n+1 )
Second Generate all binary string starts with '1'
DO THE SAME PROCESS*/

// Java program to Generate all binary string without
// consecutive 1's of size K
import java.util.*;
import java.lang.*;

public class BinaryS {

    // Array conversion to String--
    public static String toString(char[] a) {
        String string = new String(a);
        return string;
    }

    static void generate(int k, char[] ch, int n) {
      
        // Base Condition when we 
        // reached at the end of Array**
        if (n == k) {
          
            // Printing the Generated String**
            // Return to the previous case*
            System.out.print(toString(ch)+" ");
            return;

        }
      
        // If the first Character is 
        //Zero then adding**
        if (ch[n - 1] == '0') {
            ch[n] = '0';
            generate(k, ch, n + 1);
            ch[n] = '1';
            generate(k, ch, n + 1);
        }
      
        // If the Character is One 
        // then add Zero to next**
        if (ch[n - 1] == '1') {

            ch[n] = '0';
          
            // Calling Recursively for the 
            // next value of Array
            generate(k, ch, n + 1);

        }
    }

    static void fun(int k) {

        if (k <= 0) {
            return;
        }

        char[] ch = new char[k];
      
        // Initializing first character to Zero
        ch[0] = '0';
      
        // Generating Strings starting with Zero--
        generate(k, ch, 1);

        // Initialized first Character to one--
        ch[0] = '1';
        generate(k, ch, 1);

    }

    public static void main(String args[]) {

        int k = 3;
      
        //Calling function fun with argument k
        fun(k);
      
   
    }
}


