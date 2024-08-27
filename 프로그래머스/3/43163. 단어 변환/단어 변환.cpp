#include <string>
#include <vector>

using namespace std;
int vis[51];
int min_cnt = 100;

bool isOneDiff(string a, string b){
    int cnt = 0;
    for(int i=0; i<a.size(); i++){
        if(a[i]!=b[i]) cnt++;
    }
    
    if(cnt==1) return true;
    else return false;
}

void dfs(string begin, string target, vector<string> words, int cnt){
    if(begin==target){
        if(cnt<min_cnt) min_cnt = cnt;
        return;
    }
    for(int i=0; i<words.size(); i++){
        if(vis[i]==0 && isOneDiff(begin,words[i])){
            vis[i]=1;
            dfs(words[i],target,words,cnt+1);
            vis[i]=0;
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    dfs(begin,target,words,0);
    if(min_cnt == 100) return 0;
    return min_cnt;
}