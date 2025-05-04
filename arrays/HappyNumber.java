
// TC->O(n)
//SC->O(n)
import java.util.HashSet;
import java.util.Set;

class Solution {

    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int i = num % 10;
            sum += i * i;
            num /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }
        return n == 1;
    }
}