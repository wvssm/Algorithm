#include<vector>
#include<queue>
using namespace std;

int vis[101][101];
int dist[101][101];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

void bfs(vector<vector<int> > maps){
    queue<pair<int,int>> q;
    q.push({0,0});
    vis[0][0]=1;
    
    while(!q.empty()){
        pair<int,int> cur = q.front(); q.pop();
        
        for(int i=0; i<4; i++){
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            
            if(nx<0||nx>=maps.size()||ny<0||ny>=maps[0].size()) continue;
            if(maps[nx][ny]==0 || vis[nx][ny]==1) continue;
            
            q.push({nx, ny});
            vis[nx][ny]=1;
            dist[nx][ny] = dist[cur.first][cur.second] + 1;
        }
    }
}

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    bfs(maps);
    if(dist[maps.size()-1][maps[0].size()-1]==0) return -1;
    else return dist[maps.size()-1][maps[0].size()-1]+1;
}