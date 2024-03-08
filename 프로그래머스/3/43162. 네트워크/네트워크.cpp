#include <string>
#include <vector>

using namespace std;
int vis[201];

void dfs(vector<vector<int>> computers,int num){
    
    for(int i=0; i<computers[num].size(); i++){
        if(computers[num][i] ==1 && vis[i]==0){
            vis[i]=1;
            dfs(computers,i);
        }
    }
    
}
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i=0; i<computers.size(); i++){
        if(vis[i]==0){
            vis[i]=1;
            dfs(computers,i);
            answer++;
        }
    }
    return answer;
}