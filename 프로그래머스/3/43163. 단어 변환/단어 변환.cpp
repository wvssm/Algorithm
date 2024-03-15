#include <string>
#include <vector>

using namespace std;

int vis[51];
int min_val = 52;
bool check(string a, string b){
    int cnt = 0;
    for(int i=0; i<a.size(); i++){
        if(a[i]!=b[i]) cnt++;
    }
    if(cnt<=1) return true;
    else return false;
}

void dfs(string begin, string target, vector<string> words, int level){
    if(begin == target){
        if(min_val>level){
            min_val = level;
        }
        return;
    }
    
    for(int i=0; i<words.size(); i++){
        if(vis[i]==0){
            if(check(begin, words[i])){
                vis[i]=1;
                dfs(words[i],target,words,level+1);
                vis[i]=0;
            }
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    dfs(begin,target,words,0);
    if(min_val == 52) return 0;
    else return min_val;
}