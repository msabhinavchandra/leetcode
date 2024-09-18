import java.util.*;
import java.math.*;

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(factorial(n));
    }
    
    public static BigInteger factorial(int n){
        if(n==0||n==1){
            return BigInteger.ONE;
        }
        
        return BigInteger.valueOf(n).multiply(factorial(n-1));
        
       
    }
}