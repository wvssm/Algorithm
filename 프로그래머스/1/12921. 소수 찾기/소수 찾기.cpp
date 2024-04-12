#include <string>
#include <vector>
#include <iostream>
#include <cmath>
using namespace std;

int vis[1000001];
// 소수 인지 판별
bool is_prime(int n){
    int answer = 0;
    for(int i=2; i<=sqrt(n); i++){
        if(n%i==0) return false;
    }
    return true;
}


int solution(int n) {
    int answer = 0;
    for(int i=2; i<=n; i++) {
        if (vis[i] == 1) continue;

        if (is_prime(i)) {
            for (int j = 2; j <= n; j++) {
                if(j*i>n) break;
                vis[j*i] = 1;
            }
        }
    }

    for(int i=2; i<=n; i++){
        if(vis[i]==0) answer++;
    }
    return answer;
}

int main(){
    int n = 10;
    cout << solution(n);
}