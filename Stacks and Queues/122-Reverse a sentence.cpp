// Online C++ compiler to run C++ program online
#include <iostream>
using namespace std;
#include<stack>

void reverseSentence(string s){
    stack<string> st;
    for(int i=0;i<s.length();i++){
        string word="";
        while(s[i]!=' ' && i<s.length()){//as a space is seen as a character.
          word+=s[i];                   //and we are iterating through the
          i++;                         //characters,checking each and every //character.
        }
        st.push(word);
}

 //reprinting the sentence in the reverse order.
 
 while(!st.empty()){
     cout<<st.top()<<" ";
     st.pop();
 }
 cout<<endl;
}

int main() {
    string s="hi, Why'd you only call me when your high!?";
    reverseSentence(s);
    // cout<<s;
    return 0;
}
