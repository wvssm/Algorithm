#include<vector>
#include<queue>
using namespace std;

int vis[101][101];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

void bfs(vector<vector<int>> maps){
    queue<pair<int,int>> q;
    q.push({0,0});
    vis[0][0]=1;
    
    while(!q.empty()){
        auto cur = q.front(); q.pop();
        
        for(int i=0; i<4; i++){
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            
            if(nx<0 || nx>=maps.size() || ny<0 || ny>=maps[0].size()) continue;
            if(vis[nx][ny]>0 || maps[nx][ny]==0) continue;
            
            vis[nx][ny] = vis[cur.first][cur.second] + 1;
            q.push({nx,ny});
        }
    }
}

int solution(vector<vector<int>> maps)
{
    int answer = 0;
    bfs(maps);
    if(vis[maps.size()-1][maps[0].size()-1] == 0) return -1;
    else return vis[maps.size()-1][maps[0].size()-1];
}