// Naresh is working on expression of words.
// If you give him an expression like, [p,q,r]s[t,u],
// Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
// Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

// Naresh will be given an expression as a string EXP, like the above format.
// He needs to return all words that can be formed in like mentioned above, 
// Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

// NOTE: 
// Expression consist of lowercase alphabets, comma, and square brackets only.

// Input Format:
// -------------
// Line-1: A string EXP, expression.

// Output Format:
// --------------
// Line-1: Print list of words, formed from the expression.

// Sample Input-1:
// ---------------
// [b]c[e,g]k

// Sample Output-1:
// ----------------
// [bcek, bcgk]


// Sample Input-2:
// ---------------
// [a,b][c,d]

// Sample Output-2:
// ----------------
// [ac, ad, bc, bd]


// Sample Input-3:
// ---------------
// [xyz]a[b,c]

// Sample Output-3:
// ----------------
// [xyzab, xyzac]

import java.util.*;

public class BraceExpression {
    public static String[] expand(String expr) { 
        // TreeSet to sort
        TreeSet<String> set = new TreeSet<>();
        if (expr.length() == 0) {
            return new String[] {""}; 
        } else if (expr.length() == 1) {
            return new String[] {expr};
        } 
        if (expr.charAt(0) == '[') {
            int i = 0; // keep track of content in the "[content]"
            while (expr.charAt(i) != ']') {
                i++;
            }
            String sub = expr.substring(1, i);
            String[] subs = sub.split(",");
            String[] strs = expand(expr.substring(i + 1)); // dfs
            for (int j = 0; j < subs.length; j++) {
                for (String str : strs) {
                    set.add(subs[j] + str);
                }
            }
        }
        else{
            String[] strs = expand(expr.substring(1));

            for (String str : strs) {
                set.add(expr.charAt(0) + str);
            }
        }
        
        return set.toArray(new String[0]);
        //converts the TreeSet<String> named set into an array of String objects
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(Arrays.deepToString(expand(str)));
    }
}