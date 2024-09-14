#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int time = 0;
    int total_weight = 0;
    int cur = 0;
    
    queue<pair<int,int>> q;
    
    while(true){
        if(weight >= total_weight + truck_weights.at(cur)){
            total_weight += truck_weights.at(cur);
            q.push({truck_weights.at(cur), time + bridge_length + 1});
            cur++;
        }
        
        if(cur >= truck_weights.size()){
            return q.back().second;
        }
        else{
            time++;
            if(q.front().second == time + 1){
                total_weight -= q.front().first;
                q.pop();
            }
        }
    }
    return answer;
}