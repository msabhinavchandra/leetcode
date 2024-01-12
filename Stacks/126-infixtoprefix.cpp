#include <iostream>
using namespace std;
#include <string>
#include <stack>
#include <algorithm>

// first you will take care of the precedence of the operators
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

string infixtoPrefix(string s)
{
    // to store the result,we need a variable.
    string res;
    // we use a stack, so...
    stack<char> st;
    // to reverse the string, we use,for using this we need an header file,
    // named, #include<algorithm>
    reverse(s.begin(), s.end());
    // now the string is reversed,we will do the same,what we did for the postfix
    // expression.
    for (int i = 0; i < s.length(); i++)
    {

        if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z'))
        {
            res += s[i];
        }
//we should have replaced, the opening to closing and closing to opening
//instead of that, we can give that functionality of an opening bracket
//to a closing one,and the functionality of a closing bracket to an opening one
// if we would have replaced them.
        else if (s[i] == ')')//you would have '(' <=> ')'
        //functionality of ( is applied to this  ) .
        //do a dry run everything will be cleared.
        {
            st.push(s[i]);
        }

        else if (s[i] == '(')
        {
            while (!st.empty() && st.top() != ')')
            {
                res += st.top();
                st.pop();
            }
            if (!st.empty() && st.top() == ')')
            {
                st.pop();
            }
        }

        else{

            //if precedence(curr) is lower than the top of the stack
            while(!st.empty() && Precedence(st.top())>Precedence(s[i])){

                res+=st.top();
                st.pop();

            }
            //when it is equal it doesn't matter at all

            //when the stack is cleared of if the curr precendence is
            // greater than or equal to the top of the stack
            st.push(s[i]);
            // in the next iterations these opeators will be added into the
            //result.


        }

        
    }
    // at the end of for loop,if there are operators left in the stack,which are 
    //needed to be popped or added into the result.
    while(!st.empty()){
        res+=st.top();
        st.pop();
    }
    // after this while loop breaks, the result will be in the form of postfix
    // we need to reverse it again, so show it in the form of prefix 
    reverse(res.begin(),res.end());
    return res;
}

int main()
    {
        cout<<infixtoPrefix("(a-b/c)*(a/k-l)");
        return 0;
    }

// output:
// *-a/bc-/akl
