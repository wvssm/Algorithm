#include<vector>
#include<queue>
using namespace std;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int vis[101][101];

int solution(vector<vector<int> > maps)
{
    int n = maps.size();
    int m = maps[0].size();
    
    queue<pair<int, int>> q;
    q.push({0,0});
    vis[0][0]=1;
    
    while(!q.empty()){
        pair<int, int> cur = q.front(); q.pop();
        
        for(int i=0; i<4; i++){
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 이 순서가 굉장히 중요
            if(vis[nx][ny] > 0 || maps[nx][ny] == 0) continue;
            
            vis[nx][ny] = vis[cur.first][cur.second] + 1;
            q.push({nx, ny});
        } 
    }
    
    if(vis[n-1][m-1]==0) return -1;
    else return vis[n-1][m-1];
}