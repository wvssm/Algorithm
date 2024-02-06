#include <string>
#include <vector>

using namespace std;

bool word(string s){
    int j = 0;
    char before = 'k';
    while(j<s.size()){
            if(s[j]=='a'&&before!='a'){
                if((s.substr(j,3)).compare("aya")==0){
                    j = j+3;
                    before = 'a';
                }
                else return false;
            } 
            else if(s[j]=='y'&&before!='y'){
                if((s.substr(j,2)).compare("ye")==0){
                    j = j+2;
                    before = 'y';
                }
                else return false;
            } 
            else if(s[j]=='w'&&before!='w'){
                if((s.substr(j,3)).compare("woo")==0){
                    j = j+3;
                    before = 'w';
                }
                else return false;
            } 
            else if(s[j]=='m'&&before!='m'){
                if((s.substr(j,2)).compare("ma")==0){
                    j = j+2;
                    before = 'm';
                }
                else return false;
            } 
            else return false;
    }
    return true;
}

int solution(vector<string> babbling) {
    int answer = 0;
    for(int i=0; i<babbling.size(); i++){
            if(word(babbling[i]) )answer++;
        }
    return answer;
}