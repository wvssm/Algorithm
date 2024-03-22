#include <string>
#include <vector>

using namespace std;
int max_dun = 0;
int vis[10];

void dfs(int k, vector<vector<int>> dungeons, int level){
    if(level>max_dun) max_dun = level;
    
    for(int i=0; i<dungeons.size(); i++){
        if(vis[i]==0 && k>=dungeons[i][0]){
            vis[i]=1;
            dfs(k-dungeons[i][1], dungeons, level+1);
            vis[i]=0;
        }
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    dfs(k, dungeons, 0);
    return max_dun;
}