#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer(prices.size(),0);
    stack<pair<int,int>> st;
    
    for(int i=0; i<prices.size(); i++){
        while(!st.empty() && st.top().first > prices[i]){
            answer[st.top().second] = i - st.top().second;
            st.pop();
        }
        st.push({prices[i], i});
    }
    
    if(!st.empty()){
        int final_index = st.top().second;
        st.pop();
        
        while(!st.empty()){
            answer[st.top().second] = final_index - st.top().second;
            st.pop();
        }
    }
    return answer;
}