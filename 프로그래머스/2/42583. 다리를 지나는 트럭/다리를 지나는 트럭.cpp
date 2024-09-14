#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    queue<int> q;
    int sum = 0;
    int cnt = 1;
    int cur = 0;
    
    while(true){
        if(q.size()>=bridge_length){
            sum -= q.front();
            if(q.front() == truck_weights[truck_weights.size()-1] && cur == truck_weights.size() && sum == 0){
                return cnt;
            }
            q.pop();
        }
        
        
        if(cur < truck_weights.size() && sum + truck_weights[cur] <= weight){
            q.push(truck_weights[cur]);
            sum = sum + truck_weights[cur];
            cur++;
        } else{
            q.push(0);
        }
        cnt++;   
    }
    
    return cnt;
}