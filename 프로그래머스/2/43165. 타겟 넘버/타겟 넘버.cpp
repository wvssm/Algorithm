#include <string>
#include <vector>

using namespace std;
int answer = 0;
void dfs(vector<int> numbers, int target, int cnt, int sum){
    if(cnt==numbers.size()){
        if(sum == target) answer++;
        return;
    }
    dfs(numbers,target,cnt+1, sum+numbers[cnt]);
    dfs(numbers,target,cnt+1, sum-numbers[cnt]);
}

int solution(vector<int> numbers, int target) {
    dfs(numbers, target, 1, numbers[0]);
    dfs(numbers, target, 1, -numbers[0]);
    return answer;
}