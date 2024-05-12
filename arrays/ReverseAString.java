import java.util.*;

public class Strings{
    public static void main(String arg[]){
        StringBuilder sb=new StringBuilder("HelloWorld");

        for(int i=0;i<sb.length()/2;i++){
            int front=i;
            int back=sb.length-1;

            char frontchar=sb.charAt(front);
            char backchar=sb.charAt(back);

            sb.setCharAt(front,frontchar);
            sb.setCharAt(back,backchar);

        }

        System.out.println(sb);
    }
    
}