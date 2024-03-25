#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    map<char, int> m;
    
    for(int i=0; i<keymap.size(); i++){
        for(int j=0; j<keymap[i].size(); j++){
            if(m[keymap[i][j]]==0) m[keymap[i][j]] = j+1;
            else if(m[keymap[i][j]]>j+1) m[keymap[i][j]] = j+1;
        }
    }
    
    int cnt = 0;
    for(int i=0; i<targets.size(); i++){
        cnt = 0;
        for(int j=0; j<targets[i].size(); j++){
            if(m[targets[i][j]]==0){
                cnt = -1;
                break;
            }
            else{
                cnt += m[targets[i][j]];
            }
        }
        answer.push_back(cnt);
    }
    return answer;
}