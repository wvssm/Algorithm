#include <string>
#include <vector>
#include <set>
#include <cmath>
#include <iostream>

using namespace std;
int vis[10];
set<int> prime_numbers;

bool isPrime(int num){
    if(num == 0 || num ==1) return false;
    for(int i=2; i <= sqrt(num); i++){
        if(num%i==0) return false;
    }
    return true;
}

void dfs(string num, string numbers){
    cout << num << '\n';
    if(num != "" && isPrime(stoi(num))){
        prime_numbers.insert(stoi(num));
        //cout << num << '\n';
    }
    
    if(num.size() == numbers.size()) return;
    
    for(int i=0; i<numbers.size(); i++){
        if(vis[i]==0){
            vis[i]=1;
            num = num + numbers[i];
            dfs(num, numbers);
            num = num.substr(0,num.size()-1);
            vis[i]=0;
        }
    }
}
int solution(string numbers) {
    int answer = 0;
    for(int i=0; i<numbers.size(); i++){
        string num = "";
        if(vis[i]==0){
            vis[i]=1;
            num = num + numbers[i];
            dfs(num,numbers);
            num = num.substr(0,num.size()-2);
            vis[i]=0;
        }
    }    
    return prime_numbers.size();
}