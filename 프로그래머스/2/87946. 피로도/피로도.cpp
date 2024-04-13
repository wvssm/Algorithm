#include <string>
#include <vector>
#include <iostream>

using namespace std;

int vis[10];
int max_val = -1;
void dfs(int k, vector<vector<int>> dungeons, int level){
    if(level>max_val){
        max_val = level;
    }

    for(int i=0; i<dungeons.size(); i++){
        if(vis[i]==0 && dungeons[i][0]<= k){
            vis[i]=1;
            dfs(k-dungeons[i][1], dungeons, level+1);
            vis[i]=0;
        }
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    dfs(k, dungeons, 0);
    return max_val;
}

int main(){
    int k = 80;
    vector<vector<int>> dungeons = {{80,20},{50,40},{30,10}};
    cout << solution(k, dungeons);
}