#include <string>
#include <vector>
#include <iostream>

using namespace std;
vector<string> str = {"A","E","I","O","U"};
int answer = 0;
int total = 0;

void dfs(vector<string> str, string word, int cnt, string my_word){
    total++;
    //cout << my_word << " "; 
    if(my_word==word) {
        answer = total;
        return;
    }
    
    if(cnt==5){
        return;
    }
    
    for(int i=0; i<str.size(); i++){
        dfs(str,word,cnt+1,my_word+str[i]);
    }
}


int solution(string word) {
    dfs(str,word,0,"");
    return answer-1;
}