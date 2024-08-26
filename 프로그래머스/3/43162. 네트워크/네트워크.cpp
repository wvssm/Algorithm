#include <string>
#include <vector>

using namespace std;

int vis[201];

void dfs(int past, int now, vector<vector<int>> computers){
    vis[now]=1;
    for(int i=0; i<computers.size(); i++){
        if(i==past) continue;
        if(i==now) continue;
        if(vis[i]==0 && computers[now][i]==1){
            dfs(now, i, computers);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i=0; i<computers.size(); i++){
        if(vis[i]==0){
            vis[i]=1;
            dfs(0,i,computers);
            answer++;
        }
    }
    return answer;
}