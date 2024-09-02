#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    for(int i=1; i<=yellow; i++){
        if((i+yellow/i)*2+4 == brown&&yellow%i==0) {
            if(i>yellow/i){
                answer.push_back(i+2);
                answer.push_back(yellow/i+2);
            }
            else{
                answer.push_back(yellow/i+2);
                answer.push_back(i+2);
            }
            break;
        }
    }
    return answer;
}