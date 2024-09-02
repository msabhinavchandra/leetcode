
class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.isEmpty()){
            return;
        }
        int temp=s.pop();
        
        reverse(s);
        
        func(s,temp);
    }
    
    public static void func(Stack<Integer> st,int x){
        if(st.isEmpty()){
            st.push(x);
            return;
        }
        int temp=st.pop();
        //recursive
        func(st,x);
        
        st.push(temp);
    }
}