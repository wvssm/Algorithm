#include<vector>
#include<queue>
using namespace std;
bool vis[101][101];
int dist[101][101];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    int n=maps.size();
    int m=maps[0].size();
    
    queue<pair<int,int>>q;
    q.push({0,0});
    vis[0][0] = 1;
    while(!q.empty()){
        pair<int,int> cur = q.front(); q.pop();
        for(int i=0; i<4; i++){
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            
            if(nx<0||nx>=n||ny<0||ny>=m) continue;
            if(vis[nx][ny]==1 || maps[nx][ny]==0) continue;
            vis[nx][ny]=1;
            dist[nx][ny] = dist[cur.first][cur.second]+1;
            q.push({nx,ny});
        }
    }
    
    if(dist[n-1][m-1]==0) return -1;
    else return dist[n-1][m-1]+1;
}