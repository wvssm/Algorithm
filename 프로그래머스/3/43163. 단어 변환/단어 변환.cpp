#include <string>
#include <iostream>
#include <vector>

using namespace std;
int min_cnt = 100;
int vis[51];

bool isOneDiff(string a, string b){
    int cnt = 0;
    for(int i=0; i<a.size(); i++){
        if(a[i]!=b[i]) cnt++;
    }
    if(cnt == 1) return true;
    else return false;
}

void dfs(string begin, string target, int cnt, vector<string> words){
    if(begin == target){
        if(cnt < min_cnt) min_cnt = cnt;
        return;
    }
    
    for(int i=0; i<words.size(); i++){  
        if(isOneDiff(begin,words[i]) && vis[i] == 0){
            vis[i]=1;
            cout<< begin << "단어 변경" << words[i] << " " << cnt << "\n";
            dfs(words[i],target,cnt+1,words);
            vis[i]=0;
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    dfs(begin,target,0,words);
    if(min_cnt == 100) return 0;
    else return min_cnt;
}