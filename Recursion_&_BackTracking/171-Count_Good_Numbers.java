//Brute foce O(n) loop n times

class Solution {
    public int countGoodNumbers(long n) {
        long ans=1;
        for(long i=0;i<n;i++){
            if(i%2==0) ans=ans*5%1000000007;
            else ans=ans*4%1000000007;
        }
        return (int)ans%1000000007;
    }
}

//Optimal
//iterative

class Solution {

    private static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;  // Number of even-indexed positions
        long odd = n / 2;         // Number of odd-indexed positions
        long ans = (pow(5, even) * pow(4, odd)) % MOD;
        return (int) ans;
    }

    public static long pow(long x, long n) {
        long result = 1;
        while (n > 0) {
            if ((n % 2) == 1) {  // If n is odd
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;  // Square the base
            n = n/2;            // Divide n by 2
        }
        return result;
    }
}

//Recursive
class Solution {

    private static final long MOD = 1000000007;

    public static long power(long x,long n){
        x=x%MOD;//To handle the range of the outcome.
        if(n==0) return 1;
        else if(n==1) return x%MOD;
        else if(n%2==1){
            return (x*power(x,n-1))%MOD;
        }
        return power(x*x,n/2)%MOD;
    }

    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = n / 2 + n % 2;
        return (int) ((power(5, even) * power(4, odd)) % MOD);
    }
}

