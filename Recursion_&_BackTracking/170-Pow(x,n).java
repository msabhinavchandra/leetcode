//My way
class Solution {
    public double myPow(double x, int n) {
          //your code goes here
          return func(x,n);
    }

    public static double func(double x, int n){
        if(n==0){
            return 1.0;
        }else if(n>0){
            return x*func(x,n-1);
        }
            return (1/x)*func(x,n+1);
        
       
    }
}

//Striver Brute
class Solution {
    public double myPow(double x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0) return 1; 
        // Handle negative exponents
        if (n < 0) { 
            x = 1 / x;
            n = -n;
        }
        double ans = 1;
        for (int i = 0; i < n; i++) {
            // Multiply ans by x n times
            ans *= x; 
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Output: 1024.0000
        System.out.println(sol.myPow(2.0000, 10)); 
        // Output: 0.2500
        System.out.println(sol.myPow(2.0000, -2)); 
    }
}

//optimal
 class Solution {
    private double power(double x, long n) {
        // Base case: anything raised to 0 is 1
        if (n == 0) return 1.0;
        
        // Base case: anything raised to 1 is itself
        if (n == 1) return x;
        
        // If 'n' is even
        if (n % 2 == 0) {
            // Recursive call: x * x, n / 2
            return power(x * x, n / 2);
        }
        
        // If 'n' is odd
        // Recursive call: x * power(x, n - 1)
        return x * power(x, n - 1);
    }
    
    public double myPow(double x, int n) {
        // If 'n' is negative
        if (n < 0) {
            // Calculate the power of -n and take reciprocal
            return 1.0 / power(x, -n);
        }
        
        // If 'n' is non-negative
        return power(x, n);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        double x = 2.0;
        int n = 10;

        // Calculate x raised to n
        double result = sol.myPow(x, n);

        // Print the result
        System.out.println(x + "^" + n + " = " + result);
    }
}
