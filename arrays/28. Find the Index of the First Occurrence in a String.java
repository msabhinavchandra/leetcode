// SC->O(1)
// Brute Force
/* 
O(n * m), where:
n is the length of the haystack string.
m is the length of the needle string. */
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle,0);
    }
}

//Without using internal functions

// TC->O(m*n),length of string of the haystack*length of the needle
//SC->O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // Empty needle matches at index 0
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // Mismatch, move to next character in haystack
                }

                // Entire needle matched
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1; // Needle not found
    }

}

//using KMP u can optimize time but space will be increased, explore later.
// O(n+m)->TC and O(m)->SC
