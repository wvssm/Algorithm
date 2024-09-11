#include <string>
#include <vector>
#include <stack>
#include <iostream>

// stack 사용
// 진척도를 역순으로 stack에 담음
// st.top() 진척도가 100넘은지 확인, 계속 pop, pop한 개수 answer에 저장
// stack이 빌 때까지 반복
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    stack<pair<int,int>> st;
    int cnt = 0;
    int day = 0;
    
    for(int i=speeds.size()-1; i>=0; i--){
        st.push({progresses[i], speeds[i]});
    }

    while(!st.empty()){
        cnt = 0;
        if((100-st.top().first - day* st.top().second)%st.top().second==0) day += (100-st.top().first - day* st.top().second)/st.top().second;
        else day += (100-st.top().first - day* st.top().second)/st.top().second + 1;
        
        while(st.top().first + st.top().second * day >= 100){
            cnt++;
            st.pop();
            if(st.empty()) break;
        }
        answer.push_back(cnt);
    }
    
    return answer;
}