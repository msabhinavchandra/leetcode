// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Employee{
    String name;
    int age;
    Employee(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String toString(){
        return name+age;
    }
}

class c implements Comparator<Employee>{
    public int compare(Employee a,Employee b){
        return a.age-b.age;
    }
}

class d implements Comparator<Employee>{
    public int compare(Employee a,Employee b){
        return b.age-a.age;
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Employee> ls=new ArrayList<>();
        System.out.println("Enter the no of employees ");
        int n=sc.nextInt();
        // sc.nextLine();
        for(int i=0;i<n;i++){
            String s=sc.next();
            int a=sc.nextInt();
            // sc.nextLine();
            ls.add(new Employee(s,a));
        }
        System.out.println("Before "+ls);
        Collections.sort(ls,new c());
        System.out.println("After "+ls);
        Collections.sort(ls,new d());
        System.out.println("Decending "+ls);
    }
}

//2nd Problem
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
    
// class c implements Comparator<String>{
//     public int compare(String s1,String s2){
//         int cmp=
//     }
// }

class HelloWorld {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        int cnt=sc.nextInt();
        String lineT=line.trim();
        String[] words=lineT.split("\\s+");
        Map<String,Integer> mp=new HashMap<String,Integer>();
        for(String w:words){
            int f=mp.getOrDefault(w,0)+1;
            mp.put(w,f);
        }
        class c implements Comparator<String>{
        public int compare(String s1,String s2){
        int cmp=mp.get(s2)-mp.get(s1);
        if(cmp==0)
            return s1.compareTo(s2);
        return cmp;
        }
    }
        TreeMap<String,Integer> tm=new TreeMap<String,Integer>(new c());
        
        for(Map.Entry<String,Integer> e:mp.entrySet()){
            tm.put(e.getKey(),e.getValue());
        }
        
        for(Map.Entry<String,Integer> a:tm.entrySet()){
            System.out.print(a.getKey()+" ");
            cnt--;
            if(cnt==0)
                break;
        }
        
        }
}