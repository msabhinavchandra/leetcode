//the optimal approach(TC->O(1) and SC->O(n))

class MinStack {
    //we are initializing the stack
    //where that stack data structure will only store the 
    //long long datatype in them
    //for handling the edge cases
    //from -2^31 <= val <= 2^31 - 1
    stack<long long> st;
    long long mini;
    //so for solving this problem in the least SC
    // we will keep only 1 stack and a variable
    // to store the minimum element.
    // which is also in the long long format.


public:
    MinStack() {
        while(st.empty()==false) st.pop();//same constructor
        //which we had used in brute force also.
        mini=INT_MAX;//convention
        //for the minimum element we will
        //initialize to the INT_MAX and for the maximum
        //we will initialize to the INT_MIN.
    }
    
    void push(int value) {
        //int the function the argument is passed as an integer
        //but we are converting into an Long value this way
        //to handle the edge cases becuase this val might be
        //going into the mini or the stack
        //where the both elements are in them are stored in the 
        //form of long long,that is the reason we need to convert
        // the given integer into long long.
        long long val=value;
        if(st.empty()){
            //first when the stack is empty the first element is added
            // and it is stored in the mini also,because it is the
            //first
            mini=val;
            st.push(val);
        }
        else{//if the stack is not empty
        //everytime we need to check with the minimum to 
        //wither keep it the same of update it as we get new
        //data.
        if(val<mini){
            //i will push the modified value of the 
            // val that is 2*val-curr_mini into the stack and 
            //update my curr_mini.
            //and that modified value will always be less than
            //the modified_minimum only
            // because
            /* val<mini 
            val-mini<0
            adding val on both sides, and the modified mini
            is nothing but the val
            2*val-mini<val
            so therefore the modified value is always less than the
            modified minimum. 
            
            and the *1LL is very important while pushing because
            we need to convert the product into a long long
            because we are multiplying with 2 which is integer
            and val is a long long we want the resulting product 
            should be a LL cause we are subtracting from a mini
            which is also an LL so that's why we need to hard code to
            convert the given product into LL*/
            st.push(2*val*1LL-mini);
            mini=val;
        }else{//if the incoming value is not lesser than the minimum
        //then we have no issues we will just add it into the stack
        st.push(val);
        }
        }
    }
    
    void pop() {
        //if we are popping
        //popping the elements in the case where they are not the 
        //modified values is easy and simple cause in those cases
        //we need not modify the mini 
        if(st.empty()) return;
        long long el=st.top();
        st.pop();
        // if the popped element is modified or not i am 
        // checking 
        //as we know from the above ref above 
        if(el<mini){
            mini=2*mini-el;
            //2*val-(2*val-prev_mini)
            // mini=prev_mini.
        }
        // else-->need not modify.
    }
    
    int top() {
        if(st.empty()) return -1;
        long long el=st.top();
        //if it is modified the top element will be the 
        //minimum element.
        if(el<mini) return mini;
        return el;
    }
    
    int getMin() {
        return mini;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
// ----------------------------------------------------------------------------
//the brute force at first(TC->O(1) and SC->O(2n))
//we will maintain an object of 2 elements(the element,the minimum)
//a pair to be precise.
//and keep on adding to the stack and changing the minimum value
//simultaneously

class MinStack{

stack<pair<int,int>> st; 

//this will be a stack where every element will be a pair of integers
//so this is how we initialize this.

public:
 //constructor
    MinStack() {//when you declared a Minstack in an actual sense
    //it will it will actually give you a minstack by popping
    //all of the exisiting elements in case they exist.
        while(st.empty()==false) st.pop();

    }
    
    void push(int val) {
        //in the brute force we will check for the min and push
        //the required value along with the minimum till there.
        int minn;
        if(st.empty()){
            //obv if the stack it empty 
            //this is the first element 
            //which we are going to add
            minn=val;
        }
        else{//means the stack is non-empty
        //we will check the exisiting minimum with the 
        //new value and the minimum of the both
        //existing value as well as the new value
        //will be stored as the new minimum and will
        //we appended to the minimum side 
        //of the new element which is about to be 
        //pushed into the stack.
            minn=min(st.top().second,val);
        }
        //independent of both the conditions 
        //this must and should happen.
        st.push({val,minn});
        //in cpp arrays are stored in the flower 
        //brackets.

    }
    
    void pop() {
        //as normal pop only O(1) tc:
        st.pop();
    }
    
    int top() {
        return st.top().first;
        //we keep top().first because we need the first element in
        //that array, in that pair of array so
        //this is how you use the syntax.
    }
    
    int getMin() {
        return st.top().second;
    }

};

