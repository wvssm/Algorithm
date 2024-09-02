// wires를 하나씩 제외하고 bfs를 돌리면 됨
// 총 N번씩 전체 노드를 방문하기 때문에 O(N^2)의 시간복잡도를 가진다.

#include <string>
#include <vector>
#include <iostream>

using namespace std;
int cnt = 1;

void dfs(int begin, vector<int> vis, vector<vector<int>> wires){ 
    for(int i=0; i<wires.size(); i++){
        if(vis[i]==0 && wires[i][0] == begin){
            vis[i]=1;
            cout << wires[i][1];
            cnt++;
            dfs(wires[i][1], vis, wires);
        }
        
        else if(vis[i]==0 && wires[i][1] == begin){
            vis[i]=1;
            cnt++;
            cout << wires[i][0];
            dfs(wires[i][0], vis, wires);
        }
    }
}

int diff(int a, int b){
    if(a-b < 0) return -a+b;
    else return a-b;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 100;
    int value = 100;
    
    for(int i=0; i<wires.size(); i++){
        vector<int> vis(101,0);
        vis[i]=1;
        
        dfs(1,vis,wires);
        
        value = diff(n-cnt, cnt);
        if(answer>value) answer = value;
        
        cnt = 1;
        vis[i]=0;
    }
    return answer;
}