#include <string>
#include <vector>
#include <iostream>

using namespace std;
int vis[51];
int min_level = 55;

bool check(string a, string b){
    int cnt = 0;
    for(int i = 0; i < a.size(); i++){
        if(a[i]!=b[i]) cnt++;
    }
    cout << a+", "+b+"\n";
    if(cnt <= 1) return true;
    else return false;
}

void bfs(string begin, string target, vector<string> words, int level){
    if(begin == target){
        if(min_level>level) min_level = level;
        return;
    }
    
    for(int i=0; i<words.size(); i++){
        if(vis[i]==0){
            if(check(begin,words[i])){
                vis[i]=1;
                bfs(words[i],target,words,level+1);
                vis[i]=0;
            }
            else continue;
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    bfs(begin,target,words,0);   
    if(min_level == 55) return 0;
    else return min_level;
}