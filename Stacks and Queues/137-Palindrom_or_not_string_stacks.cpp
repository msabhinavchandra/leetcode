#include<iostream>
#include<bits/stdc++.h>
using namespace std;

bool isPalindrome(string s){
    int length =s.size();

    //creating a stack
    stack<char> st;
    //finding the mid
    // int i
    int mid=length/2;
    int i=mid;

    for(int j=0;j<mid;j++){
        st.push(s[j]);
    }
    //if length of the string is odd then neglect the middle character.
    if(length%2!=0){
        i++;
    }//otherwise, it's fine.
    char ele;

    //till the end of the string, we will keep checking from the middle to the 
    //end of the string.
    while(s[i]!='\0'){
        ele=st.top();
        st.pop();
        //if the characters differ then it is not a palindrome
        if(ele!=s[i]){
            return false;
        }
        i++;
    }
    return true;
}

int main()
{
    string s;
    // cout<<"Enter a string :"<<endl;
    // cin>>s;
    if(isPalindrome("lovevol")){
        cout<<"String is a Palindrome";
    }
    else{
        cout<<"String is not a Palindrome";
    }
    return 0;
}