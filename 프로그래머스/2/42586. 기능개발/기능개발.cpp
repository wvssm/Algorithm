#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int g = 0;
    
    while(!progresses.empty()){
        if(progresses[0]>=100){
            progresses.erase(progresses.begin());
            speeds.erase(speeds.begin());
            g += 1;
        }
        
        else{
            if(g!=0){
                answer.push_back(g);
                g=0;
            }
            
            for(int i=0; i<progresses.size(); i++){
                progresses[i] += speeds[i];
            }
        }
    }
    answer.push_back(g);
    return answer;
}