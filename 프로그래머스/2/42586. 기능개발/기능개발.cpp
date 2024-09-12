#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    stack<pair<int, int>> st;
    int day = 0;
    int progress = 0;
    int speed = 0;
    int now_progress = 0;
    int cnt = 0;
    
    for(int i=speeds.size()-1; i>=0; i--){
        st.push({progresses[i], speeds[i]});
    }
    
    while(!st.empty()){
        progress = st.top().first; 
        speed = st.top().second;
        now_progress = (100 - progress) - day * speed;
        cnt = 0;
        
        if(now_progress % speed == 0){
            day += now_progress / speed;
        } else {
            day += now_progress / speed + 1;
        }
        
        while (progress + day * speed >= 100){
            st.pop();
            cnt++;
            if(st.empty()) break;
            progress = st.top().first;
            speed = st.top().second;
        }
        answer.push_back(cnt);
    }
    return answer;
}