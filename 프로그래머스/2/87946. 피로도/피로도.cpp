#include <string>
#include <vector>

using namespace std;
int max_cnt = -1;
bool vis[10];

void dfs(int k, int cnt, vector<vector<int>> dungeons){
    if(cnt > max_cnt) max_cnt = cnt;
    if(cnt >= dungeons.size()) return;
    
    for(int i=0; i<dungeons.size(); i++){
        if(vis[i]==0 && k >= dungeons[i][0]){
            vis[i]=1;
            dfs(k-dungeons[i][1],cnt+1,dungeons);
            vis[i]=0;
        }
    }
    
    
}
int solution(int k, vector<vector<int>> dungeons) {
    dfs(k,0,dungeons);
    return max_cnt;
}