#include <string>
#include <vector>
#include <iostream>
#include "math.h"
#include <queue>
#include <tuple>
using namespace std;

int solution(string name) {
    int answer = 0;
    string init="";
    for(int i=0;i<name.size();i++){
       init.append("A"); 
    }
    
    queue<tuple<string,int,int> > q;
    q.push(make_tuple(init,0,0));
    
   	while(!q.empty()){
        tuple<string,int,int> cur = q.front();
       	q.pop();
        
        
       	
        string cur_string = get<0>(cur);
        int cur_idx = get<1>(cur);
        int cur_sum = get<2>(cur);
        
        if(cur_string[cur_idx] != name[cur_idx]){
        	int dif_neg = 'A' - name[cur_idx] + 26;
       		int dif_pos = name[cur_idx]-'A';
    		int tmp = abs(dif_neg) > abs(dif_pos) ? abs(dif_pos) : abs(dif_neg);
            cur_sum += tmp;
            cur_string[cur_idx] = name[cur_idx];
        }
        if(cur_string == name){
            cout << cur_string;
            return cur_sum;
        }
        else{
            int pos_idx = cur_idx + 1;
            if(pos_idx >= name.size()) pos_idx = 0;
            int neg_idx = cur_idx - 1;
            if(neg_idx < 0) neg_idx = name.size()-1;
            q.push(make_tuple(cur_string,pos_idx,cur_sum+1));
            q.push(make_tuple(cur_string,neg_idx,cur_sum+1));
        }
        
    } 
    
    return answer;
}