
//User function Template for Java
class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        func(st,x);
        return st;
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