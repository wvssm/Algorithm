#include <string>
#include <vector>
#include <iostream>

using namespace std;

int vis[201];

void dfs(int past, int me, vector<vector<int>> computers){
    vis[me] = 1;
    cout << "나등장" << me;
    for(int i=0; i<computers.size(); i++){
        if(i == me) continue;
        if(i == past) continue;
        if(vis[i]!=1 && computers[me][i] == 1){
            dfs(me,i,computers);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i=0; i<computers.size(); i++){
        if(vis[i]==1) continue;
        vis[i]=1;
        dfs(-1,i,computers);
        answer++;
    }
    return answer;
}