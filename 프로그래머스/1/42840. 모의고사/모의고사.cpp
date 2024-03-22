#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

vector<int> one = {1, 2, 3, 4, 5};
vector<int> two = {2, 1, 2, 3, 2, 4, 2, 5};
vector<int> three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
vector<int> m (3,0);
vector<int> solution(vector<int> answers) {
    vector<int> answer;
    for(int i=0; i<answers.size(); i++){
        if(one[i%(one.size())] == answers[i]) m[0] += 1;
        if(two[i%(two.size())] == answers[i]) m[1] += 1;
        if(three[i%(three.size())] == answers[i]) m[2] += 1;
    }
    
    int a = *max_element(m.begin(),m.end());
    for(int i=0; i<3; i++){
        if(m[i]==a) answer.push_back(i+1);
    }
    return answer;
}