// 시간복잡도: O(N!*N)
// N!은 11까지는 1초만에 계산된다.
// 백트래킹을 이용한 완전탐색을 수행하였다.

#include <string>
#include <vector>
#include <cmath>
#include <set>

using namespace std;

int vis[8];
set<int> prime_numbers;


bool isPrime(int num){
    if(num<2) return false;
    if(num==2) return true;
    
    for(int i=2; i<=sqrt(num); i++){
        if(num%i==0) return false;
    } 
    return true;
}

void dfs(string num, string numbers){
    if(num.size()>numbers.size()) return;
    
    if(num!="" && isPrime(stoi(num))){
        prime_numbers.insert(stoi(num));
    }
    
    for(int i=0; i<numbers.size(); i++){
        if(vis[i]==0){
            vis[i]=1;
            dfs(num + numbers[i], numbers);
            vis[i]=0;
        }
    }
}

int solution(string numbers) {
    dfs("",numbers);
    return prime_numbers.size();
}