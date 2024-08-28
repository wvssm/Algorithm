// 시간 복잡도: 
// 티켓 정렬: O(NlogN)
// 백트래킹: O(N!)

// 간선의 개수 10000개 
// 1초 안에 해결안될 것 같은데 적절한 알고리즘인가?
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
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
            if(found==1) return;
            vis[i]=0;
            answer.pop_back();
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    sort(tickets.begin(), tickets.end());
    vector<string> answer;
    answer.push_back("ICN");
    
    dfs("ICN",0, tickets, answer);
    return answers[0];
}