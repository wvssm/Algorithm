#include <string>
#include <vector>
#include <iostream>

using namespace std;

int plus_minus[2] = {1, -1};
int answer = 0;

void dfs(int sum, int num, int target, vector<int> numbers){
    if(num == numbers.size()){
        if(sum == target) {
            answer++;
        }
        return;
    }
    
    for(int i=0; i<2; i++){
        dfs(sum + plus_minus[i] * numbers[num], num+1, target, numbers);
    }
}

int solution(vector<int> numbers, int target) {
    dfs(0,0,target,numbers);
    return answer;
}