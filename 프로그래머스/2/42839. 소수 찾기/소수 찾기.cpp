#include <string>
#include <vector>
#include <cmath>
#include <set>

using namespace std;
vector<int>vis(7,0);
set<int> prime;
int cnt = 0;

bool is_prime(int num){
    if(num == 0) return false;
    if(num == 1) return false;
    
    for(int i=2; i<=sqrt(num); i++){
        if(num%i==0) return false;
    }
    return true;
}

void dfs(string numbers, string mynum, int level){
    
    if(mynum[0]=='0'){
        return;
    }
    
    if(mynum != ""){
        if(is_prime(stoi(mynum))) prime.insert(stoi(mynum));
    }

    if(level == numbers.size()){
        return;
    }
    
    for(int i=0; i<numbers.size(); i++){
        if(vis[i]==0){
            vis[i]=1;
            dfs(numbers, mynum+numbers[i], level+1);
            vis[i]=0;
        }
    }
}
int solution(string numbers) {
    int answer = 0;
    dfs(numbers, "", 0);
    answer = prime.size();
    return answer;
}