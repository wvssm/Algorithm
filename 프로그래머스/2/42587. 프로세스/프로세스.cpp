// priorities copy, 오름차순으로 정렬

#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    
    vector<int> my_prior = priorities;
    sort(my_prior.begin(), my_prior.end(), greater<>());
    
    vector<pair<int,int>> q;
    for(int i=0; i< priorities.size(); i++){
        q.push_back({priorities[i] ,i});
    }
    
    int prior_cur = 0;
    int cur = 0;
    
    while(prior_cur < my_prior.size()){
        if(my_prior[prior_cur] == q[cur].first){
            if(q[cur].second == location) return prior_cur+1;
            cur++;
            prior_cur++;
        } else{
            q.push_back(q[cur]);
            cur++;
        }
    }
    
    return answer;
}