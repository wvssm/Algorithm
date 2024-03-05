#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string s, int n) {
    string answer = "";
    for(int i=0; i<s.size(); i++){
        if(s[i]==' ') answer += s[i];
        else if(isupper(s[i])) answer += 'A'+((s[i]+n-'A')%26);
        else if(islower(s[i])) answer += 'a'+((s[i]+n-'a')%26);
    }
    return answer;
}