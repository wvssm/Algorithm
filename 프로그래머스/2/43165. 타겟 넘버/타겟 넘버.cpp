#include <string>
#include <vector>

using namespace std;
int answer=0;
int vis[21][2];
vector<int>dx= {-1, 1};

void dfs(vector<int> numbers, int target, int sum, int level){
    if(level==numbers.size()){
        if(sum==target) answer++;
        return;
    }
    
    for(int i=0; i<2; i++){
        if(vis[level][i]==0){
            vis[level][i] = 1;
            dfs(numbers, target, sum+numbers[level]*dx[i], level+1);
            vis[level][i] = 0;
        }
    }
}

int solution(vector<int> numbers, int target) {
    dfs(numbers, target, 0, 0);
    return answer;
}