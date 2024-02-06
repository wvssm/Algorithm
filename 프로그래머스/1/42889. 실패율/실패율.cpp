#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
bool s (pair<float,int>a, pair<float,int>b){
    if(a.first==b.first) return a.second<b.second;
    return a.first>b.first;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<float> v(502,0);
    // 가장 큰 원소를 뽑는다.
    int m_e = *max_element(stages.begin(), stages.end());
    
    // 크기 순서대로 정렬한다.
    sort(stages.begin(), stages.end());
    
    // 각 숫자의 실패율을 구한다.
    int cnt = 0;
    int total = 0;
    int before = stages[0];
    for(int i=0; i<stages.size(); i++){
        if(before != stages[i]){
            v[before] = v[before]/(stages.size()-total+cnt);
            cnt = 0;
        }
        v[stages[i]]++;
        total++;
        cnt++;
        before = stages[i];
    }
    v[before] = v[before]/(stages.size()-total+cnt);
    cnt = 0;
    
    vector<pair<float,int>> f;
    // 값이 큰 순서대로 출력을 못하겠다.
    for(int i=1; i<=N; i++){
        f.push_back({v[i],i});
    }
    sort(f.begin(),f.end(),s);
    for(int i=0; i<f.size(); i++){
        cout << f[i].first << ' ';
        answer.push_back(f[i].second);
    }
    return answer;
}