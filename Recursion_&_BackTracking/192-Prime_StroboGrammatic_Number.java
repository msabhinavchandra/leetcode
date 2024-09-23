/*A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, check is n is strobogrammatic number and prime strobogrammatic number.

Input Format:
-------------
Line-1: A single integer n.

Output Format:
--------------
Line-1: Space separated two boolean values, represents "is strobogrammatic number" and "is prime strobogrammatic number".

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
1001

Sample Output-1: 
----------------
true false


Sample Input-2:
---------------
101

Sample Output-2: 
----------------
true true

Sample Input-3:
---------------
9999

Sample Output-3: 
----------------
false false
 */

//To be checked in the kmitonline.com

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int noOfDigits=str.length();
        int number=Integer.parseInt(str);
        List<String> Reqresult=stroboGrammatic(noOfDigits,noOfDigits);
        System.out.print(Reqresult.contains(str)+" ");
        if(Reqresult.contains(str) && isPrime(number)) System.out.print(true);
        else System.out.print(false);
        
    }
    
    public static List<String> stroboGrammatic(int n,int m){
        char[][] pairs={{'1','1'},{'6','9'},{'9','6'},{'8','8'}};
        //Base conditions
        if(n==0) return new ArrayList<>(Arrays.asList(""));
        if(n==1) return new ArrayList<>(Arrays.asList("1","8","0"));
        
        List<String> reference=stroboGrammatic(n-2,m);
        List<String> result=new ArrayList<>();
        
        for(int i=0;i<reference.size();i++){
            if(n!=m){
                result.add("0"+reference.get(i)+"0");
            }
            for(char[] pair:pairs){
                result.add(pair[0]+reference.get(i)+pair[1]);
            }
        }
        return result;
    }
    
    public static boolean isPrime(int n){
        int cnt=0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                cnt+=1;
                if(n/i!=i) cnt+=1;
                
            }
            if(cnt>2) break;
        }
        if(cnt==2) return true;
        return false;
    }
    
}