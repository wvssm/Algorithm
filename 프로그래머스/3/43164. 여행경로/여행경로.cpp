#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;
int vis[10001];
vector<vector<string>> roots;
int value = 0;

void dfs(string depart,int cnt, vector<vector<string>> tickets, vector<string> root){
    if(cnt==tickets.size()){
        roots.push_back(root);
        return;
    }    
    
    for(int i=0; i<tickets.size(); i++){
        if(tickets[i][0]==depart && vis[i]==0){
            vis[i]=1;
            root.push_back(tickets[i][1]);
            dfs(tickets[i][1],cnt+1,tickets,root);
            root.pop_back();
            vis[i]=0;
        }
    }
    
}



vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    for(int i=0; i<tickets.size(); i++){
        if(tickets[i][0]=="ICN" && vis[i]==0){
            vis[i]=1;
            vector<string> root;
            root.push_back(tickets[i][0]);
            root.push_back(tickets[i][1]);
            dfs(tickets[i][1],1,tickets,root);
            root.pop_back();
            root.pop_back();
            vis[i]=0;
        } 
    }
    sort(roots.begin(),roots.end());
    return roots[0];
}