#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    char first = '1';
    int same = 0;
    int diff = 0;
    
    for(int i=0; i<s.size(); i++){
        if(same == 0 && diff == 0){
            first = s[i];
            same = 1;
        }
        else if(same == diff){
            answer++;
            same = 0;
            diff = 0;
            first = s[i];
            same = 1;
        }
        else if(first == s[i]) same++;
        else if(first != s[i]) diff++;
    }
    return answer+1;
}