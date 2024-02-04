#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    while(true){
        int m_e = *max_element(priorities.begin(),priorities.end());
        if(priorities[0]!=m_e) {
            priorities.push_back(priorities[0]);
            if(location==0) location = priorities.size()-1;
        }
        else{
            answer++;
            if(location==0) return answer;
        }
        priorities.erase(priorities.begin());
        location--;
    }
    return answer;
}