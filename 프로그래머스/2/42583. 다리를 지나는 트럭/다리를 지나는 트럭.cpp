#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    queue<pair<int,int>> q;
    int answer = 0;
    int total_weight = 0;
    int time = 0;
    int cur = 0;
    
    while(true){
        if(weight >= total_weight + truck_weights[cur]){
            q.push({truck_weights[cur], time + bridge_length + 1});
            total_weight += truck_weights[cur];
            cur++;
        }
        
        if(cur >= truck_weights.size()){
            return q.back().second;
        } 
        
        time++;
        
        if(time + 1 == q.front().second){
            total_weight -= q.front().first;
            q.pop();
        }
    }
    return answer;
}