#include <string>
#include <vector>

using namespace std;

vector<char> alpha = {'A','E','I','O','U'};
int cnt = -1;
int answer = 0;
void dfs(string word, string myword, int level){
    cnt++;
    if(myword==word){
        answer = cnt;
        return;
    }
    
    if(level == 5) return;
    for(int i=0; i<alpha.size(); i++){
        dfs(word, myword + alpha[i], level+1);   
    }
}

int solution(string word) {
    dfs(word, "", 0);
    return answer;
}