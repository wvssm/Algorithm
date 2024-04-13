/*
 * 관전 포인트
 * 1. 오름차순으로 입력이 주어지지 않을 수도 있다.
 * 2. 자기가 체육복이 없으면 자기가 입어야한다. 남한테 빌려줄 수 없다.*/

#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool vis[31];

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n-lost.size();
    sort(lost.begin(),lost.end());
    sort(reserve.begin(), reserve.end());

    for(int i=0; i<lost.size(); i++){
        auto cur = find(reserve.begin(),reserve.end(),lost[i]);
        if(cur!= reserve.end()){
            vis[lost[i]] = true;
            answer++;
        }
    }

    for(int i=0; i<lost.size(); i++){
        if(vis[lost[i]]) continue; // 체육복을 빌렸으면 pass
        for(int j=0; j<reserve.size(); j++){
            if(!vis[reserve[j]]){
                if(reserve[j]-1 == lost[i] || reserve[j]+1 == lost[i]){
                    vis[reserve[j]]=true;
                    answer++;
                    break;
                }
            }
        }
    }
    return answer;
}

int main(){
    int n = 3;
    vector<int> lost ={3};
    vector<int> reserve = {1};
    int answer = solution(n, lost, reserve);
    cout << answer;
}