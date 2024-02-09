#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

vector<int> solution(string msg) {
    vector<int> answer;
    map<string,int> m;
    string alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(int i=0; i<alpha.size(); i++){
        string s = "";
        s = s + alpha[i];
        cout << s;
        m[s] = i+1;
    }
    
    int max_length = 1;
    int cnt = 26;
    for(int i=0; i<msg.size(); i++){
        for(int j=max_length; j>=1; j--){
            string word = msg.substr(i,j);
            if(m[word]!=0){
                answer.push_back(m[word]);  
                m[word+msg[i+word.size()]] = ++cnt;
                if(max_length < word.size()+1) max_length = word.size()+1;
                i = i + j - 1;
                break;
            }  
        }

    }
    
    return answer;
}