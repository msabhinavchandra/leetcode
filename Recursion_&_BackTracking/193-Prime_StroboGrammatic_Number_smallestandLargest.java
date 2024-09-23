/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, print all prime strobogrammatic numbers that are of length n 
and print smallest and largest strobogrammatic numbers of length n.

Input Format:
-------------
Line-1: A single integer n, representing the length of the strobogrammatic numbers to generate.

Output Format:
--------------
Line-1: Return a list of all prime strobogrammatic numbers of length n.
Line-2: Space separated two values, smallest and largest strobogrammatic numbers of length n.

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
2

Sample Output-1: 
----------------
[11]
11 96


Sample Input-2:
---------------
5

Sample Output-2: 
----------------
[16091, 18181, 19861, 61819]
10001 99866

Sample Input-3:
---------------
4

Sample Output-3: 
----------------
[]
1001 9966

NOTE: Print the results in sorted order to pass the testcases */

//Code to be tested

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int noOfDigits=sc.nextInt();
        Queue<Integer> halfAns=new LinkedList<>();
       
        List<String> Reqresult=stroboGrammatic(noOfDigits,noOfDigits);
        Collections.sort(Reqresult);
        for(String s:Reqresult){
            int typeConversion=Integer.parseInt(s);
            if(isPrime(typeConversion)) halfAns.add(typeConversion);
        }

        System.out.println(halfAns);
       
        System.out.print(Reqresult.get(0)+" "+Reqresult.get(Reqresult.size()-1));
        
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