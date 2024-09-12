#include<string>
#include <iostream>
#include <stack>

using namespace std;

stack<char> st;

bool solution(string s)
{
    bool answer = true;
    
    for(auto ch : s){
        if(ch=='(') st.push('(');
        else if(ch == ')'){
            if(st.empty()) return false;
            else st.pop();
        }
    }
    if(!st.empty()) return false;
    return true;
}