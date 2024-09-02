

class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // code here
        int count=0;
        func(s,count,sizeOfStack);
    }
    
    public static void func(Stack<Integer> s,int count,int size){
        if(count==size/2){
            s.pop();
            return;
        }
        
        //pop a temp push it later once the mid is deleted
        int temp=s.pop();
        
        //Recursive call
        func(s,count+1,size);
        
        //once the mid is deleted we will push back the temp
        s.push(temp);
        
    }
}
