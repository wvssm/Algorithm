/*
1. 먼저 전화번호를 해시에 저장한다.
2. 전화번호를 순회하면서, 한 자리씩 추가해보면서 이미 존재하는 전화번호인지 확인한다.
시간복잡도는 O(전화번호 수*전화번호 길이)인데 전화번호수가 1000,000 이고, 전화번호 길이가 20이기 때문에 1초 안에 연산이 충분히 가능하다.
*/
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;
unordered_map<string, int> um;


bool solution(vector<string> phone_book) {
    bool answer = true;
    for(auto phone_num:phone_book){
        um[phone_num] = 1;
    }
    
    for(auto phone_num:phone_book){
        string num = "";
        for(int i=0; i<phone_num.size(); i++){
            num = num + phone_num[i];
            if(um[num]==1 && num != phone_num){
                return false;
            }
        }
    }
    return answer;
}