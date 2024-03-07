#include <string>
#include <vector>

using namespace std;
vector<char> alpha = {'A','E','I','O','U'};
int total = 0;
int answer = 0;

void dfs(string word, string my_word, int level){
    total++;
    
    if(word==my_word){
        answer = total;
        return;
    }
    
    if(level == 5){
        return;
    }
    
    for(int i=0; i<alpha.size(); i++){
        dfs(word, my_word+alpha[i], level+1);
    }
}

int solution(string word) {
    dfs(word, "", 0);
    return answer-1;
}