// different ways of doing this problem

// college way, using linked list.

/*
Balanced paranthesis using linked list implementation

Sample Input-Output1:

Enter a string with parentheses: {{[]}}                                                                                 
The parentheses are balanced.  

Sample Input-Output2: 

Enter a string with parentheses: [}                                                                                     
The parentheses are not balanced.                                                                                       
                                                                                                                        
                                                                                                                                                                 
*/

#include<iostream>
#include<string>
using namespace std;

// initializing the node.As class object.

class node{
    public:
    char data;
    node*next;
    
    node(char val){
        data=val;
        next=NULL;
    }
};

// creating the class for a stack,
// linklist implementation of the stack

class stack{
    // data.
    node*head;
    public:
    
    // constructor
    stack(){
        head=NULL;
    }
    
    // declaring the methods
    void push(int);
    void pop();
    void display();
    bool isempty();
    int top();
    
};

// Now we are defining the methods which we declare 

// learn this basic syntax of declaring the method outside the funtion

// syntax:

// (returnType) (nameOfTheClass)::(nameOfTheMethod)(argumentsIfThere){
    
    // definition of the method.

bool stack::isempty(){
    return(head==NULL);
}

void stack::push(int val){
    node*n=new node(val);
    if(isempty()){
        // if linklist is empty
        head=n;
        return;
    }
    // stack->so insert at head.
    n->next=head;
    head=n;
    return;
    
}

void stack::pop(){
    if(isempty()){
        cout<<"Stack empty nothing to pop\n";
        return;
    }
    node*nodetobedeleted=head;
    head=head->next;
    delete nodetobedeleted;
    
}

void stack::display(){
    node*temp=head;
    while(temp){
        cout<<temp->data<<endl;
        temp=temp->next;
    }
}

int stack::top(){
    if(!isempty()){
        return head->data;
    }
    
}

bool isOpeningBracket(char chr){
    if(chr=='(' || chr=='{'|| chr=='['){
        return true;
    }
    return false;
}

bool isSameType(char chr, char bracket){
    if(chr==']'& bracket=='['){
        return true;
    }
    else if(chr=='}' && bracket=='{'){
        return true;
    }
    else if(chr==')' && bracket=='('){
        return true;
}
    return false;
}

bool isBalanced(string s){
    stack st;
    for(int i=0;s[i];i++){
        if(isOpeningBracket(s[i])){
            st.push(s[i]);
        }
        // in all those cases where it is not an opening bracket(means it is a closing bracket).
        else{//is a closing bracket
            // if the stack is non-empty and it's closing bracket matches with the opening bracket in the top.  
            if((!st.isempty()) && (isSameType(s[i],st.top()))){
                st.pop();
            }
            else{
                // yet if it is a false then , the parentheses are not valid.
                return false;
            }
        }
        }
    // if the stack is empty , then it is a valid parentheses, else it is not 
    //cuz all the brackets are not satisfied,cuz in valid parentheses ,for every
    // opening there has to be closing paretheses.
    // at every time we see an opening parentheses , we are pushing it into the stack
    //and for every opening,there has to be a closing 
    // parecntheses which we are deleting every time we see the closing, from the
    // ṛespetive stack, so we are poping that opening bracket from the stack
    // every time we see the matched paretheses.
    // hence if the stack was not empty at the end of the loop
    // then there has to be more opening parentheses, which doesn't have a closing
    // parentheses,hence it is not a valid parentheses.
    // if the stack is empty && non-empty string, then obviously at the end of the
    // loop , if the stack is empty, then the string is empty.
    return (st.isempty());
}

int main(){
    stack st;
    string s;
    cout<<"Enter a string with parentheses:";
    // this will take the line , input and store it in the string.
    getline(cin,s);
    
    if(isBalanced(s)){
        cout<<"The parentheses are balanced.";
    }
    else{
        cout<<"The parentheses are not balanced.";
    }
    
    return 0;
}


// code-studio way

/*
	Time Complexity : O(N)
	Space Complexity : O(N)

	Where 'N' is the length of the string.
*/

bool isValidParenthesis(string s) 
{   
    // Make an inbuilt stack.
    stack<char> st; 
    char x; 
  
    // Traversing int 's'.
    for (int i = 0; i < s.length(); i++)  
    { 
        if (s[i] == '(' || s[i] == '[' || s[i] == '{')  
        { 
            // Push the element in the stack .
            st.push(s[i]); 
            continue; 
        } 
  
        /* 
            If current current character is not opening 
            bracket, then it must be closing. So stack 
            cannot be empty at this point. 
        */

        if (st.empty()) 
        {
            return false; 
        }
  		
        // Store the top element.
        x = st.top(); 
        st.pop(); 
        
        // Check for opening braces in stack of corresponding closing braces.
        switch (s[i]) { 
        case ')': 
            
            if (x == '{' || x == '[') 
            {
                return false; 
            }
            break; 
  
        case '}': 
  
            if (x == '(' || x == '[') 
            {
                return false; 
            }
            break; 
  
        case ']': 
            
            if (x == '(' || x == '{')
            {
                return false;
            }
            break; 
        } 
    } 
  
    // Check Empty Stack.
    return (st.empty()); 
} 


// please do revise this later, without any cost.
































































