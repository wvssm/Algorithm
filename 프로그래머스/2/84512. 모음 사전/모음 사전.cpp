#include <string>
#include <vector>

using namespace std;

int cnt = 0;
int answer = 0;
string moeum = "AEIOU";

void dfs(string str1, string word){
    if(str1 == word){
        answer = cnt;
        return;    
    }
    
    if(str1.size() >= 5){
        return;
    }
    
    for(int i=0; i<5; i++){
        cnt++;
        dfs(str1+moeum[i], word);
    }
}

int solution(string word) {
    dfs("", word);
    return answer;
}