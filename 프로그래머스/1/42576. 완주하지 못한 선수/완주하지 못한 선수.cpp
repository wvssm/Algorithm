#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    map<string,int> m;
    for(auto participant_person:participant){
        m[participant_person] += 1;
    }
    
    for(auto completion_person:completion){
        m[completion_person] -= 1;
    }
    
    for(auto participant_person:participant){
        if(m[participant_person]!=0){
            answer = participant_person;
            break;
        }
        
    }
    return answer;
}