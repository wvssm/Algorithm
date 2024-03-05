#include <iostream>
#include<string>
#include<stack>
using namespace std;

int solution(string s)
{
    stack<char> before;
    stack<char> now;
    
    int answer = -1;
    for(int i=s.size()-1; i>-1; i--){
        now.push(s[i]);
    }
    
    while(!now.empty()){
        if(!before.empty() && before.top()==now.top()){
            before.pop();
        }
        else{
            before.push(now.top());
        }
        now.pop();
    }
    
    if(before.empty()) return 1;
    else return 0;
}