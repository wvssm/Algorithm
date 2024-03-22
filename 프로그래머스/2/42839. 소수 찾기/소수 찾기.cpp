#include <string>
#include <vector>
#include <cmath>
#include <set>

using namespace std;

int vis[10];
int cnt=0;
set<int> sosu;

bool check(int num){
    if(num == 0 || num == 1) return false;
    if(num == 2) return true;
    
    for(int i=2; i<=sqrt(num); i++){
        if(num%i==0) return false;
    }
    return true;
}

void dfs(string numbers, string num, int level){
    if(num != "" && num[0] != '0'){
        if(check(stoi(num))) {
            sosu.insert(stoi(num));
        }  
    }
    
    if(level == numbers.size()) return;
    
    for(int i=0; i<numbers.size(); i++){
        if(vis[i]==0){
            vis[i]=1;
            dfs(numbers, num+numbers[i] ,level+1);
            vis[i]=0;
        }
    }
}

int solution(string numbers) {
    int answer = 0;
    dfs(numbers, "", 0);
    return sosu.size();
}