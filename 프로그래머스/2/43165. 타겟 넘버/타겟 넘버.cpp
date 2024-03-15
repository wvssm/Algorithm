#include <string>
#include <vector>

using namespace std;

int dx[2] = {1,-1};
int answer = 0;
void dfs(vector<int> numbers, int target, int sum, int level){
    if(level==numbers.size()){
        if(target==sum) answer++;
        return;
    }
    
    for(int i=0; i<2; i++){
        dfs(numbers,target,sum+numbers[level]*dx[i],level+1);
    }
}

int solution(vector<int> numbers, int target) {
    dfs(numbers, target, 0, 0);
    return answer;
}