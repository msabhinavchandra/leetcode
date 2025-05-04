
//TC->O(n) and SC->O(1)
import java.util.*;

class Solution {
    public boolean isUgly(int n) {
        if (n == 0)
            return false;
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        if (n == 1) {
            return true;
        }
        return false;

    }
}

// alternate
// O(log2(n)+log5(n)+log3(n))->TC
// Space->O(1)

class Solution2 {
    public boolean isUgly(int n) {
        if (n <= 0)
            return false;
        List<Integer> l = new ArrayList<>(Arrays.asList(2, 3, 5));
        for (int i : l)
            while (n % i == 0)
                n = n / i;
        return n == 1;
    }
}

// Alternate
class Solution3 {
    public boolean isUgly(int n) {
        if (n == 0)
            return false;
        while (n != 1) {
            if (n % 2 == 0)
                n = n / 2;
            else if (n % 3 == 0)
                n = n / 3;
            else if (n % 5 == 0)
                n = n / 5;
            else
                return false;
        }
        return true;
    }
}