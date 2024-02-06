#include <string>
#include <vector>
#include <stack>
#include <cmath>
#include <iostream>


using namespace std;

bool check(long long num){
    if(num == 1) return false;
    
    for(long long i=2; i<=sqrt(num); i++){
        if(num%i==0) return false;
    }
    
    return true;
}


int solution(int n, int k) {
    int answer = 0;
    stack<int> st;
    vector<long long> sn;
    
    int num = n;
    
    while(num>0){
        st.push(num%k);
        num = num/k;
    }
    
    
   long long res_num=0;
    while(!st.empty()){
        if(st.top()==0) {
            if(res_num) sn.push_back(res_num);
            res_num = 0;
        }
        else{
             res_num = res_num*10 + (long long)st.top();
        }
        st.pop();
    }
    
    if(res_num) sn.push_back(res_num);
    
    for(int i=0; i<sn.size(); i++){
        cout << sn[i] << ' ';
        if(check(sn[i])) answer++;
    }
    
    return answer;
}