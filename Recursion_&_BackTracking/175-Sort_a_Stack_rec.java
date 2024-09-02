
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        hsort(s);
        return s;
    }
    
    public static void hsort(Stack<Integer> s){
        if(s.isEmpty()) return;
        int num=s.pop();
        
        hsort(s);//hoping that we receive a sorted stack
        //once we receive a sorted stack
        //we insert an element in a sortedway
        sortedInsert(s,num);//i inserted the element which i had popped to sort the stack
        //back in to the stack
        
    }
    
    public static void sortedInsert(Stack<Integer> s,int x){
        if(s.isEmpty()||(!s.isEmpty()&& s.peek()<x)){
            s.push(x);
            return;
        }
        
        int num=s.pop();
        sortedInsert(s,x);//after i inserted an element into an exiting sorted stack
        
        //just push whatever you had popped to insert an element and keep it
        //where it belongs
        s.push(num);
        //sending the stack the way i received it at the first.
        
    }
}