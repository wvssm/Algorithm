#include <string>
#include <vector>
#include <map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    map<string, int> m;
    for(int i=0; i<players.size(); i++){
        m[players[i]]=i+1;
    }
    
    int rank = 0;
    for(int i=0; i<callings.size(); i++){
        rank = m[callings[i]];
        players[rank-1] = players[rank-2];
        players[rank-2] = callings[i];
        m[callings[i]] = rank-1;
        m[players[rank-1]] = rank;
    }
    return players;
}