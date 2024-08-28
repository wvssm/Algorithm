#include <string>
#include <vector>
#include <algorithm>


using namespace std;
//vector<int> vis(100000000,0);
int vis[100000000];
vector<vector<string>>answers;
int found = 0;

void dfs(string begin, int cnt, vector<vector<string>> tickets, vector<string> answer){
    if(cnt == tickets.size()){
        answers.push_back(answer);
        found = 1;
        return;
    }
    
    for(int i=0; i<tickets.size(); i++){
        if(vis[i]==0 && tickets[i][0]==begin){
            vis[i]=1;
            answer.push_back(tickets[i][1]);
            dfs(tickets[i][1],cnt+1,tickets,answer);
            answer.pop_back();
            vis[i]=0;
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    sort(tickets.begin(), tickets.end());
    vector<string> answer;
    for(int i=0; i<tickets.size(); i++){
        if(tickets[i][0]=="ICN"){
            vis[i]=1;
            answer.push_back(tickets[i][0]);
            answer.push_back(tickets[i][1]);
            dfs(tickets[i][1],1,tickets,answer);
            if(found==1) break;
            answer.pop_back();
            answer.pop_back();
            vis[i]=0;
        }
    }
    return answers[0];
}