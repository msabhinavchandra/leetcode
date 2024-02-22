#include <iostream>
using namespace std;
#include <stack>
#include <math.h>

int prec(char c){
    
    if(c=='^'){//exponent will have higher precedence than * and -
        return 3;
    }
    else if(c=='*' || c=='/'){//* and - will have the higher precedence than + and -
        return 2;
    }
    else if(c=='-'||c=='+'){
        return 1;
    }
    else{
        return -1;
    }

}

string infixtoPostfix(string s){
    stack<char> st;
    string res;
    //we are iterating through every char in the string
    //line bracket (,),operands, operators.
    for(int i=0;i<s.length();i++){

        //if it is an operand,then push it into the result.
        if((s[i]>='a' && s[i]<='z')||(s[i]>='A' && s[i]<='Z')){
            res+=s[i];
        }
        //if it is an opening bracket.
        else if(s[i]=='('){
            st.push(s[i]);
        }
        //in the iteration, if you come across the closing bracket.
        else if(s[i]==')'){//if there is a closing bracket in the string
        //means there has to be an opening bracket already present in the
        //stack,ref line no 18.
            //until you find an opening bracket in the stack, print all the 
            //operators.
            //keep this in mind you won't print that opening into the result.
            while(!st.empty() && st.top()!='('){
                res+=st.top();
                st.pop();
            }
            //there will be a point after the while loop breaks, if it is non-empty
            //it breaks because there is an opening bracket in the stack
            //at the top, so we need to pop it, whenever there is a non-empty
            //stack, even after breaking of the while loop.
            if(!st.empty()){
                st.pop();
            }
        }
        else{//if it is an operator.
        //if the stack.top() operator has higher precedence than the current operator
        //add all the operators in the stack will be added into the result.
        // then it will be added according to the precedence value only.
        while(!st.empty() && prec(st.top())>prec(s[i])){
            res+=st.top();
            st.pop();
        }//while loop breaks
        //then after doing all this , in the case where the current operator whose
        // precedence is anyhow greater than the top or equal to the st.top()'s
        //precedence,or even though it is less, after clearing the stack,the curr
        //will be pushed into the stack.
        st.push(s[i]);
        //next time when another operator will be encountered, it undergoes the 
        //similar scrutiny, and the checkpoints.
        }//end of else statement(of operators)
    }//when this for-loop breaks, we need to check-wheather the stack is 
    //empty or not.
    //at the end of for-loop we might be having more operands which are needed
    //to be appended into the result, which are still present in the stack.
    //even after for-loop breaks, we need to print all those, remaining 
    //operators into the result,they will be according to the precedence only
    //because we pushed all of them into the stack,according to the precedence
    //only.
    while (!st.empty())
    {
        res+=st.top();
        st.pop();
    }
    //after this while loop breaks,all the remaining items in the stack, which are
    //operators,will be added into the result,according to the precedence.
    
    //hence we are returning the result.

    return res;

}

int main()
{   
    cout<<infixtoPostfix("(a-b/c)*(a/k-l)")<<endl;
    return 0;
}

// output:
// abc/-ak/l-*


// REV TIME

#include <iostream>
using namespace std;
#include <stack>
#include <string>

// Precedence Table
int Precedence(char c)// i will add into stack according to the precedence and i will
//remove and add into the result according to the precedence.
{
    if (c == '^')
    {
        return 3;
    }
    else if (c == '*' || c == '/')
    {
        return 2;
    }
    else if (c == '+' || c == '-')
    {
        return 1;
    }
    else
    {
        return -1;
    }
}

string infixtoPostfix(string s)
{
    string res; // to store the result.
    stack<char> st;
    for (int i = 0; i < s.length(); i++)
    {

        if (s[i] == '(')
        {
            st.push(s[i]);
        }
        else if (s[i] == ')')
        {
            while (!st.empty() && st.top() != '(')
            {
                // add whole stack into the result.
                res += st.top();
                st.pop();
            }
            // when st.top()=='('
            if (!st.empty() && st.top()=='(')
            {
                st.pop();
            }
        }
        else if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z'))
        {
            res += s[i];
        }
        else
        {

            // if the top element of the stack's precedence is greater than the
            // current we need to print the existing operators from the
            // stack into the result.
            while (!st.empty() && Precedence(st.top()) > Precedence(s[i]))
            {
                res += st.top();
                st.pop();
            }
            // add than next operator.
            st.push(s[i]); // when the current operator is greater then the top
            // of the existing stack, or once the whole stack is empty
            // or when the peak element of the stack is '(' or ')'.
        }
    }//once the for loop ends, the remaining elements in the stack needed to 
    //be updated into the result.
    while(!st.empty()){
        res+=st.top();
        st.pop();
    }
    return res;

}

int main()
{
    cout <<infixtoPostfix("(a+b/c)*(k/j-w)");
    return 0;
}
//output:
// abc/+kj/w-*

// in code-studio problem there is not even a word which was raised regarding the associativity but it is good to have an idea 
// regarding the associativity in conversion of infix to postfix, for which you can refer kpvr's code which always
// good and well-written

// in the actual problem out thereas there is no question regarding the associativity, the associativity is only checked once
// the precedence of both the operators are same and equal, but in this case, the associativity is not at all checked

// everything in the problem went according to the assumption that right to left associativity
// all the operators are popped out from the stack even when the precedence of the curr is lesser than equal to the top of the 
// stack

//means i was actually wrong in the above, for all the operators , the following code will follow the same precedence, that is
//left to write associativity , even for the exponent(but in real,the exponent will have the associativity from right to left,
// you keep on adding elements into the stack, even when the precedence id equal,but in the case of associativity of left to 
// right you will pop the elements if you find the curr is lesser than or equal to the top of the stack)
// so that this left to right precedence is retained.

// that alternative code i was talking about.

#include <iostream>
using namespace std;
#include <string>
#include <stack>




int Precedence(char c)
{

    if (c == '^')
    {
        return 3;
    }
    else if (c == '*' || c == '/')
    {
        return 2;
    }
    else if (c == '+' || c == '-')
    {
        return 1;
    }
    else
    {
        return -1;
    }
}

char Associativity(char c){

    if(c=='^'){
        return 'R';
    }
    return 'L';
}



string infixToPostfix(string s){

    
    string result="";
    stack<char> st;

    for (int i = 0; i < s.length(); i++)
    {

        if (s[i] == '(')
        {
            st.push(s[i]);
        }
        else if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z')||(s[i]>='0' && s[i]<='9'))
        {
            result += (s[i]);
        }
        else if (s[i] == ')')
        {
            while (!st.empty() && st.top() != '(')
            {
                result += st.top();
                st.pop();
            }
            if (!st.empty() && st.top() == '(')
            {
                st.pop();
            }
        }
        else
        {
            while (!st.empty() && Precedence(st.top()) >= Precedence(s[i]))//so that the left to right associativity is retained.
            {                                                              //in the case of R ass..ty you will push it into the stack, in that
                                                                            // case so  that R ass..ty is retained.
                result += st.top();
                st.pop();
            }
            st.push(s[i]);
        }
    }
    while(!st.empty()){
        result+=st.top();
        st.pop();
    }
    return result;
	
}
