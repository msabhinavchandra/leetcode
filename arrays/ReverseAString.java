import java.util.*;

class Strings {
    public static void main(String arg[]) {
        StringBuilder sb = new StringBuilder("HelloWorld");

        for (int i = 0; i < sb.length() / 2; i++) {
            int front = i;
            int back = sb.length() - 1 - i;

            char frontchar = sb.charAt(front);
            char backchar = sb.charAt(back);

            sb.setCharAt(front, backchar);
            sb.setCharAt(back, frontchar);
        }

        System.out.println(sb);
    }
}

// Alternate
// TC->O(n) and SC->O(1)
class Solution {
    public void reverseString(char[] s) {
        int lf = 0;
        int rt = s.length - 1;
        while (lf <= rt) {
            char temp = s[lf];
            s[lf] = s[rt];
            s[rt] = temp;
            lf++;
            rt--;
        }
    }
}