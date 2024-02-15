#include <iostream>
using namespace std;
#include <stack>
#include <math.h>

int prefixEvaluation(string s)
{
    // initializing stack data structure
    stack<int> st; // using stl, which includes all the stack operations.

    for (int i = s.length() - 1; i >= 0; i--)
    { // iterating through every charater of the array from the end of it.
        // while we are iterating through the string, it will take in each iteration as a charater.
        // that's why we use ' ' single quotes in the if-else statement to check for the conditions
        // for every iteration.
        // as every character is seen as a character, every character will have a respective ascii value
        // and we only need digits(numbers) in the stack,so we will check for the range of the ascii
        // values which are digits and store the integer datatype of those numbers in the stack
        // by substracting the value of the initial ascii value ('0') in the every iteration.
        // the difference between the ascii values of 2 character will be an integer values
        // which will be pushed into the stack. :)

        if (s[i] >= '0' && s[i] <= '9')//operand
        { // if the char is a digit.
            st.push(s[i] - '0');
        }
        else//if this is an operator.
        { // if it is any operator instead of the digit, we need to pop the top elements
          // perform an operations and then push back into the stack again.
            int op1 = st.top();
            st.pop();
            int op2 = st.top();
            st.pop();

            switch (s[i])
            {
            case '+':
                st.push(op1 + op2);
                break;
            case '-':
                st.push(op1 - op2);
                break;
            case '*':
                st.push(op1 * op2);
                break;
            case '/':
                st.push(op1 / op2);
                break;
            case '^':
                st.push(pow(op1, op2));
                break;
            }
        }
    }
    return st.top();
}

int main()
{
    cout<<prefixEvaluation("-+7*45+20")<<endl;
    return 0;
}

//output:
// 25
