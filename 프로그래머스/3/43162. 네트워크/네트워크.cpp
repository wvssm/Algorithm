#include <string>
#include <vector>

using namespace std;
vector<int> vis(201,0);
int cnt = 0;

void dfs(int n, vector<vector<int>> computers){
    
    for(int next=0; next<computers[n].size(); next++){
        if(computers[n][next]==1 && vis[next]==0){
            vis[next] = 1;
            dfs(next,computers);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i=0; i<computers.size(); i++){
       if(vis[i]==0){
           cnt++;
           vis[i]=1;
           dfs(i, computers);
       }
    }
    return cnt;
}