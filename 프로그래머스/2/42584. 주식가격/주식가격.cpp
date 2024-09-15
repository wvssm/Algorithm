#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer(prices.size(),0);
    stack<int> st;
    
    for(int i=0; i<prices.size(); i++){
        while(!st.empty() && prices[st.top()] > prices[i]){
            answer[st.top()] = i - st.top();
            st.pop();
        }
        st.push(i);
    }
    
    if(!st.empty()){
        int last_index = st.top();
        st.pop();
        
        while(!st.empty()){
            answer[st.top()] = last_index - st.top();
            st.pop();
        }
    }
    return answer;
}