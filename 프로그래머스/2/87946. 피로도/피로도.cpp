#include <string>
#include <vector>

using namespace std;
int max_count = -1;
vector<int>vis (8,0);
void dungeon(int k, vector<vector<int>> dungeons,int level){
    if(max_count<level) max_count = level;
    
    for(int i=0; i<dungeons.size(); i++){
        if(k>=dungeons[i][0] && k>=dungeons[i][1] && vis[i]==0){
            vis[i]=1;
            dungeon(k-dungeons[i][1],dungeons,level+1);
            vis[i]=0;
        }
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    dungeon(k,dungeons,0);
    answer = max_count;
    return answer;
}