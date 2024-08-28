// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Helloworld {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Map<Character,Integer> tm=new LinkedHashMap<Character,Integer>();
        for(Character c:s.toCharArray()){
            int n=tm.getOrDefault(c,0)+1;
            tm.put(c,n);
        }
        System.out.println(tm);
    }
}