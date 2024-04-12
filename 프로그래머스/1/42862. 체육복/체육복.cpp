#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;
int vis_res[31];
int vis_lost[31];

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    answer = n - lost.size();
    cout <<"답:" << answer;
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());
    
    
    // 안가져온애들 순회
    for(int i=0; i<lost.size(); i++){
        // 여분있는 애인지 확인
        auto idx = find(reserve.begin(), reserve.end(), lost[i]);
        // 여분있는 애면
        if(idx!=reserve.end()){
            // 체육복 대여 표시
            cout << *idx;
            vis_res[lost[i]] = 1;
            answer++;
            vis_lost[lost[i]]=1;
            continue;
        }
    }
    
    for(int i=0; i<lost.size(); i++){
        if(vis_lost[lost[i]]==0){
            for(int j=0; j<reserve.size(); j++){
               //  앞 뒤 사람이면
                if(reserve[j]-1 == lost[i] || reserve[j]+1 == lost[i]){
                    if(vis_res[reserve[j]]==0){
                       vis_res[reserve[j]]=1;
                        answer++;
                        break; 
                    }
                }
            }
        }

    }
         
    return answer;
}