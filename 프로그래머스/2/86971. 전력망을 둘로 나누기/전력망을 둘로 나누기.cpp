#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;
vector<int> vertex[102];
int cnt = 0;

void bfs(int begin, int exclude){
    vector<int> vis(102,0);
    queue<int> q;
    
    vis[begin] = 1;
    vis[exclude] = 1;
    
    q.push(begin);
    
    while(!q.empty()){
        int node = q.front(); q.pop();
        cnt++;
        for(int i=0; i<vertex[node].size(); i++){
            if(vis[vertex[node][i]]==0){
                vis[vertex[node][i]]=1;
                q.push(vertex[node][i]);
            }
        }
    }
}

int getDiff(int a, int b){
    if(a-b<0) return -a+b;
    return a-b;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 100;
    int gep = 0;
    
    for(auto wire:wires){
        vertex[wire[0]].push_back(wire[1]);
        vertex[wire[1]].push_back(wire[0]);
    }
    
    for(auto wire:wires){
        cnt = 0;
        int begin = wire[0];
        int exclude = wire[1];
        
        bfs(begin, exclude);
        
        gep = getDiff(cnt, n-cnt);
        if(answer>gep) answer = gep;
    }
    return answer;
}